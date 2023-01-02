package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {
        System.out.println("Subscribe to a flux using the error and completion hooks");

        java.util.function.Consumer<Throwable> onError = e -> System.out.println(e.getMessage());
        ReactiveSources.userFlux()
                .doOnError(onError)
                .doOnComplete(() -> System.out.println("Done getting users!"))
                .subscribe(System.out::println);

        System.out.println("Subscribe to a flux using an implementation of BaseSubscriber");
        ReactiveSources.intNumbersFlux()
                .subscribe(new SimpleSubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class SimpleSubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed!");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println("Next value = " + value);
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Done getting values!");
    }
}