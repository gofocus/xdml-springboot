package com.gofocus.demo.entity;

/**
 * @Author: GoFocus
 * @Date: 2020-06-09 11:45
 * @Description:
 */

public class LoginResult extends Result<User> {
    private boolean isLogin;

    public static LoginResult success(String msg, User user) {
        return new LoginResult(ResultStatus.OK, msg, true, user);
    }

    public static LoginResult failure(String msg) {
        return new LoginResult(ResultStatus.FAIL, msg, false, null);
    }

    public LoginResult(ResultStatus status, String msg, boolean isLogin, User user) {
        super(status, msg, user);
        this.isLogin = isLogin;
    }


    public boolean isLogin() {
        return isLogin;
    }
}
