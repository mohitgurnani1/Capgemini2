package tp;

import java.io.IOException;

public class sampleException {

	static int r;
	public static void main(String[] args) throws Exception{
		
		
		String a = "abcd";          // 1
	    String b = "'\u0041'";      // 2
	    String c = "\u0041hi bhai";        // 3
	    String d = "\uD7AF";        // 4
	 System.out.println(a+b+c+d); 

//	  System.out.print(m);  // 5

	}		
	static public void setValue(int val,int den) throws Exception {
		
		try{
		throw new Exception("Mohit");
		}
		finally{
			
			System.out.println("in setvalue final");
		}
		
	}
	
	
	
}
