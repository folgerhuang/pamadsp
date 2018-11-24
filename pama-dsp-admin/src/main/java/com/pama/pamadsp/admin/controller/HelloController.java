package com.pama.pamadsp.admin.controller;

import com.pama.pamadsp.admin.service.HelloRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HelloRemoteService helloRemoteService;
    @RequestMapping(value= "/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        String s = helloRemoteService.sayHello(name);
        logger.info(s);
        return s;
    }

}
