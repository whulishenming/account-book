package com.lsm.accountBook.service;

import com.lsm.accountBook.domain.UserInfo;

public interface IUserInfoService {
    int insert(UserInfo record);

    UserInfo selectByOpenId(String openId);

    int updateByOpenId(UserInfo userInfo);
}
