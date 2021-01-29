package com.sight.blog.app.domain.board

import com.sight.blog.common.jpa.BaseRecordableEntity
import javax.persistence.*

@Entity
class Board(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq")
    var seq: Long ?= null,

    var title: String,

    var content: String,

): BaseRecordableEntity()