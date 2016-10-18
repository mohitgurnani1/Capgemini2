package Employee;
import java.util.*;
import myUtility.*;
public class Employee{

private String firstName;
private String lastName;
protected double salary;
private String grade;
private MyDate joiningMonth;
private String empid;
protected static int count=0;



public Employee(String fname,String lname,double salary,String grade,MyDate joiningmonth){
firstName=fname;
lastName=lname;
this.salary=salary;
this.grade=grade;
this.joiningMonth=joiningmonth;
count++;
}


public void setEmpId(String empid){
this.empid=empid;
}

public static int countEmployee(){
return count;
}

public MyDate readDate(){
	return joiningMonth;
}

public void setDate(MyDate md){
	this.joiningMonth=md;
}


}