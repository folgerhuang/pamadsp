package com.pama.pamadsp.web.controller;

import com.pama.pamadsp.web.entity.ScheduleJob;
import com.pama.pamadsp.web.service.SchedulerJobService;
import com.pama.pamadsp.web.utils.Message;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/job/api/")
public class RestJobController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private SchedulerJobService schedulerJobService;

    @RequestMapping("/getAllJobs")
    public List<ScheduleJob> getAllJobs() {
        logger.info("[JobController] the method:getAllJobs! the url path:------------/getAllJobs----------------");
        List<ScheduleJob> jobList = schedulerJobService.getAllScheduleJob();
        logger.info("[JobController] the method:getAllJobs is execution over ");
        return jobList;
    }

    /**
     * 获取正在执行的任务列表
     *
     * @return
     * @throws SchedulerException
     */
    @RequestMapping("/getRunJob")
    public List<ScheduleJob> getAllRunningJob() throws SchedulerException {
        logger.info("[JobController] the method:getAllRunningJob! the url path:------------/getRunJob----------------");
        List<ScheduleJob> jobList = schedulerJobService.getAllRunningJob();
        logger.info("[JobController] the method:getAllRunningJob is execution over ");
        return jobList;
    }

    /**
     * 更新或者添加一个任务
     *
     * @param scheduleJob
     */
    @RequestMapping("/saveOrUpdate")
    public Object addOrUpdateJob(@RequestBody ScheduleJob scheduleJob) {
        logger.info("[JobController] the method addOrUpdateJob is start URL path:/addJob, the param:{}", scheduleJob);
        Message message = Message.failure();
        try {
            schedulerJobService.saveOrUpdate(scheduleJob);
            message = Message.success();
        } catch (Exception e) {
            message.setMsg(e.getMessage());
            logger.error("[JobController] addOrUpdateJob is failure in method:addOrUpdateJob！");
        }
        return message;
    }

    /**
     * 运行一个任务
     *
     * @param jobName
     * @param jobGroup
     */
    @RequestMapping("/runOneJob")
    public Object runJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup) {
        Message message = Message.failure();
        try {
            schedulerJobService.runOneJob(jobName, jobGroup);
            message = Message.success();
        } catch (SchedulerException e) {
            message.setMsg(e.getMessage());
        }
        return message;
    }

    /**
     * 停止一个定时任务
     *
     * @param jobName
     * @param jobGroup
     */
    @RequestMapping("/pauseJob")
    public Object pauseJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup) {
        Message message = Message.failure();
        try {
            schedulerJobService.pauseJob(jobName, jobGroup);
            message = Message.success();
        } catch (SchedulerException e) {
            message.setMsg(e.getMessage());
        }
        return message;
    }


    /**
     * 删除一个定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping("/deleteJob")
    public Object deleteJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup) {
        Message message = Message.failure();
        try {
            schedulerJobService.deleteJob(jobName, jobGroup);
            message = Message.success();
        } catch (SchedulerException e) {
            message.setMsg(e.getMessage());
        }
        return message;
    }

    /**
     * 重启一个定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping("/resumeJob")
    public Object resumeJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup) {
        Message message = Message.failure();
        try {
            schedulerJobService.resumeJob(jobName, jobGroup);
            message = Message.success();
        } catch (SchedulerException e) {
            message.setMsg(e.getMessage());
        }
        return message;
    }
}
