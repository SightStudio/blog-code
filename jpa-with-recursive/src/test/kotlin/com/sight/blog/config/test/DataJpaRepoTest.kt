package com.sight.blog.config.test

import com.sight.blog.common.jpa.criteria.CriteriaConfig
import com.sight.blog.config.TestEnv
import com.sight.blog.config.jpa.JpaTestConfig
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@Transactional
@ActiveProfiles(TestEnv.TEST)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(value = [JpaTestConfig::class, CriteriaConfig::class])
abstract class DataJpaRepoTest: BaseTest