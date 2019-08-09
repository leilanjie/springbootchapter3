package com.example.springboot.demo.service;

import com.example.springboot.demo.dao.LoginLogDao;
import com.example.springboot.demo.dao.UserDao;
import com.example.springboot.demo.domain.LoginLog;
import com.example.springboot.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }
    public boolean hasMatchUser(String userName,String password){
        int matchCount=userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }
    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog=new LoginLog();
        //loginLog.setLoginLogId(1);
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        //System.out.println(user.getLastVisit());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        //System.out.println("111111");
        loginLogDao.insertLoginLog(loginLog);
    }
}
