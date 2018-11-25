package com.pama.pamadsp.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@MapperScan("com.pama.pamadsp.web.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class PamaDspWeb {
    public static void main(String[] args) {
        SpringApplication.run(PamaDspWeb.class, args);
    }
}
