package com.sight.blog.app.domain.department

import com.blazebit.persistence.CTE
import com.sight.blog.app.domain.company.Company
import com.sight.blog.common.jpa.BaseRecordableEntity
import javax.persistence.*

@CTE
@Entity
class DepartmentCTE (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_seq")
    var seq: Long ?= null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_dept_seq")
    var parent: Department ?= null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_seq")
    var company: Company,

    var depth: Int,

    var name: String,
): BaseRecordableEntity()
