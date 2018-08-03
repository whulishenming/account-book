package com.lsm.accountBook.service.impl;

import com.lsm.accountBook.domain.UserInfo;
import com.lsm.accountBook.mapper.UserInfoMapper;
import com.lsm.accountBook.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insert(UserInfo record){
        return userInfoMapper.insert(record);
    }

    @Override
    public UserInfo selectByOpenId(String openId) {
        return userInfoMapper.selectByOpenId(openId);
    }

    @Override
    public int updateByOpenId(UserInfo userInfo) {
        return userInfoMapper.updateByOpenId(userInfo);
    }
}
