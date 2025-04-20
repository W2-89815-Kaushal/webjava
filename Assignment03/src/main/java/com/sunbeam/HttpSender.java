package com.sunbeam;

public class HttpSender implements Sender {
    public HttpSender() {
        System.out.println("HttpSender: Constructor");
    }

    @Override
    public void send(double value) {
        System.out.println("HttpSender: Sending value = " + value);
    }
}
