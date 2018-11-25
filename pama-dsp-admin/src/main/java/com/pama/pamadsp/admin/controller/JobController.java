package com.pama.pamadsp.admin.controller;

import com.pama.pamadsp.admin.entity.ScheduleJob;
import com.pama.pamadsp.admin.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/job/api")
public class JobController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JobService jobService;

    @RequestMapping("/")
    public String getAllJobs(HttpServletRequest request) {
        List<ScheduleJob> allJobs = jobService.getAllJobs();
        request.setAttribute("jobs", allJobs);
        for (ScheduleJob job :
                allJobs) {
            logger.info("定时任务描述:" + job.toString());
        }
        logger.info("[JobController] load all schedule jobs done.");
        return "index";
    }

    /**
     * 更新或者添加一个任务
     *
     * @param scheduleJob
     */
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Object addOrUpdateJob(@ModelAttribute ScheduleJob scheduleJob) {
        return jobService.addOrUpdateJob(scheduleJob);
    }


    /**
     * 运行一个任务
     *
     * @param jobName
     * @param jobGroup
     */

    @RequestMapping("/runOneJob")
    @ResponseBody
    public Object runJob(String jobName, String jobGroup) {
        return jobService.runJob(jobName, jobGroup);
    }

    /**
     * 停止一个定时任务
     *
     * @param jobName
     * @param jobGroup
     */
    @RequestMapping("/pauseJob")
    @ResponseBody
    public Object pauseJob(String jobName, String jobGroup) {
        return jobService.pauseJob(jobName, jobGroup);
    }

    /**
     * 重启一个定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @ResponseBody
    @RequestMapping("/resumeJob")
    public Object resumeJob(String jobName, String jobGroup) {
        return jobService.resumeJob(jobName, jobGroup);
    }


    /**
     * 删除一个定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping("/deleteJob")
    @ResponseBody
    public Object deleteJob(String jobName, String jobGroup) {
        return jobService.deleteJob(jobName, jobGroup);
    }


}
