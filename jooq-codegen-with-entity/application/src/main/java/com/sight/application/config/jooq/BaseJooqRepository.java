package com.sight.application.config.jooq;

import com.sight.application.config.jooq.conditional.JooqDateTimeConditional;
import com.sight.application.config.jooq.conditional.JooqListConditional;
import com.sight.application.config.jooq.conditional.JooqNumberConditional;
import com.sight.application.config.jooq.conditional.JooqSqlConditional;
import com.sight.application.config.jooq.conditional.JooqTextConditional;

public interface BaseJooqRepository extends JooqSqlConditional, JooqTextConditional,
                                            JooqNumberConditional, JooqListConditional,
                                            JooqDateTimeConditional {
}
