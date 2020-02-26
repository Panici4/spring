package com.panici.cachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachedemoApplication.class, args);
    }

}
