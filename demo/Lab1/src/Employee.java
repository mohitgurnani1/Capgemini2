import java.util.*;
class Employee{

private String firstName;
private String lastName;
private double salary;
private String grade;
private String joiningMonth;
private String empid;
private static int count=0;

public Employee(String fname,String lname,double salary,String grade,String joiningmonth){
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

}