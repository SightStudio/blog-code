package com.sight.application.jpa.config.jooq.conditions;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;

public class JooqStringCondition {

  public static Condition eqIfNotBlank (Field<String> field1, String value) {
    if (StringUtils.isBlank(value)) {
      return DSL.noCondition();
    }
    return field1.eq(value);
  }

  public static Condition eqIgnoreCaseIfNotNUll (Field<String> field1, String value) {
    if (StringUtils.isBlank(value)) {
      return DSL.noCondition();
    }
    return field1.equalIgnoreCase(value);
  }
}
