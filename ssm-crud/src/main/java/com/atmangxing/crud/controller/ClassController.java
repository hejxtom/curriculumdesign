package com.atmangxing.crud.controller;


import com.atmangxing.crud.bean.Class;
import com.atmangxing.crud.bean.Msg;
import com.atmangxing.crud.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClassController {

    @Autowired
    ClassService classService;

    /**
     * 返回所有的班级
     */
    @RequestMapping("/clas")
    @ResponseBody
    public Msg getClas(){
        List<Class> list = classService.getClas();
        return Msg.success().add("clas", list);
    }
}
