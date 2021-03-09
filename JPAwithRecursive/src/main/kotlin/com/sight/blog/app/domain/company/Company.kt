package com.sight.blog.app.domain.company

import com.sight.blog.common.jpa.BaseRecordableEntity
import javax.persistence.*

@Entity
class Company(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_seq")
    var seq: Long ?= null,

    var name: String,
): BaseRecordableEntity()