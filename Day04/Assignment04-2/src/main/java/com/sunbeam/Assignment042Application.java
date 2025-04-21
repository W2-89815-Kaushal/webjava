package com.sunbeam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sunbeam.logger.AccountImpl;

@SpringBootApplication
public class Assignment042Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountImpl acc = ctx.getBean(AccountImpl.class);
        acc.deposit(1000);
        acc.withdraw(200);

        ctx.close();
	}

}
