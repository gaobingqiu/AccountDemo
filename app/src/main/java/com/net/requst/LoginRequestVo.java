package com.net.requst;

/**
 * 登录操作的请求数据
 * Created by gbq on 2016-9-24.
 */
public class LoginRequestVo {
    private String userName;

    private String password;

    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
