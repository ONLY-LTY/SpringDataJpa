package com.boxfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.boxfish")
public class WebAppConfig {
    
    public static void main(String[] args) {
		SpringApplication.run(WebAppConfig.class, args);
	}
}
