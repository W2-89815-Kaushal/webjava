package com.sunbeam;


public class UdpSender implements Sender {
    public UdpSender() {
        System.out.println("UdpSender: Constructor");
    }

    @Override
    public void send(double value) {
        System.out.println("UdpSender: Sending value = " + value);
    }
}
