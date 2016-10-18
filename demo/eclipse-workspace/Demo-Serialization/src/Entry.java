import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	String name;
	public Person(String name){
		this.name=name;
	}
}

class Bank implements Serializable{
	public int no;
	public String name;
	Person person;
}


public class Entry {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Bank bankRef;
		Bank b1;
		//SERIALIZING AN OBJECT INTO A STREAM
		
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("test.ser"));){
			
			 bankRef=new Bank();
			bankRef.name="Barclays";
			bankRef.no=5;
			bankRef.person=new Person("Mohit");
			
			out.writeObject(bankRef);
		}
		
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("test.ser")))
		{
			
			b1=(Bank) in.readObject();
		}
		
		
		System.out.println(b1==bankRef);
		System.out.println(b1.no==bankRef.no);
		System.out.println(b1.name==bankRef.name);
		System.out.println(b1.person==bankRef.person);
		System.out.println("----------------------------------------------------------------------------------------");
		
		Bank b3=new Bank();
		b3.no=b1.no;
		b3.name=b1.name;
		b3.person=b1.person;
		
		
		System.out.println(b1==b3);
		System.out.println(b1.no==b3.no);
		System.out.println(b1.name==b3.name);
		System.out.println(b1.person==b3.person);
		
		
		
		
		
		
	}
	
	
}
