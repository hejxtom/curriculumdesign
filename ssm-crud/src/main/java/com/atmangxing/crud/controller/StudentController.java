package com.atmangxing.crud.controller;

import com.atmangxing.crud.bean.Msg;
import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
  @Autowired
  StudentService studentService;


    /**
     *
     * @param student
     * @return
     */
    @RequestMapping(value="/find",method=RequestMethod.POST)
    @ResponseBody
    public Msg getfind(Student student){

        System.out.println(student);

        List<Student> studentList=studentService.getfind(student);

        return Msg.success().add("find", studentList);
    }


    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/stu/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<String> del_ids = new ArrayList<String>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(string);
            }
            studentService.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            studentService.deleteEmp(id);
        }
        return Msg.success();
    }

  /*
   *更新方法
   * @param employee
   * @return
   */
  @ResponseBody
  @RequestMapping(value="/stu/{id}",method=RequestMethod.PUT)
  public Msg saveEmp(Student student,HttpServletRequest request){
//		System.out.println("请求体中的值："+request.getParameter("gender"));
      System.out.println("将要更新的员工数据："+student);
      studentService.updateEmp(student);
      return Msg.success()	;
  }


    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @RequestMapping(value="/stu/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id")Integer id){

        Student student = studentService.getEmp(id);
        return Msg.success().add("stu", student);
    }


    /**
     * 学生保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     *
     * @return
     */
    @RequestMapping(value="/stu",method= RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Student student, BindingResult result){
        if(result.hasErrors()){
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{

            studentService.saveEmp(student);
            return Msg.success();
        }

    }

    /**
     * 检查学号是否可用
     * @param stuid
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkid")
    public Msg checkid(@RequestParam("stuid")String stuid){
        //先判断用户名是否是合法的表达式;
        String regx = "(^2017\\d{6}$)";
        if(!stuid.matches(regx)){
            return Msg.fail().add("va_id", "学号必须是2017开头的十位数");
        }

        //数据库用户名重复校验
        boolean b = studentService.checkid(stuid);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_id", "用户名不可用");
        }
    }

    /**
     * 检查用户名是否可用
     * @param empName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuser")
    public Msg checkuser(@RequestParam("empName")String empName){
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }

        //数据库用户名重复校验
        boolean b = studentService.checkUser(empName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg", "用户名不可用");
        }
    }


    /**
     * 查询学生数据（分页查询）
     * 导入jackson包。
     * @param pn
     * @return
     */
    @RequestMapping("/stus")
    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Student> emps = studentService.getAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }
    /**
     * 查询学生数据（分页查询）
     *
     * @return
     */
//    @RequestMapping("/stus")
    public String getEmps(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {
        // 这不是一个分页查询；
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Student> emps = studentService.getAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", page);

        return "list";
    }
}
