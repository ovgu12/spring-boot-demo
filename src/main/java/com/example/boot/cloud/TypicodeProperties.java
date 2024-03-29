package com.example.boot.cloud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "typicode")
@PropertySource("classpath:typicode.properties")
@Getter
@Setter
public class TypicodeProperties {
    private String host;
    private String tags;
}
