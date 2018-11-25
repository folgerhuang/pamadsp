package com.pama.pamadsp.web.controller;

import com.pama.pamadsp.web.service.imp.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(value = "/hello")
    public String sayHello(@RequestParam String name) {
        doSomeTimeCostJob doSomeTimeCostJob = new doSomeTimeCostJob();
        doSomeTimeCostJob.run();
        return "Hhello " + name + ", 你好" + System.currentTimeMillis();
    }

    class doSomeTimeCostJob implements Runnable {
        @Override
        public void run() {
            logger.info("Beging to insert one million user to table....");
            Long startTime = System.currentTimeMillis();
            userServiceImp.insertOneMillionUserToDb();
            logger.info("Finished insert one million user to table in {} s", (System.currentTimeMillis() - startTime) / 1000);
        }
    }


}
