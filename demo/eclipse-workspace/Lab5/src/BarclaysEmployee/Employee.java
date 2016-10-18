package BarclaysEmployee;
import java.util.*;
import myUtility.*;
public class Employee{

private String firstName;
private String lastName;
private double salary;
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

protected String getGrade(){
	return grade;
}


public void setEmpId(String empid){
this.empid=empid;
}
protected String getEmpId(){
return empid;
}
public static int countEmployee(){
return count;
}

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}
public MyDate readDate(){
	return joiningMonth;
}

protected void setSalary(double salary){
	this.salary=salary;
}

public double getSalary(){
	return salary;
}
public void setDate(MyDate md){
	this.joiningMonth=md;
}


}