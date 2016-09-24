package com.net.requst;

/**
 * 注册请求参数
 * Created by gbq on 2016-9-24.
 */
public class RegisterRequestVo {
    private String userName;
    private String password;
    private int code;
    private String tel;

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


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
