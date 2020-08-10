import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class BackPressureTest {

    @Test
    public void subscribeTest() {
        Flux.range(0, 1000)
                .log()
                .subscribe(new MySubscriber());
    }
}

class MySubscriber implements Subscriber<Object> {

    private Subscription subscription;
    private int requestCnt;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        this.subscription.request(10);
    }

    @Override
    public void onNext(Object object) {
        requestCnt++;
        if(requestCnt % 10 == 0) {
            this.subscription.request(10);
        }
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {
        System.out.println("Subscribe Finished");
    }
}
