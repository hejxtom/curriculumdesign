package com.atmangxing.crud.test;


import com.atmangxing.crud.bean.Edit;
import com.atmangxing.crud.bean.Student;
import com.atmangxing.crud.dao.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
  @Autowired
  StudentMapper studentMapper;
  @Autowired
  ClassMapper classMapper;
  @Autowired
  AdminMapper adminMapper;
  @Autowired
  EditMapper editMapper;
  @Autowired
  WordMapper wordMapper;
  @Autowired
  SqlSession sqlSession;


  @Test
    public  void getStudent(){

//      System.out.println(studentMapper.selectByExample(null));
//        System.out.println(studentMapper.selectByExampleWithClass(null));
//      System.out.println(studentMapper.selectByPrimaryKeyWithClass(1));
//       System.out.println(classMapper.selectByExample(null));

//         studentMapper.insertSelective(new Student(null, "2017030869", "xiaoxue", "F", "20", "13999999999", "xiaoxue",
//                 "123456", 1));

//    StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
//          for(int i=2;i<50;i++){
//            String uid = UUID.randomUUID().toString().substring(0,5)+i;
//            mapper.insertSelective(new Student(null, "20170000"+i, uid, "M", "20", "13999999999", uid,
//                 "123456", 1));
//          }

    System.out.println(studentMapper.findStudentByNameAndJobsAndPhone(new Student(null,null,null, null,null, null, null,
            null, null)));

  }
}
