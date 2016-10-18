package BarclaysEmployee.permanentEmployee;

import myUtility.Mediclaim;
import myUtility.MyDate;

public class TechAssociate extends PermanentEmployee {

	
	private Mediclaim coverage;
	private static int coverageFormula=2;
	private int certifications;
	public TechAssociate(String fname, String lname, double salary, String grade, MyDate joiningmonth) {
		super(fname, lname, salary, grade, joiningmonth);
		coverage=new Mediclaim();
		coverage.setCoverage(coverageFormula*salary);
		updateSalary();
	}
	
	public double displayMediclaimCoverage(){
		return	coverage.getCoverage();
		}
	
	public void updateSalary(){
		setSalary(5000*experience+1000*certifications);
	}
	public void setCertification(int no){
		certifications=no;
	}
	
	@Override
	public String toString() {
		return getEmpId()+" ,"+getFirstName()+" "+getLastName()+", "+getGrade()+" : Tech Associate ,"+getExperience();
	}
}
