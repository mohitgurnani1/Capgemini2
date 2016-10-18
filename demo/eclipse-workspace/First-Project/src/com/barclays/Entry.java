/**
 * 
 */
package com.barclays;

/**
 * @author training
 *
 */


 public class Entry {

	 public static class Dimple{}
	
	 
	 /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entry e=new Entry();
		Entry.Dimple ed=new Entry.Dimple();
		
		
		
		System.out.println("Hello World");
	
	Person p;
	p=null;
	p=new Person();

	System.out.println(p.getName());
	System.out.println(p.getAge());
	p=null;

	System.out.println(Person.getCount());
	
	
	}

}
