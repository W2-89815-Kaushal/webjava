package com.sunbeam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Arithmetic arith = (Arithmetic) ctx.getBean("arith");
        System.out.println("Add: " + arith.add());
        System.out.println("Subtract: " + arith.subtract());
        System.out.println("Multiply: " + arith.multiply());
        System.out.println("Divide: " + arith.divide());

        ctx.close();
    }
}
