package com.ishikawa.fwm.fwmweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ishikawa.fwm")
public class FwmWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwmWebApplication.class, args);
    }

}
