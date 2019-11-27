package com.atmangxing.crud.service;

import com.atmangxing.crud.bean.Admin;
import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    /**
     * 查询所有管理员
     * @return
     */
    public List<Admin> getAdmin() {

        return adminMapper.selectByExampleWithWord(null);
    }

     //更新
    public void updateEmp(Admin admin) {
        // TODO Auto-generated method stub
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    /**
     * 按照id查询
     * @param id
     * @return
     */
    public Admin getEmp(Integer id) {
        // TODO Auto-generated method stub
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }


}
