package com.luiz.ms.email;

import com.luiz.ms.email.utils.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) {
        EnvLoader.load();
        SpringApplication.run(EmailApplication.class, args);
    }

}
