package BarclaysEmployee.contractEmployee;

import BarclaysEmployee.contractEmployee.Contractor.ContractEmployee;
import myUtility.MyDate;

public class TechAssociate extends ContractEmployee{

	public TechAssociate(Contractor contractor, String fname, String lname, int i, int j, String grade, MyDate md,
			String name) {
		contractor.super(fname, lname, i, j, grade, md, name);
		// TODO Auto-generated constructor stub
	}

	
}
