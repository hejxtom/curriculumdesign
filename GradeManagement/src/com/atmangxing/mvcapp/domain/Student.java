package com.atmangxing.mvcapp.domain;

public class Student {
 private String number; //ѧ��
 private  String name;  // ����
 private String sex;   // �Ա�
 private String age;   //  ����
 private String grade; // �ɼ�
public Student() {

}

public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}

public Student(String number, String name, String sex, String age, String grade) {

	this.number = number;
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.grade = grade;
    }
 
}
