package com.atmangxing.crud.service;

import com.atmangxing.crud.bean.Edit;
import com.atmangxing.crud.bean.Word;
import com.atmangxing.crud.dao.EditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditServcie {
    @Autowired
    EditMapper editMapper;

    public void saveEmp(Edit edit) {
        // TODO Auto-generated method stub
        editMapper.insertSelective(edit);
    }


    public List<Edit> gettest(Integer stusId) {

        return editMapper.selectWithstusId(stusId);
    }
    /**
     * 查询所有
     * @return
     */
    public List<Edit> getEdit() {

        return editMapper.selectAll();
    }

}
