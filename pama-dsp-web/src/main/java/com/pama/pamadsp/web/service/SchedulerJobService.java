package com.pama.pamadsp.web.service;

import com.pama.pamadsp.web.entity.ScheduleJob;
import org.quartz.SchedulerException;

import java.util.List;


/**
 * @program:
 * @description:
 * @author: SHIYU463
 * @create:
 **/
public interface SchedulerJobService {

    List<ScheduleJob> getAllScheduleJob();

    void checkNotNull(ScheduleJob scheduleJob);

    List<ScheduleJob> getAllRunningJob() throws SchedulerException;

    void saveOrUpdate(ScheduleJob scheduleJob) throws Exception;

    public void pauseJob(String jobName, String jobGroup) throws SchedulerException;

    public void deleteJob(String jobName, String jobGroup) throws SchedulerException;

    public void runOneJob(String jobName, String jobGroup) throws SchedulerException;

    public void resumeJob(String jobName, String jobGroup) throws SchedulerException;


}
