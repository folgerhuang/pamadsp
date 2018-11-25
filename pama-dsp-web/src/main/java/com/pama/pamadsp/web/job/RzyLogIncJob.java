package com.pama.pamadsp.web.job;


import com.pama.pamadsp.web.entity.CommonVO;
import com.pama.pamadsp.web.mapper.UserMapper;
import com.pama.pamadsp.web.service.imp.UserServiceImp;
import org.quartz.DisallowConcurrentExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by SHIYU463
 */
@DisallowConcurrentExecution
@Service("rzyLogIncJob")
public class RzyLogIncJob {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    public UserMapper userMapper;

    public void execute() {
        logger.info("开始插入用户数据到mysql..." + new Date());
        CommonVO commonVO = userServiceImp.insertOneMillionUserToDb();
        if (commonVO.getResCode().equals("00")) {
            logger.info("完成插入用户数据到mysql..." + new Date());
        } else {
            logger.info("没有插入用户数据到mysql..." + new Date());

        }

    }
}
