package com.example.feature.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class MessageBean implements Message, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String beanName;

    public void hi() {
        log.info("I am a MessageBean with a name {}", beanName);
    }

    @Override
    public void setBeanName(String name) {
        log.info("1 setBeanName");
        beanName = name;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("2 setBeanClassLoader");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("3 setApplicationContext");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("4 @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("5 afterPropertiesSet()");
    }

    public void initMethod() {
        log.info("6 initMethod()");
    }


    @PreDestroy
    public void preDestroy() {
        log.info("7 @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        log.info("8 destroy()");
    }

    public void destroyMethod() {
        log.info("9 destroyMethod()");
    }

}
