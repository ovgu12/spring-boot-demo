package com.example.feature.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MessageConfiguration {

    /**
     * Manual create a bean
     *
     * @return helloWorldBean
     */
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    MessageBean helloWorldBean() {
        return new MessageBean();
    }

}
