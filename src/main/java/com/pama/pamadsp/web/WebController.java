package com.pama.pamadsp.web;


import com.pama.pamadsp.mapper.UserMapper;
import com.pama.pamadsp.vo.UserInfoRequest;
import com.pama.pamadsp.vo.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiabin on 2017/6/17.
 */
@RestController
public class WebController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/test", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json;charset=UTF-8")
    public UserInfoResponse login(@RequestBody UserInfoRequest request){
          UserInfoResponse userInfoResponse = new UserInfoResponse();
          userInfoResponse = userMapper.getUserInfo(request);
          return userInfoResponse;
    }

}
