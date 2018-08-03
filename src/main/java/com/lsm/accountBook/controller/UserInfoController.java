package com.lsm.accountBook.controller;

import com.lsm.accountBook.manager.UserInfoManager;
import com.lsm.accountBook.vo.Result;
import com.lsm.accountBook.vo.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountBook/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoManager userInfoManager;

    @PostMapping("/userLogin")
    public Result<String> userLogin(@RequestBody LoginRequest request){

        return userInfoManager.userLogin(request);
    }
}
