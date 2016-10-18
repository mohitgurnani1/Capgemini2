package BarclaysEmployee.contractEmployee;
import BarclaysEmployee.Employee;
import myUtility.*;
 public class Contractor {

	 private String contractorId;
	private String name;
	private int countCE=0;
	static int countTotalContractBasedEmployees;
	
	public Contractor(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
abstract	 public class ContractEmployee extends Employee{

			String name;
			
		
			public ContractEmployee(String fname, String lname, int hours, int wages, String grade, MyDate md, String name) {
				super(fname, lname,  0,grade,md);
				//this.name=name;
				Contractor.this.name=name;		
				contractorId="CN00"+name.substring(0,2);
				countCE++;
				countTotalContractBasedEmployees++;
			}

		
			public  String getContractorName(){
				return Contractor.this.name;
			}
			
			protected  String getContractorId(){
				return contractorId;
			}

					
		}


		public  String getContractorName(){
			return name;
		}


		public int countCEmployee(){
		return countCE;
		}	
	
}
