package com.lsm.accountBook.convert;

import com.lsm.accountBook.domain.UserInfo;
import com.lsm.accountBook.vo.request.LoginRequest;

import java.util.Date;

public class UserInfoConverter {
    public static UserInfo convertToUserInfo(LoginRequest request) {
        UserInfo userInfo = new UserInfo();
        Date now = new Date();

        userInfo.setAvatarUrl(request.getAvatarUrl());
        userInfo.setCreateTime(now);
        userInfo.setInviterOpenId(request.getInviterOpenId());
        userInfo.setLastLoginTime(now);
        userInfo.setNickName(request.getNickName());
        userInfo.setOpenId(request.getOpenId());
        userInfo.setRegistrationTime(now);
        userInfo.setUpdateTime(now);

        return userInfo;
    }
}
