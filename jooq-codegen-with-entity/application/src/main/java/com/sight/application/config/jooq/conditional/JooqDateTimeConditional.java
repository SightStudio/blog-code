package com.sight.application.config.jooq.conditional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;

public interface JooqDateTimeConditional {
  default Condition nullableBetween(TableField<? extends Record, LocalDateTime> dateTimeTableField, LocalDate startDt, LocalDate finishDt) {

    // 시작일 && 종료일 둘다 없으면 무시
    if (startDt == null && finishDt == null) {
      return DSL.noCondition();
    }

    // 시작일만 존재하면 시작일 이후로 검색
    if (startDt != null && finishDt == null) {
      return dateTimeTableField.greaterOrEqual(startDt.atTime(0, 0));
    }

    // 종료일만 존재하면 종료일 이전으로 검색
    if (startDt == null && finishDt != null) {
      return dateTimeTableField.lessOrEqual(finishDt.atTime(23, 59, 59));
    }

    return dateTimeTableField.between(startDt.atTime(0, 0), finishDt.atTime(23, 59, 59));
  }
}
