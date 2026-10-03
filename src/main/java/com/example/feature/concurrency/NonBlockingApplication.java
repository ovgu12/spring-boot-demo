package com.example.feature.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class NonBlockingApplication {

    static void runTest(String message) {
        CompletableFuture.supplyAsync(() -> message);
    }

    static String failedMessage() {
        throw new RuntimeException("Failed");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> "Hello")
                .whenComplete((res, err) -> {
                    System.out.println(res);
                })
                .thenRun(() -> {
                    runTest(failedMessage());
                })
                .whenComplete((res, err) -> {
                    if (err != null) {
                        log.info("Handle error {}", err.getMessage());
                    }
                });
    }

}
