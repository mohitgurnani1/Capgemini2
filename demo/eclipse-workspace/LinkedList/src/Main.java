import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		LinkedList<String> l=new LinkedList<String>();
		
		 l.add("Mohit");
		 l.add("Laxman");
		 l.add("Kavita");
		 l.display();
		 l.delete("Mohit");
		 l.display();
	

			LinkedList<Integer> lm=new LinkedList<Integer>();
			
			 lm.add(1);
			 lm.add(2);
			 lm.add(3);
			 lm.display();
			 lm.delete(2);
			 lm.display();
	
			 java.util.LinkedList<Integer> list1=new java.util.LinkedList<Integer>();
			 list1.add(31);
			 list1.add(29);
			 list1.add(23);

	for(Object o: list1)
		System.out.println(o);
	
	Iterator itr=list1.iterator();
/*	while(itr.hasNext())
	{
		
	}
	tree set...addAll
	
	Comparator implement 
	*
	*/
	char c1 = 0xffff;  // 1
	  char c2 = (char) 0xfffff; // 2
	  byte b1 =(byte) 0xfff;  // 3
	  byte b2 = 0x7f;    // 4
	  byte b3 = (byte)0xff;    // 5
	  byte b4 = -0x80;   // 6

	
}
}
