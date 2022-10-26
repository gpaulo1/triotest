package com.test.trio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TrioApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrioApplication.class, args);
    }

}

