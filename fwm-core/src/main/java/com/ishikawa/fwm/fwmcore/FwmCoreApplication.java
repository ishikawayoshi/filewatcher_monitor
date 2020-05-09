package com.ishikawa.fwm.fwmcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:fwm-core.properties")
public class FwmCoreApplication implements CommandLineRunner {

    @Value("${test.value}")
    private String test;

    public static void main(String[] args) {
        SpringApplication.run(FwmCoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(test);
    }
}
