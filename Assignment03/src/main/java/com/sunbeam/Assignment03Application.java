package com.sunbeam;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class Assignment03Application implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Assignment03Application.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public void run(String... args) {
        TcpSender ts = ctx.getBean(TcpSender.class);
        ts.send(100.0);

        HttpSender hs = ctx.getBean(HttpSender.class);
        hs.send(200.0);

        UdpSender us = ctx.getBean(UdpSender.class);
        us.send(300.0);

        
        Sender defaultSender = ctx.getBean(Sender.class);
        defaultSender.send(999.9);
    }
}
