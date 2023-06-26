package com.sight.application.jpa.config.jooq.conditions;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;

public class JooqBaseCondition {

  public static <T> Condition eq (Field<T> field1, Field<T> field2) {
    return field1.eq(field2);
  }

  public static <T> Condition eq (Field<T> field1, T value) {
    return field1.eq(value);
  }

  public static <T> Condition eqIfNotNUll (Field<T> field1, T value) {
    if (value == null) {
      return DSL.noCondition();
    }
    return field1.eq(value);
  }
}
