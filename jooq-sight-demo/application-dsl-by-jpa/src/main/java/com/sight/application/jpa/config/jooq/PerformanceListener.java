package com.sight.application.jpa.config.jooq;

import lombok.extern.slf4j.Slf4j;
import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;
import org.jooq.tools.StopWatch;

@Slf4j
public class PerformanceListener extends DefaultExecuteListener {

    StopWatch watch;

    @Override
    public void executeStart(ExecuteContext ctx) {
        super.executeStart(ctx);
        watch = new StopWatch();
    }

    @Override
    public void executeEnd(ExecuteContext ctx) {
        super.executeEnd(ctx);
        if (watch.split() > 5_000_000_000L)
            log.warn("Slow Query Detected: \n" + ctx.query(), new Exception());
    }
}
