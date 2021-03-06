package com.pama.pamadsp.web.service;


import com.pama.pamadsp.web.entity.ScheduleJob;


/**
 * @program:
 * @description:
 * @author: SHIYU463
 * @create:
 **/
public interface ScheduleJobInService {

    int insert(ScheduleJob scheduleJob);

    int insertSelective(ScheduleJob scheduleJob);

    ScheduleJob selectByJobNameAngJobGroup(String jobName, String groupName);

    ScheduleJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ScheduleJob scheduleJob);

    int updateByExample(ScheduleJob scheduleJob);

    int deleteByPrimaryKey(Integer id);

    int deleteByJobNameAndJobGroup(String jobName, String jobGroup);


}
