package com.flp.ems.util;

public class Validate {

	public static boolean validateMobileNo(String no){
	boolean flag=true;
		try{
		long num=Long.parseLong(no);
	}
	catch(Exception e){
		flag=false;
	}
			return no.length()==10 && flag;					
	}
	
	
}
