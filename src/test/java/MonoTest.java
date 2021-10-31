import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    public void monoJustTest() {
        /*
        Publisher and Subscriber are interfaces.

        Mono and Flux are Publishers.
        You have to subscribe your subscribers to a publisher.
        When result comes to a Publisher, it publishes that result to all subscribers.
        It calls onNext() method of a Subscriber when result (event/signal) comes. In other words, it signals the subscribers with the result.
        If Publisher gets an error instead of a result, it calls onError() method of a Subscriber.
        Then it calls onComplete() method of a Subscriber that basically means whenever all the results are published by a publisher, publisher calls onComplete() method on each Subscriber.

        When you don't create your own Subscriber class, you have to provide code to Mono like publisher for what to do when onNext(), onError() and onComplete() methods are called.

        What kind of Publishers Mono and Flux are?
        You can call external service/Callable that returns Future and hook up its result in Mono/Flux. You can hook up subscribers to Mono/Flus.
        Whenever response will be available from external service, it will call subscribers.

        Mono - is created for handling a single result.
        Flux - is created for handling multiple results (array, list etc). It will call subscribers for every single result one by one.

         */
        {
            Mono<Integer> just = Mono.just(1).log();
            // this subscribe method will internally create a Subscriber (of type LambdaMonoSubscriber), which keeps these codes as variables in it that needs to be called when onNext(), onError() and onCompletion() methods are called.
            Disposable subscription = just.subscribe(res -> System.out.println(res),
                    res -> System.out.println(res),
                    () -> System.out.println("completion process"));
            //just.doOnSubscribe(subs -> subs.cancel());
            //just.doOnNext(res -> )
        }
        {
            Flux<Integer> just = Flux.just(1, 2, 3);
            Disposable subscription = just.subscribe(res -> System.out.println(res),
                    res -> System.out.println(res),
                    () -> System.out.println("completion process"));
            //just.doOnSubscribe(subs -> subs.cancel());
            //just.doOnNext(res -> )
        }
    }
}
