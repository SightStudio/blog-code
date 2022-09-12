package com.sight.entity.common;

import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class HistoryRequiredEntity {

    @CreatedDate
    @Column(name = "reg_date")
    LocalDateTime regDate;
}
