package com.atmangxing.crud.service;

import com.atmangxing.crud.bean.Class;
import com.atmangxing.crud.dao.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
  @Autowired
    ClassMapper classMapper;

    /**
     * 查询所有班级
     * @return
     */
    public List<Class> getClas() {

        return classMapper.selectByExample(null);
    }
}
