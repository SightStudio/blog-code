package com.sight.blog.domain.department

import com.sight.blog.app.domain.company.Company
import com.sight.blog.app.domain.company.CompanyRepository
import com.sight.blog.app.domain.department.Department
import com.sight.blog.app.domain.department.DepartmentRepository
import com.sight.blog.config.test.IntegrationTestWithNoRollback
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class DepartmentDataGeneration: IntegrationTestWithNoRollback() {

    @Autowired
    lateinit var departmentRepository: DepartmentRepository

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Test
    fun `테스트 부서 데이터 생성`() {

        // scenario : 회사 2000개, 부서 뎁스 4, 부서당 직계 하위 부서 2개
        val companyCnt    = 20
        val depthCnt      = 4
        val deptPerDepth  = 2
        val deptPersistList = mutableListOf<Department>()

        for (companyIdx in 1..companyCnt) {
            val board = Company(
                name   = "회사 $companyIdx",
            )
            companyRepository.save(board)

            for (rootCommentCnt in 1..deptPerDepth) {
                recursiveDeptPersist(
                    company         = board,
                    curDepth        = 0,
                    depthLimit      = depthCnt,
                    deptPerDepth    = deptPerDepth,
                    departmentPersistList = deptPersistList
                )
            }
        }
    }

    private fun recursiveDeptPersist(company: Company,
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

            val name = if(curDepth == 0 && parentDepartment == null ) {
                "${company.seq} 회사 - root"
            } else {
                "${parentDepartment!!.name} - 의 하위부서 [$deptIdx]"
            }

            val comment = Department(
                company = company,
                depth = curDepth,
                parent = parentDepartment,
                name = name
            )
            departmentPersistList.add(departmentRepository.save(comment))

            recursiveDeptPersist(
                company = company,
                parentDepartment = comment,
                curDepth         = curDepth+1,
                depthLimit       = depthLimit,
                deptPerDepth     = deptPerDepth,
                departmentPersistList = departmentPersistList
            )
        }
    }
}