package BarclaysEmployee.contractEmployee;

import BarclaysEmployee.contractEmployee.Contractor.ContractEmployee;
import myUtility.MyDate;

public class TechAssociate extends ContractEmployee{

	public TechAssociate(Contractor contractor, String fname, String lname, int hours, int wages, String grade, MyDate md,
			String name) {
		contractor.super(fname, lname, hours, wages, grade, md, name);
		updateSalary(hours, wages);
	}

	public void updateSalary(int hours, int wages)
	{
		if(hours<=40)
			setSalary( hours*wages);
		else
			setSalary(40* wages + (hours - 40) * wages * 2);
	}

	@Override
	public String toString() {
		return getContractorId()+" ,"+getFirstName()+" "+getLastName()+", "+getGrade()+" : Tech Associate";
	}

}
