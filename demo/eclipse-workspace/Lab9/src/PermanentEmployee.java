
public class PermanentEmployee extends Employee {
	protected static int countPE=0;

	public PermanentEmployee(String fname, String lname, double salary, String grade, MyDate joiningmonth) {
		super(fname, lname, salary, grade, joiningmonth);
		countPE++;
	}
	
public static int countPEEmployee(){
return countPE;
}

}
