package com.sight.app.domain.board.comment;

import com.sight.app.domain.BaseRecordableEntity;
import com.sight.app.domain.board.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseRecordableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_seq")
    private Long commentSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_seq")
    private Board board;

    private String content;

    @Column(name = "serviceuser_seq")
    private Long writerSeq;

    public Comment(Board board, String content, Long writerSeq) {
        this.board = board;
        this.content = content;
        this.writerSeq = writerSeq;
    }
}
