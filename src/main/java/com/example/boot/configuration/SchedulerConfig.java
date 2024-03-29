package com.example.boot.configuration;

import com.example.boot.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.stream.Collectors;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerConfig {

    private final BookRepository bookRepository;

    @Scheduled(fixedRate = 60000, initialDelay = 30000)
    public void debugRepository() {
        var books = bookRepository.queryAll();
        log.info("Authors: {}", books
                .stream()
                .map(b -> b.getAuthor().getName())
                .collect(Collectors.joining(","))
        );
    }
}
