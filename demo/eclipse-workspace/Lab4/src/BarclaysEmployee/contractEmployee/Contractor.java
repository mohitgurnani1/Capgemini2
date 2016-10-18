package BarclaysEmployee.contractEmployee;
import BarclaysEmployee.Employee;
import myUtility.*;
 public class Contractor {

	private String name;
	private int countCE=0;
	
	public Contractor(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
abstract	 public class ContractEmployee extends Employee{

			String name;
			
		
			public ContractEmployee(String fname, String lname, int i, int j, String grade, MyDate md, String name) {
				super(fname, lname,  0,grade,md);
				//this.name=name;
				Contractor.this.name=name;
				setSalary(setSalaryLogic(i, j));
				countCE++;
			}

			protected double setSalaryLogic(int i, int j)
			{
				return i*j;
			}
			
			public  String getContractorName(){
				return Contractor.this.name;
			}
			

			
		}


		public  String getContractorName(){
			return name;
		}


		public int countCEmployee(){
		return countCE;
		}	
	
}
