package com.luiz.ms.user;

import com.luiz.ms.user.utils.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        EnvLoader.load();
        SpringApplication.run(UserApplication.class, args);
    }

}
