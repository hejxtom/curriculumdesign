package com.atmangxing.mvcapp.dao;

public class uploadelctionic {
    private String name;
    private String electonicname;
    private String path;
	
    public uploadelctionic(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public uploadelctionic(String name, String electonicname, String path) {
		super();
		this.name = name;
		this.electonicname = electonicname;
		this.path = path;
	}
    
}
