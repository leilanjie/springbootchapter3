package com.example.springboot.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private  int loginLogId;
    private int userId;
    private  String  ip;
    private Date loginDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getIp() {
        return ip;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }
}
