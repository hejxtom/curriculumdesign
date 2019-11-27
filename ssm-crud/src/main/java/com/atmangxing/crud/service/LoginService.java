package com.atmangxing.crud.service;

import com.atmangxing.crud.bean.Admin;
import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.dao.AdminMapper;
import com.atmangxing.crud.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;

@Service
public class LoginService {
    @Autowired
  StudentMapper studentMapper;
    @Autowired
    AdminMapper adminMapper;
    /*
    * 学生登录
    */

    public Student loginFindBy(String username,String password){

        return studentMapper.loginFindBy(username,password);
    }
     /*
     * 管理员登录
     */
    public Admin adloginFindBy(String username,String password){
        return  adminMapper.loginFindBy(username,password);
    }
}
