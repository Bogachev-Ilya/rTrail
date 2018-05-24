package io.khasang.rtrail.model.impl;

import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
@Qualifier("main")
public class MessageImpl implements Message {
    private String name;

    public MessageImpl() {
    }

    public MessageImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void start() {
        saySomething();
        System.out.println("Strating...");
    }

    @Async // не дожидаясь ответа идет дальше
    public void saySomething() {
        System.err.println("there could be your advice");
    }

    @PreDestroy
    public void clean() {
        System.out.println("Ending...");
    }

    @Override
    public String getInfo() {
        return "new Bean World2!";
    }

    @Override
    public void setInfo() {
    }
}
