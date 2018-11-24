package com.pama.pamadsp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PamaDspWeb {
    public static void main(String[] args) {
        SpringApplication.run(PamaDspWeb.class, args);
    }
}
