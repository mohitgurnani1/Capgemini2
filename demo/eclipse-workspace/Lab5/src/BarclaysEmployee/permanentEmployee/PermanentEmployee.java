package BarclaysEmployee.permanentEmployee;
import BarclaysEmployee.Employee;
import myUtility.*;
abstract public class PermanentEmployee extends Employee {
	protected static int countPE=0;
	protected int experience;
	 public PermanentEmployee(String fname, String lname, double salary, String grade, MyDate joiningmonth) {
		super(fname, lname, salary, grade, joiningmonth);
		countPE++;
	}
		public void setExperience(int exp){
			experience=exp;
		}
		
		
public static int countPEEmployee(){
return countPE;
}

protected int getExperience(){
	return experience;
}


}
