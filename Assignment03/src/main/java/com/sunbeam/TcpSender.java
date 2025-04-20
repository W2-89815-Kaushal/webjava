package com.sunbeam;

public class TcpSender implements Sender {
    public TcpSender() {
        System.out.println("TcpSender: Constructor");
    }

    @Override
    public void send(double value) {
        System.out.println("TcpSender: Sending value = " + value);
    }
}
