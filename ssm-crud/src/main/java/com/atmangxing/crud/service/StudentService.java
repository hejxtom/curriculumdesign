package com.atmangxing.crud.service;

import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.bean.StudentExample;
import com.atmangxing.crud.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public List <Student> getfind(Student student) {

        return studentMapper.findStudentByNameAndJobsAndPhone(student);
    }


    /**
     * 删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        // TODO Auto-generated method stub
        studentMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<String> ids) {
        // TODO Auto-generated method stub
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andStuIdIn(ids);
        studentMapper.deleteByExample(example);
    }



    /**
     * 更新
     * @param student
     */
    public void updateEmp(Student student) {
        // TODO Auto-generated method stub
        studentMapper.updateByPrimaryKeySelective(student);
    }


    /**
     * 按照id查询
     * @param id
     * @return
     */
    public Student getEmp(Integer id) {
        // TODO Auto-generated method stub
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }


    /**
     * 学生保存
     * @param student
     */
    public void saveEmp(Student student) {
        // TODO Auto-generated method stub
        studentMapper.insertSelective(student);
    }

    /**
     * 检验用户名是否可用
     *
     * @param checkid
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    public boolean checkid(String checkid) {
        // TODO Auto-generated method stub
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(checkid);
        long count = studentMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 检验用户名是否可用
     *
     * @param empName
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    public boolean checkUser(String empName) {
        // TODO Auto-generated method stub
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuUserEqualTo(empName);
        long count = studentMapper.countByExample(example);
        return count == 0;
    }


    /**
     * 查询所有学生
     * @return
     */
    public List<Student> getAll() {

        return studentMapper.selectByExampleWithClass(null);
    }

}
