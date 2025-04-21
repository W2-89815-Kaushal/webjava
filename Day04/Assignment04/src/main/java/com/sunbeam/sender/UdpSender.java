package com.sunbeam.sender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UdpSender implements Sender {
    @Override
    public void send(double value) {
        System.out.println("UDP Sender: " + value);
    }
}
