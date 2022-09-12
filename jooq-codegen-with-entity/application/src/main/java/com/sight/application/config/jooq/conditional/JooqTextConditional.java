package com.sight.application.config.jooq.conditional;

import com.sight.application.config.jooq.TextSearchWildcard;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;

public interface JooqTextConditional {
  default Condition likeIfNotEmpty(TableField<? extends Record, String> column, String searchInput, TextSearchWildcard searchWildcard) {

    if(StringUtils.isBlank(searchInput)) {
      return DSL.noCondition();
    }

    switch (searchWildcard) {
      case FULL_TEXT:
        return column.like("%" + searchInput + "%");
      case PREFIX:
        return column.like("%" + searchInput);
      case SUFFIX:
        return column.like(searchInput + "%");
      case NONE:
        return column.eq(searchInput);
    }

    return DSL.noCondition();
  }

  default Condition likeIfNotEmpty(TableField<? extends Record, String> column, String searchInput) {
    return likeIfNotEmpty(column, searchInput, TextSearchWildcard.FULL_TEXT);
  }

  default Condition eqIfNotEmpty(TableField<? extends Record, String> column, String searchInput) {
    if (StringUtils.isBlank(searchInput)) {
      return DSL.noCondition();
    }
    return column.eq(searchInput);
  }
}
