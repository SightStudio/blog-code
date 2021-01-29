package com.sight.blog.domain.comment

import com.sight.blog.app.domain.board.Board
import com.sight.blog.app.domain.board.BoardRepository
import com.sight.blog.app.domain.comment.Comment
import com.sight.blog.app.domain.comment.CommentRepository
import com.sight.blog.config.test.DataJpaRepoTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CommentRepoTest: DataJpaRepoTest() {

    @Autowired
    lateinit var commentRepository: CommentRepository

    @Autowired
    lateinit var boardRepository: BoardRepository

    @Test
    fun `JPA - 댓글 작성 후 조회 테스트`() {
        // scenario : 게시글 1개, 댓글 뎁스 3, 뎁스당 댓글 2개
        val depthCnt        = 3
        val commentPerDepth = 2
        var commentPersistList = mutableListOf<Comment>()

        // given
        val board = Board(
            title   = "게시글 제목",
            content = "댓글용 게시글"
        )
        boardRepository.save(board)

        for (rootCommentCnt in 1..commentPerDepth) {
            recursiveCommentPersist(
                board           = board,
                curDepth        = 0,
                depthLimit      = depthCnt,
                commentPerDepth = commentPerDepth,
                commentPersistList = commentPersistList
            )
        }

        // when
        val commentList = commentRepository.findByBoardSeqWithRecursiveCte(board.seq!!)

        // then

    }

    private fun recursiveCommentPersist(board:Board,
                                        parentComment: Comment? = null,
                                        curDepth: Int,
                                        depthLimit: Int,
                                        commentPerDepth: Int,
                                        commentPersistList: MutableList<Comment>
    ) {

        if(curDepth == depthLimit) {
            return
        }

        for(commentIdx in 1..commentPerDepth) {
            val comment = Comment(
                board = board,
                depth = curDepth,
                parent = parentComment,
                content = "댓글 - $curDepth 뎁스의 $commentIdx 번째 댓글"
            )
            commentPersistList.add(commentRepository.save(comment))

            recursiveCommentPersist(
                board = board,
                parentComment = comment,
                curDepth      = curDepth+1,
                depthLimit    = depthLimit,
                commentPerDepth   = commentPerDepth,
                commentPersistList = commentPersistList
            )
        }
    }
}