package com.atmangxing.crud.bean;

public class Class {
    private Integer classId;

    private String className;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

	public Class(Integer classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + "]";
	}
    
}