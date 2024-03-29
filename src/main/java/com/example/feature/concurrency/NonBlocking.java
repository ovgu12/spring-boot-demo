package com.example.feature.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class NonBlocking {

    public static void main(String[] args) {
        final var fut = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s.concat(" World"))
                .thenAccept(log::info)
                .thenRun(() -> log.info("And Bye"));
        fut.join();
    }

}
