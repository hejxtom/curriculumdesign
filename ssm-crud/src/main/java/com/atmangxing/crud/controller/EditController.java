package com.atmangxing.crud.controller;

import com.atmangxing.crud.bean.Edit;
import com.atmangxing.crud.bean.Msg;
import com.atmangxing.crud.service.EditServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class EditController {
    @Autowired
  EditServcie editServcie;

    /**
     * 保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     * @return
     */
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@ModelAttribute Edit edit, BindingResult result) throws IOException {
        System.out.println(edit);
        editServcie.saveEmp(edit);
        return Msg.success();
    }

    /**
     * 返回带班级信息
     */
    @RequestMapping("/edits")
    @ResponseBody
    public Msg getClas(){
        List<Edit> list = editServcie.getEdit();
        return Msg.success().add("edits", list);
    }

    /**
     * 学生号查询
     */
    @RequestMapping("/gettest/{stusId}")
    @ResponseBody
    public Msg gettest(@PathVariable("stusId") Integer stusId){
        List<Edit> text = editServcie.gettest(stusId);
        return Msg.success().add("text", text);
    }

}
