package com.atmangxing.crud.dao;

import com.atmangxing.crud.bean.Admin;
import com.atmangxing.crud.bean.AdminExample;
import java.util.List;

import com.atmangxing.crud.bean.Student;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer sysId);

    int insert(Admin record);

    int insertSelective(Admin record);

//   带作业查询
    List<Admin> selectByExampleWithWord(AdminExample example);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer sysId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    public Admin loginFindBy(@Param("username") String username,
                               @Param("password") String password);
}