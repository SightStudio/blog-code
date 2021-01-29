package com.sight.blog.app.domain.comment

import com.sight.blog.app.domain.board.Board
import com.sight.blog.common.jpa.BaseRecordableEntity
import javax.persistence.*

@Entity
class Comment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_seq")
    var seq: Long ?= null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_seq")
    var parent: Comment ?= null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_seq")
    var board: Board,

    var depth: Int,

    var content: String,

): BaseRecordableEntity()