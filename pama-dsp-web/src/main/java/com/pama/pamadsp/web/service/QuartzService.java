package com.pama.pamadsp.web.service;

/**
 * @program:
 * @description:
 * @author: SHIYU463
 * @create:
 **/
public interface QuartzService {

    void executeTask(String beanName, String methodName);

    void executeTask(String beanName);
}
