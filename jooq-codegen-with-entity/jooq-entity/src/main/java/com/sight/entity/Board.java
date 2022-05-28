package com.sight.entity;

import com.sight.entity.common.HistoryRequiredEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "board")
@NoArgsConstructor
public class Board extends HistoryRequiredEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq", nullable = false)
    private Long boardSeq;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_type_seq", nullable = false)
    private BoardType boardType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    private AppUser writer;
}
