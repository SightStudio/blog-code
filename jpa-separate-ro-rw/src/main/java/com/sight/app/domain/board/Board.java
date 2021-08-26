package com.sight.app.domain.board;

import com.sight.app.domain.BaseRecordableEntity;
import com.sight.app.domain.board.comment.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseRecordableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq")
    private Long boardSeq;

    private String title;

    private String content;

    @Column(name = "serviceuser_seq")
    private Long writerSeq;

    @OneToMany
    @JoinColumn(name = "comment_seq")
    private Set<Comment> commentList = Collections.emptySet();

    public Board(String title, String content, Long writerSeq) {
        this.title = title;
        this.content = content;
        this.writerSeq = writerSeq;
    }
}