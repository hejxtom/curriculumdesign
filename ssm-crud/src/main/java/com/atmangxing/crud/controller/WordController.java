package com.atmangxing.crud.controller;

import com.atmangxing.crud.bean.Msg;
import com.atmangxing.crud.bean.Word;
import com.atmangxing.crud.service.WordServcie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WordController {

    @Autowired
    WordServcie wordServcie;

    @RequestMapping("/byclassId/{classId}")
    @ResponseBody
    public Msg getByWithClassId(@PathVariable Integer classId) {
        List<Word>  byclassId= wordServcie.getByClassId(classId);

        return Msg.success().add("byclassId", byclassId);
    }


//查出所有作业
    @RequestMapping("/words")
    @ResponseBody
    public Msg getWord(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Word> emps = wordServcie.getWord();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }


    /**
     * 保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     * @return
     */
    @RequestMapping(value="/wor",method= RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Word word, BindingResult result) {
        wordServcie.saveEmp(word);
        return Msg.success();
    }

    /**
     * 根据id查询
     * @param wordId
     * @return
     */
    @RequestMapping(value="/wor/{wordId}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("wordId")Integer wordId){

        Word word = wordServcie.getEmp(wordId);
        return Msg.success().add("wor", word);
    }
    //更新保存
    @ResponseBody
    @RequestMapping(value="/wor/{wordId}",method=RequestMethod.PUT)
    public Msg saveEmp(Word word, HttpServletRequest request){
        System.out.println("将要更新的员工数据："+word);
        wordServcie.updateEmp(word);
        return Msg.success()	;
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
    @RequestMapping(value="/wor/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        System.out.println(ids);
        //批量删除
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            wordServcie.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            wordServcie.deleteEmp(id);
        }
        return Msg.success();
    }


}
