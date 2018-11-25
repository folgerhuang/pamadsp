package com.pama.pamadsp.web.job;

import org.quartz.DisallowConcurrentExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Created by SHIYU463
 */
@DisallowConcurrentExecution
@Service("helloCronJob")
public class HelloCronJob {
    private static final Logger logger = LoggerFactory.getLogger(HelloCronJob.class);

    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-ss");
    public void execute() {
        logger.info("[HelloCronJob]开始执行！");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        logger.info("----------------------------------:{}",sdf.format(new Date()));
    }
}
