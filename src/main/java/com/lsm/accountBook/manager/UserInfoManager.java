package com.lsm.accountBook.manager;

import com.lsm.accountBook.constant.ResultConstant;
import com.lsm.accountBook.convert.UserInfoConverter;
import com.lsm.accountBook.domain.UserInfo;
import com.lsm.accountBook.service.IUserInfoService;
import com.lsm.accountBook.util.ParamUtils;
import com.lsm.accountBook.vo.Result;
import com.lsm.accountBook.vo.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoManager {
    @Autowired
    private IUserInfoService userInfoService;

    public Result<String> userLogin(LoginRequest request) {
        ParamUtils.notNullValidator(request, "openId");

        UserInfo userInfo = UserInfoConverter.convertToUserInfo(request);

        UserInfo existUser = userInfoService.selectByOpenId(userInfo.getOpenId());
        if (existUser == null) {
            userInfoService.insert(userInfo);
        }else{
            userInfoService.updateByOpenId(userInfo);
        }

        return new Result<>(ResultConstant.SUCCESS_CODE, ResultConstant.SUCCESS_MESSAGE, "登录成功");
    }
}
