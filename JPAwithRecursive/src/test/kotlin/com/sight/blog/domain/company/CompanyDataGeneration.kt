package com.sight.blog.domain.company

import com.sight.blog.app.domain.company.Company
import com.sight.blog.app.domain.company.CompanyRepository
import com.sight.blog.config.test.IntegrationTestWithNoRollback
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CompanyDataGeneration: IntegrationTestWithNoRollback() {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Test @Disabled
    fun `테스트 회사 데이터 생성`() {
        val boardCnt = 2000

        // given
        for(boardWriteCnt in 1..boardCnt) {
            val board = Company(
                name   = "회사 $boardCnt",
            )
            companyRepository.save(board)
        }

        // then
    }
}