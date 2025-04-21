package com.sunbeam.sender;

import org.springframework.stereotype.Component;

@Component
public class TcpSender implements Sender {
    @Override
    public void send(double value) {
        System.out.println("TCP Sender: " + value);
    }
}
