package com.example.springboot.demo.web;

import com.example.springboot.demo.domain.User;
import com.example.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    private UserService userService;

    //处理静态网页/index.html请求
    @RequestMapping(value = {"/","/index.html"})
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        System.out.println(isValidUser);
        if (!isValidUser) {
//            return new ModelAndView("login","error","用户名或密码错误。");
            return new ModelAndView("loginError");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
           /* System.out.println(user.getUserId()+":"+user.getCredits()+user.getUserName());
            System.out.println(request.getLocalAddr());*/
            user.setLastIp(request.getLocalAddr());
            java.util.Date utilDate = new java.util.Date(); //获取当前时间

            // System.out.println(utilDate);

            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            System.out.println(sqlDate);

            user.setLastVisit(sqlDate);
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
