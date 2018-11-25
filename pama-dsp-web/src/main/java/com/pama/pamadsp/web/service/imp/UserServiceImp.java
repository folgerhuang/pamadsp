package com.pama.pamadsp.web.service.imp;

import com.pama.pamadsp.web.entity.CommonVO;
import com.pama.pamadsp.web.mapper.UserMapper;
import com.pama.pamadsp.web.service.UserService;
import com.pama.pamadsp.web.utils.UserAddRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @program:
 * @description:
 * @author: SHIYU463
 * @create:
 **/
@Service
public class UserServiceImp implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserMapper userMapper;

    @Override
    public CommonVO insertOneMillionUserToDb() {
        CommonVO commonVO = new CommonVO();
        logger.info("开始插入用户数据到mysql..." + new Date());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new UserAddRunnable(userMapper));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        logger.info("完成插入用户数据到mysql..." + new Date());
        return commonVO;
    }
}
