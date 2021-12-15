package com.sight.blog.app.domain.department

import com.blazebit.persistence.CriteriaBuilderFactory
import com.blazebit.persistence.querydsl.BlazeJPAQuery
import com.querydsl.core.types.dsl.BooleanExpression
import com.sight.blog.app.domain.company.QCompany
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import javax.persistence.EntityManager

interface DepartmentRepository: JpaRepository<Department, Long>, DepartmentRepositoryCustom

interface DepartmentRepositoryCustom {
    fun findByCompanySeqWithRecursiveCte(companySeq: Long): List<DepartmentCTE>
}

class DepartmentRepositoryImpl: DepartmentRepositoryCustom,
    QuerydslRepositorySupport(Department::class.java) {

    companion object {
        private const val ROOT_DEPTH = 0
    }

    @Autowired
    lateinit var criteriaBuilderFactory: CriteriaBuilderFactory

    override fun findByCompanySeqWithRecursiveCte(companySeq: Long): List<DepartmentCTE> {
        val dept    = QDepartment.department
        val deptCTE = QDepartmentCTE.departmentCTE

        val parentDept = QDepartmentCTE("parent")

        return BlazeJPAQuery<DepartmentCTE>(entityManager, criteriaBuilderFactory)
            .withRecursive(
                deptCTE, BlazeJPAQuery<DepartmentCTE>().unionAll(

                    BlazeJPAQuery<DepartmentCTE>()
                        .from(dept)
                        .bind(deptCTE.company, dept.company)
                        .bind(deptCTE.seq, dept.seq)
                        .bind(deptCTE.name, dept.name)
                        .bind(deptCTE.depth, dept.depth)
                        .bind(deptCTE.parent, dept.parent)
                        .bind(deptCTE.createdAt, dept.createdAt)
                        .bind(deptCTE.updatedAt, dept.updatedAt)
                        .where(
                            eqCompanySeq(dept.company, companySeq),
                            eqRootDepth(dept)
                        ),

                    BlazeJPAQuery<DepartmentCTE>()
                        .from(dept)
                        .join(parentDept)
                            .on(eqComment(dept.parent, parentDept))
                        .bind(deptCTE.company, dept.company)
                        .bind(deptCTE.seq, dept.seq)
                        .bind(deptCTE.name, dept.name)
                        .bind(deptCTE.depth, dept.depth)
                        .bind(deptCTE.parent, dept.parent)
                        .bind(deptCTE.createdAt, dept.createdAt)
                        .bind(deptCTE.updatedAt, dept.updatedAt)
                )
            )
            .select(deptCTE)
            .from(deptCTE)
            .orderBy(deptCTE.depth.asc(), deptCTE.createdAt.asc())
            .fetch()
    }

    private fun eqRootDepth(dept: QDepartment): BooleanExpression? {
        return dept.depth.eq(ROOT_DEPTH)
    }

    private fun eqCompanySeq(company: QCompany, companySeq: Long): BooleanExpression? {
        return company.seq.eq(companySeq)
    }

    private fun eqComment(parent: QDepartment, parentCte: QDepartmentCTE): BooleanExpression? {
        return parent.seq.eq(parentCte.seq)
    }
}