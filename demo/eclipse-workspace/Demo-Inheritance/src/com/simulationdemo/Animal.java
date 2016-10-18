package com.simulationdemo;

abstract public class Animal {
	// DATA MEMBERS

	private String type;
	protected String location;
	public String gender="male";
	

	public void roam(){
		System.out.println("inside roam() of Animal");
	}
	
abstract public void sleep();

	
	public Animal(String type, String location) {
		this.type = type;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}
	
	public String getType() {
		return type;
	}
	
	
}
