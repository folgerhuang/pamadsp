package com.pama.pamadsp.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PamaDspAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(PamaDspAdminApp.class, args);
    }
}
