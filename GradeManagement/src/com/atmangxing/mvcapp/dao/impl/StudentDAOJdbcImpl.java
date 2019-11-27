package com.atmangxing.mvcapp.dao.impl;

import java.util.List;

import com.atmangxing.mvcapp.dao.CriteriaStudent;
import com.atmangxing.mvcapp.dao.DAO;
import com.atmangxing.mvcapp.dao.StudentDAO;
import com.atmangxing.mvcapp.domain.Student;

public class StudentDAOJdbcImpl extends DAO<Student> implements StudentDAO{

	@Override
	public List<Student> getForListWithCriteriaCustomer(CriteriaStudent cs) {
		String sql="SELECT * FROM student WHERE " +
			"number LIKE ? AND name LIKE ? AND sex LIKE ? AND age LIKE ? AND grade LIKE ?";
		
	return getForList(sql,cs.getNumber(),cs.getName(),cs.getSex(),cs.getAge(),cs.getGrade());
	}

	@Override
	public List<Student> getAll() {
		String sql="SELECT * FROM student";
		return getForList(sql);
	}

	@Override
	public void save(Student student) {
		String sql="INSERT INTO student(number,name,sex,age,grade) VALUES(?,?,?,?,?)";
		update(sql, student.getNumber(),student.getName(),
		           student.getSex(),student.getAge(),student.getGrade());
		
	}

	@Override
	public Student get(String number) {
		String sql="SELECT * FROM student WHERE number=?";
		return get(sql,number);
	}

	@Override
	public void delete(String number) {
		String sql="DELETE FROM student WHERE number=?";
		update(sql, number);
		
	}

	@Override
	public void update(Student student) {
		String sql="UPDATE student SET name=?,sex=?,age=?,grade=?"+
                "WHERE number=?";
	update(sql, student.getName(),student.getSex(),student.getAge(),
			student.getGrade(),student.getNumber());
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(number) FROM student WHERE name=?";
		return getForValue(sql, name);
	}

}
