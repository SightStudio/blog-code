package com.sight.application.config.jooq.conditional;

import com.sight.application.app.dco.OrderBy;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.TableField;

public interface JooqSqlConditional {
  default  <T> OrderField<T> orderByField (TableField<? extends Record, T> regDateTime, OrderBy orderBy) {
    if (orderBy == OrderBy.ASC) {
      return regDateTime.asc();
    }

    if (orderBy == OrderBy.DESC) {
      return regDateTime.desc();
    }
    return null;
  }
}
