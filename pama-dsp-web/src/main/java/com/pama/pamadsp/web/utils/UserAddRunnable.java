package com.pama.pamadsp.web.utils;

import com.pama.pamadsp.web.entity.User;
import com.pama.pamadsp.web.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class UserAddRunnable implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserMapper userMapper;

    public UserAddRunnable(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread() + "->开始插入用户数据到mysql..." + new Date());

        for (int i = 0; i < 200; i++) {
            User user = new User();
            user.setUsername(CharacterUtils.getRandomString(10));
            user.setPassword(CharacterUtils.getRandomString2(15));
            userMapper.insertUser(user);
        }
        logger.info(Thread.currentThread() + "->完成插入200条用户数据到mysql..." + new Date());

    }
}
