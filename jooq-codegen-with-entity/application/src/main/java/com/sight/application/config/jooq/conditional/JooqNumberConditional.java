package com.sight.application.config.jooq.conditional;

import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;

public interface JooqNumberConditional {
  default Condition eq (TableField<? extends Record, Long> column, TableField<? extends Record, Long> column2) {
    return column.eq(column2);
  }
}
