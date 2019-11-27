package com.atmangxing.crud.controller;


import com.atmangxing.crud.bean.Admin;
import com.atmangxing.crud.bean.Class;
import com.atmangxing.crud.bean.Msg;
import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.service.AdminService;
import com.atmangxing.crud.service.ClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
  @Autowired
   AdminService adminService;

    @RequestMapping("/admins")
    @ResponseBody
    public Msg  getAdmins(){
        List<Admin> list = adminService.getAdmin();
        return Msg.success().add("admin",list);
    }

    /**
     * 根据id查询
     * @param sysId
     * @return
     */
    @RequestMapping(value="/admin/{sysId}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("sysId")Integer sysId){

       Admin admin = adminService.getEmp(sysId);
        return Msg.success().add("sys", admin);
    }

    /*
     *更新方法
     * @param employee
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/admin/{sysId}",method= RequestMethod.PUT)
    public Msg saveEmp(Admin admin, HttpServletRequest request){

        System.out.println("将要更新的员工数据："+admin);
        adminService.updateEmp(admin);
        return Msg.success();
    }
}
