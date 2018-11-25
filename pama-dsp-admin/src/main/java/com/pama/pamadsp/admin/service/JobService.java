package com.pama.pamadsp.admin.service;

import com.pama.pamadsp.admin.entity.ScheduleJob;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("pama-dsp-web-app")
public interface JobService {

    @RequestMapping("/rest/job/api/getAllJobs")
    List<ScheduleJob> getAllJobs();

    @RequestMapping("rest/job/api/getAllRunningJob")
    List<ScheduleJob> getAllRunningJob();

    @RequestMapping(value = "/rest/job/api/saveOrUpdate", method = RequestMethod.POST)
    Object addOrUpdateJob(@RequestBody ScheduleJob scheduleJob);

    @RequestMapping(value = "/rest/job/api/runOneJob")
    Object runJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup);

    @RequestMapping("/rest/job/api/pauseJob")
    Object pauseJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup);

    @RequestMapping("/rest/job/api/deleteJob")
    Object deleteJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup);

    @RequestMapping("/rest/job/api/resumeJob")
    Object resumeJob(@RequestParam(value = "jobName") String jobName, @RequestParam(value = "jobGroup") String jobGroup);


}
