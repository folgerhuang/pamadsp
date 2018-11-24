package com.pama.pamadsp.admin.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("pama-dsp-web-app")
public interface HelloRemoteService {
    @RequestMapping(value = "/hello")
    String sayHello(@RequestParam(value = "name") String name) ;
}
