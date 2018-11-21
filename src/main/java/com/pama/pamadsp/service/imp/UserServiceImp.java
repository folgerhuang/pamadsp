package com.pama.pamadsp.service.imp;

import com.pama.pamadsp.entity.User;
import com.pama.pamadsp.mapper.UserMapper;
import com.pama.pamadsp.service.UserService;
import com.pama.pamadsp.utils.CharacterUtils;
import com.pama.pamadsp.utils.UserAddRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserServiceImp implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserMapper userMapper;

    @Override
    public void insertOneMillionUserToDb() {
        logger.info("开始插入1百万条用户数据到mysql...");
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new UserAddRunnable(userMapper));
        }
        executorService.shutdown();
        logger.info("完成插入1百万条用户数据到mysql...");

    }
}
