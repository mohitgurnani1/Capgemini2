package BarclaysEmployee.permanentEmployee;

import myUtility.Mediclaim;
import myUtility.MyDate;

public class ProjectManager extends PermanentEmployee{

	private Mediclaim coverage;
	
	
	private static int coverageFormula=1;
	
	public ProjectManager(String fname, String lname, double salary, String grade, MyDate joiningmonth) {
		super(fname, lname, salary, grade, joiningmonth);
		coverage=new Mediclaim();
		coverage.setCoverage(coverageFormula*salary);
	}
	public void updateSalary(){
		setSalary(10000*experience);
	}
	

	public double displayMediclaimCoverage(){
	return	coverage.getCoverage();
	}
	
@Override
public String toString() {
	return getEmpId()+" ,"+getFirstName()+" "+getLastName()+", "+getGrade()+" : Project Manager ,"+getExperience();
}
	
	
	
}
