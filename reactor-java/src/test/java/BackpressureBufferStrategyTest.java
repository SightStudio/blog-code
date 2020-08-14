import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

public class BackpressureBufferStrategyTest {

    @Test
    @SetSystemProperty(key = "reactor.bufferSize.small", value = "20")
    public void 고정_길이_버퍼() throws InterruptedException {

        Flux<Object> fluxAsyncBackup = Flux.create(emitter -> {

            for (int i = 0; i < 50; i++) {
                emitter.next(i);
            }
            emitter.complete();

        }, FluxSink.OverflowStrategy.BUFFER)
        .onBackpressureBuffer(20);

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

    @Test
    @SetSystemProperty(key = "reactor.bufferSize.small", value = "20")
    public void 가변_길이_버퍼() throws InterruptedException {

        Flux<Object> fluxAsyncBackup = Flux.create(emitter -> {

            for (int i = 0; i < 50; i++) {
                emitter.next(i);
            }
            emitter.complete();

        }, FluxSink.OverflowStrategy.BUFFER);

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