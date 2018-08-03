package com.lsm.accountBook.mapper;

import com.lsm.accountBook.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {

    int insert(UserInfo record);

    UserInfo selectByOpenId(@Param("openId") String openId);

    int updateByOpenId(UserInfo userInfo);
}