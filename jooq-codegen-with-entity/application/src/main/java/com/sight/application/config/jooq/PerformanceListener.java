package com.sight.application.config.jooq;

import lombok.extern.slf4j.Slf4j;
import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;
import org.jooq.tools.StopWatch;

@Slf4j
public class PerformanceListener extends DefaultExecuteListener {

    private static final long MAX_ACCEPTABLE_QUERY_TIME = 5_000_000_000L;

    StopWatch watch;

    @Override
    public void executeStart(ExecuteContext ctx) {
        super.executeStart(ctx);
         watch = new StopWatch();
    }

    @Override
    public void executeEnd(ExecuteContext ctx) {
        super.executeEnd(ctx);

        if (watch.split() > MAX_ACCEPTABLE_QUERY_TIME) {
            log.warn(String.format(
            """
                Slow Query Detected: \n
                query: %s
            """, ctx.query()), new Exception());
        }
    }
}
