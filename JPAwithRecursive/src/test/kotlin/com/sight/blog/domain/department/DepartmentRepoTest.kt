package com.sight.blog.domain.department

import com.sight.blog.app.domain.company.Company
import com.sight.blog.app.domain.company.CompanyRepository
import com.sight.blog.app.domain.department.Department
import com.sight.blog.app.domain.department.DepartmentRepository
import com.sight.blog.config.test.DataJpaRepoTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class DepartmentRepoTest: DataJpaRepoTest() {

    @Autowired
    lateinit var departmentRepository: DepartmentRepository

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Test
    fun `부서 생성 후 조회 테스트`() {
        // scenario : 회사 1개, 부서 뎁스 3, 부서당 하위 부서 2개
        val depthCnt        = 3
        val deptPerDepth    = 2
        val deptPersistList = mutableListOf<Department>()

        // given
        val board = Company(
            name   = "조흔 기업",
        )
        companyRepository.save(board)

        for (rootCommentCnt in 1..deptPerDepth) {
            recursiveDeptPersist(
                company         = board,
                curDepth        = 0,
                depthLimit      = depthCnt,
                deptPerDepth = deptPerDepth,
                departmentPersistList = deptPersistList
            )
        }

        // when
        val deptList = departmentRepository.findByCompanySeqWithRecursiveCte(board.seq!!)

        // then
        Assertions.assertNotEquals(0, deptList.size)
    }

    private fun recursiveDeptPersist(company:Company,
                                     parentDepartment: Department? = null,
                                     curDepth: Int,
                                     depthLimit: Int,
                                     deptPerDepth: Int,
                                     departmentPersistList: MutableList<Department>
    ) {

        if(curDepth == depthLimit) {
            return
        }

        for(deptIdx in 1..deptPerDepth) {
            val dept = Department(
                company = company,
                depth   = curDepth,
                parent  = parentDepartment,
                name = "댓글 - $curDepth 뎁스의 $deptIdx 번째 댓글"
            )
            departmentPersistList.add(departmentRepository.save(dept))

            recursiveDeptPersist(
                company = company,
                parentDepartment = dept,
                curDepth       = curDepth+1,
                depthLimit     = depthLimit,
                deptPerDepth   = deptPerDepth,
                departmentPersistList = departmentPersistList
            )
        }
    }
}