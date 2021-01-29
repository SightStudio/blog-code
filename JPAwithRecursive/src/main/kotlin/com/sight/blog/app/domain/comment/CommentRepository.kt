package com.sight.blog.app.domain.comment

import com.blazebit.persistence.CriteriaBuilderFactory
import com.blazebit.persistence.querydsl.BlazeJPAQuery
import com.querydsl.core.types.dsl.BooleanExpression
import com.sight.blog.app.domain.board.QBoard
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface CommentRepository: JpaRepository<Comment, Long>, CommentRepositoryCustom

interface CommentRepositoryCustom {
    fun findByBoardSeqWithRecursiveCte(boardSeq: Long): List<CommentCTE>
}

class CommentRepositoryImpl: CommentRepositoryCustom,
    QuerydslRepositorySupport(Comment::class.java) {

    companion object {
        private const val ROOT_DEPTH = 0
    }

    @Autowired
    lateinit var criteriaBuilderFactory: CriteriaBuilderFactory

    override fun findByBoardSeqWithRecursiveCte(boardSeq: Long): List<CommentCTE> {
        val board   = QBoard.board
        val comment = QComment.comment
        val commentCTE = QCommentCTE.commentCTE

        val parentComment = QCommentCTE("parent")
        val query = BlazeJPAQuery<CommentCTE>(entityManager, criteriaBuilderFactory)
            .withRecursive(commentCTE, BlazeJPAQuery<CommentCTE>().unionAll(

                BlazeJPAQuery<CommentCTE>()
                    .from(comment)
                    .bind(commentCTE.seq        , comment.seq)
                    .bind(commentCTE.content    , comment.content)
                    .bind(commentCTE.board      , comment.board)
                    .bind(commentCTE.depth      , comment.depth)
                    .bind(commentCTE.parent     , comment.parent)
                    .bind(commentCTE.createdAt  , comment.createdAt)
                    .bind(commentCTE.updatedAt  , comment.updatedAt)
                    .where(
                        eqComment(comment.parent, parentComment),
                        eqBoardSeq(comment.board, boardSeq),
                        eqRootDepth(comment)
                    ),

                BlazeJPAQuery<CommentCTE>()
                    .from(comment)
                    .join(parentComment)
                        .on(eqComment(comment.parent, parentComment))
                    .bind(commentCTE.seq        , comment.seq)
                    .bind(commentCTE.content    , comment.content)
                    .bind(commentCTE.board      , comment.board)
                    .bind(commentCTE.depth      , comment.depth)
                    .bind(commentCTE.parent     , comment.parent)
                    .bind(commentCTE.createdAt  , comment.createdAt)
                    .bind(commentCTE.updatedAt  , comment.updatedAt)
            ))
            .select(commentCTE)
            .from(commentCTE)
            .orderBy(commentCTE.seq.asc())
            .fetch()

        return query
    }

    private fun eqRootDepth(comment: QComment): BooleanExpression? {
        return comment.depth.eq(ROOT_DEPTH)
    }

    private fun eqBoardSeq(board: QBoard, boardSeq: Long): BooleanExpression? {
        return board.seq.eq(boardSeq)
    }

    private fun eqComment(parent: QComment, parentCte: QCommentCTE): BooleanExpression? {
        return parent.seq.eq(parentCte.seq)
    }
}