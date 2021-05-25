package com.leiduoduo.abss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AbssApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbssApplication.class, args);
    }
}
