package BarclaysEmployee.permanentEmployee;

import myUtility.Mediclaim;
import myUtility.MyDate;

public class ProjectManager extends PermanentEmployee{

	private Mediclaim coverage;
	private static int coverageFormula=1;
	public ProjectManager(String fname, String lname, double salary, String grade, MyDate joiningmonth) {
		super(fname, lname, salary, grade, joiningmonth);
		coverage.setCoverage(coverageFormula*salary);
	}
	
	public double displayMediclaimCoverage(){
	return	coverage.getCoverage();
	}
	

	
	
	
}
