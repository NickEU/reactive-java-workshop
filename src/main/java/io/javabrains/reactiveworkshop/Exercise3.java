package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {
        System.out.println("Get all numbers in the ReactiveSources.intNumbersFlux stream " +
                "into a List and print the list and its size");

        getListWithBlocking();
        
        getListNonBlocking();

        System.out.println("Press a key to end");
        System.in.read();
    }

    private static void getListNonBlocking() {
        System.out.println("Getting list without blocking: ");

        Mono<List<Integer>> listMono = ReactiveSources.intNumbersFlux().collectList();
        listMono.subscribe(list -> System.out.println(list + "\nSize of list: " + list.size()));
    }

    private static void getListWithBlocking() {
        System.out.println("Getting list with blocking: ");

        var numbers = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println(numbers);
        System.out.println("Size of list: " + numbers.size());
    }

}
