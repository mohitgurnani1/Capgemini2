package com.barclays;

public class Person {

	//Data Members
	private String name;
	private int age;
	private static int count;
	
	


	//Member Methods
	
	{
		count++;
	}
	
	public Person() {
		name="Mohit";
		age=21;
	}
	

	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
		
	public static int getCount(){
		return Person.count;
	}
	
	
	
	
}
