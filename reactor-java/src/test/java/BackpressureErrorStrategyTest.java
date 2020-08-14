import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.nio.BufferOverflowException;
import java.time.Duration;

public class BackpressureErrorStrategyTest {

    @Test
    @SetSystemProperty(key = "reactor.bufferSize.small", value = "20")
    public void stepVerifierTest() throws InterruptedException {

        Flux<Object> fluxAsyncBackup = Flux.create(emitter -> {

            for (int i = 0; i < 50; i++) {
                emitter.next(i);
            }
            emitter.complete();

        }, FluxSink.OverflowStrategy.DROP)
        .onBackpressureDrop(droppedNum -> System.out.printf("%s | Drop reqNum %d\n", Thread.currentThread().getName(), droppedNum));

        fluxAsyncBackup
                .subscribeOn(Schedulers.elastic())
                .publishOn(Schedulers.elastic())
                .subscribe(reqNum -> {

                            System.out.printf("%s  | Received = %s\n",
                                    Thread.currentThread().getName(), reqNum);

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }, error ->
                                System.out.printf("%s  | Error = %s %s\n" ,
                                        Thread.currentThread().getName(), error.getClass().getSimpleName(), error.getMessage())
                );
        Thread.sleep(100000);
    }
}