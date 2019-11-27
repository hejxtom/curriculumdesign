package com.atmangxing.mvcapp.dao;

public class CriteriaStudent {
	 private String number; //学号
	 private  String name;  // 姓名
	 private String sex;   // 性别
	 private String age;   //  年龄
	 private String grade; // 成绩
	
	 public String getNumber() {
		 if(number==null) 
			 number="%%";
		  else
			  number="%"+ number+"%"; 
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		if(name==null) 
			name="%%";
		  else
			  name="%"+ name+"%"; 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		if(sex==null) 
			sex="%%";
		  else
			  sex="%"+ sex+"%"; 
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAge() {
		if(age==null) 
			age="%%";
		  else
			  age="%"+ age+"%"; 
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getGrade() {
		if(grade==null) 
			grade="%%";
		  else
			  grade="%"+ grade+"%"; 
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public CriteriaStudent(String number, String name, String sex, String age, String grade) {
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
	}
	 
	 
}
