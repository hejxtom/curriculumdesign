package com.atmangxing.mvcapp.dao;

public class Criteriaelectionic {
   private String name;
   private String password;

   public Criteriaelectionic() {
	super();
	
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

 public Criteriaelectionic(String name, String password) {
	this.name = name;
	this.password = password;
}
    
}
