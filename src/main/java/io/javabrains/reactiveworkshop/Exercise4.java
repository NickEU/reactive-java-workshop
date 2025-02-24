package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise4 {

    public static void main(String[] args) throws IOException {
        System.out.println("Print the value from intNumberMono when it emits");
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Integer num = ReactiveSources.intNumberMono().block(Duration.ofSeconds(5));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
