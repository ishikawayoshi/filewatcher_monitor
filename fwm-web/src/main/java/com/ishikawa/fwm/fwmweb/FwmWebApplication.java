package com.ishikawa.fwm.fwmweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ishikawa.fwm")
public class FwmWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FwmWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FwmWebApplication.class);
    }

}
