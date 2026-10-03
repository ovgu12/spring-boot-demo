package com.example.feature.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageApplication {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);

        var helloWorldBean = ctx.getBean("helloWorldBean", Message.class);
        helloWorldBean.hi();

        ctx.close();
    }

}
