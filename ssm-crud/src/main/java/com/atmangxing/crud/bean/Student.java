package com.atmangxing.crud.bean;

import javax.validation.constraints.Pattern;

public class Student {
    private Integer id;

    @Pattern(regexp="(^2017\\d{6}$)"
            ,message="学号必须是2017开头的十位数")
    private String stuId;
    @Pattern(regexp="([^%&',;=?$\\x22]+)"
            ,message="含有非法字符")
    private String stuName;

    private String sex;

    private String age;

    @Pattern(regexp="(^[1][3,4,5,7,8][0-9]{9}$)"
            ,message="请输入正确的手机号码")
    private String phone;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})"
            ,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String stuUser;

    private String stuPass;

    private Integer classId;
    
    private Class aClass;


    public Class getaClass() {
		return aClass;
	}

	public void setaClass(Class aClass) {
		this.aClass = aClass;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStuUser() {
        return stuUser;
    }

    public void setStuUser(String stuUser) {
        this.stuUser = stuUser == null ? null : stuUser.trim();
    }

    public String getStuPass() {
        return stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass == null ? null : stuPass.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

	public Student(Integer id, String stuId, String stuName, String sex, String age, String phone, String stuUser,
			String stuPass, Integer classId) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.stuName = stuName;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.stuUser = stuUser;
		this.stuPass = stuPass;
		this.classId = classId;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", stuUser='" + stuUser + '\'' +
                ", stuPass='" + stuPass + '\'' +
                ", classId=" + classId +
                ", aClass=" + aClass +
                '}';
    }
}