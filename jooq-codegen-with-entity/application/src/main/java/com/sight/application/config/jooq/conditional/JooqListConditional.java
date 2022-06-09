package com.sight.application.config.jooq.conditional;

import java.util.List;
import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.springframework.util.CollectionUtils;

public interface JooqListConditional {
  default Condition inIfNotEmpty(TableField<? extends Record, Integer> columnVal, List<Integer> paramVal) {
    if(CollectionUtils.isEmpty(paramVal)) {
      return DSL.noCondition();
    }
    return columnVal.in(paramVal);
  }
}
