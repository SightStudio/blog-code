package com.sight.blog.domain.comment

import com.sight.blog.app.domain.board.Board
import com.sight.blog.app.domain.board.BoardRepository
import com.sight.blog.app.domain.comment.Comment
import com.sight.blog.app.domain.comment.CommentRepository
import com.sight.blog.config.test.IntegrationTestWithNoRollback
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CommentDataGeneration: IntegrationTestWithNoRollback() {

    @Autowired
    lateinit var commentRepository: CommentRepository

    @Autowired
    lateinit var boardRepository: BoardRepository

    @Test
    fun `테스트 댓글 데이터 생성`() {
        // scenario : 게시글 100개, 댓글 뎁스 30, 뎁스당 댓글 10개
        val boardCnt        = 30
        val depthCnt        = 30
        val commentPerDepth = 10
        var commentPersistList = mutableListOf<Comment>()

        // given
        val board = Board(
            title   = "게시글 제목",
            content = "댓글용 게시글"
        )
        boardRepository.save(board)

        for(boardWriteCnt in 1..boardCnt) {
            for (rootCommentCnt in 1..commentPerDepth) {
                recursiveCommentPersist(
                    board           = board,
                    curDepth        = 0,
                    depthLimit      = depthCnt,
                    commentPerDepth = commentPerDepth,
                    commentPersistList = commentPersistList
                )
            }
        }

        // then
    }

    private fun recursiveCommentPersist(board: Board,
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