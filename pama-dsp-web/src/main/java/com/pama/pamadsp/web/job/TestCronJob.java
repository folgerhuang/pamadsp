package com.pama.pamadsp.web.job;

import org.quartz.DisallowConcurrentExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SHIYU463.
 */
@DisallowConcurrentExecution
@Service("testCronJob")
public class TestCronJob {
    private static final Logger logger = LoggerFactory.getLogger(HelloCronJob.class);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-ss");

    public void execute() {
        logger.info("[TestCronJob]测试这个任务调度框架是否管用！");
        logger.info("----------------------------------:{}", sdf.format(new Date()));
    }
}
