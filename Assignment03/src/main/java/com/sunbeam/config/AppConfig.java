package com.sunbeam.config;
import com.sunbeam.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    public TcpSender tcpSender() {
        return new TcpSender();
    }

    @Bean
    public HttpSender httpSender() {
        return new HttpSender();
    }

    @Bean
    @Primary // Resolve ambiguity when injecting Sender type
    public UdpSender udpSender() {
        return new UdpSender();
    }
}
