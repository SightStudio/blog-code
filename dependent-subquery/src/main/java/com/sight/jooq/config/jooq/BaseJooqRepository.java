package com.sight.jooq.config.jooq;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.springframework.util.CollectionUtils;

import java.util.List;

public interface BaseJooqRepository {

    default Condition inIfNotEmpty(TableField<? extends Record, Integer> columnVal, List<Integer> paramVal) {
        if(CollectionUtils.isEmpty(paramVal)) {
            return DSL.noCondition();
        }
        return columnVal.in(paramVal);
    }

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
        return likeIfNotEmpty(column, searchInput, TextSearchWildcard.NONE);
    }
}
