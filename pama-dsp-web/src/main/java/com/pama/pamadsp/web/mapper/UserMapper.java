package com.pama.pamadsp.web.mapper;

import com.pama.pamadsp.web.entity.User;
import com.pama.pamadsp.web.vo.UserInfoRequest;
import com.pama.pamadsp.web.vo.UserInfoResponse;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by SHIYU463
 */
@Mapper
public interface UserMapper {

    UserInfoResponse getUserInfo(UserInfoRequest request);
    void insertUser (User user);

/*    public void updateUser (User user);

    public void deleteUser (User user);*/
}
