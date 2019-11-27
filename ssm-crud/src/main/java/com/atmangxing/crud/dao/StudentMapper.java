package com.atmangxing.crud.dao;

import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.bean.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);
    

  List<Student> selectByExampleWithClass(StudentExample example);
  Student selectByPrimaryKeyWithClass(Integer id);

    List<Student> findStudentByNameAndJobsAndPhone(Student student);


    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    public Student loginFindBy(@Param("username") String username,
                               @Param("password") String password);
}