package com.lsm.accountBook.vo.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String openId;

    private String nickName;

    private String avatarUrl;

    private String inviterOpenId;
}
