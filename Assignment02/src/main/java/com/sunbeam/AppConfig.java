package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public Arithmetic arith() {
        return new Arithmetic(22, 7);
    }
}
