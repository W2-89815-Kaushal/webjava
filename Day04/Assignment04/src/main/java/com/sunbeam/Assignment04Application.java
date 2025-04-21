package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sunbeam.sender.HttpSender;
import com.sunbeam.sender.Sender;
import com.sunbeam.sender.TcpSender;
import com.sunbeam.sender.UdpSender;

@SpringBootApplication
public class Assignment04Application implements CommandLineRunner {
	@Autowired
    private ApplicationContext ctx;
	public static void main(String[] args) {
		SpringApplication.run(Assignment04Application.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        TcpSender tcp = ctx.getBean(TcpSender.class);
        HttpSender http = ctx.getBean(HttpSender.class);
        UdpSender udp = ctx.getBean(UdpSender.class);

        tcp.send(10.5);
        http.send(20.75);
        udp.send(30.0);

        Sender sender = ctx.getBean(Sender.class);
        sender.send(999.99);
    }

}
