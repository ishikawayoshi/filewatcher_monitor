package com.ishikawa.fwm.fwmui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:fwm-ui.properties")
public class FwmUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwmUiApplication.class, args);
    }

}
