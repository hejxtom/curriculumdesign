package com.atmangxing.mvcapp.domain;

public class Electonic {
     private int id;
     private String name;
     private String password;
     private String phone;
     private String mailbox;
     private String electonicname;
     private String path;
	
     
     public Electonic() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getElectonicname() {
		return electonicname;
	}
	public void setElectonicname(String electonicname) {
		this.electonicname = electonicname;
	}
      
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Electonic(String name, String password, String phone, String mailbox) {
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.mailbox = mailbox;
	}
	
}
