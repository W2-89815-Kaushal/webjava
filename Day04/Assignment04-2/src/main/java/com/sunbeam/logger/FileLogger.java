package com.sunbeam.logger;

import org.springframework.stereotype.Component;

@Component
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("FileLogger: " + message);
    }
}
