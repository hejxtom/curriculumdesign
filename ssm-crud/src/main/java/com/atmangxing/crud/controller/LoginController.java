package com.atmangxing.crud.controller;

import com.atmangxing.crud.bean.Admin;
import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/loginaction", method = RequestMethod.POST)
    public String login(@Param("username") String username,
                        @Param("password") String password,HttpSession session) {
        if (username.equals("admin")) {
            Admin admin =loginService.adloginFindBy(username, password);
                if (admin != null) {
                System.out.println(admin);
                return "student";
                }
        } else {
            Student student = loginService.loginFindBy(username, password);
            if(student !=null){
                session.setAttribute("stuId", student.getId());
                session.setAttribute("classId", student.getClassId());
                return "stu";
            }
        }
        return "404";
    }

    @RequestMapping(value = "/loginController")
    public  String loginController(){
         return "login";
    }

    @RequestMapping(value = "/adminController")
    public  String adminController(){
        return "admin";
    }
    @RequestMapping(value = "/editController")
    public  String editController(){
        return "edit";
    }
    @RequestMapping(value = "/stuController")
    public  String stuController(){
        return "stu";
    }
    @RequestMapping(value = "/studentController")
    public  String studentController(){
        return "student";
    }
    @RequestMapping(value = "/studenteditController")
    public  String studenteditController(){
        return "studentedit";
    }
    @RequestMapping(value = "/stueditController")
    public  String stueditController(){
        return "stuedit";
    }
    @RequestMapping(value = "/testController")
    public  String testController(){
        return "test";
    }
    @RequestMapping(value = "/wordController")
    public  String wordController(){
        return "word";
    }
    @RequestMapping(value = "/scuessController")
    public  String scuessController(){
        return "scuess";
    }
}