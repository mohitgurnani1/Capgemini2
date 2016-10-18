package Employee.contractEmployee;
import Employee.Employee;
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
	
	 public class ContractEmployee extends Employee{

			String name;
			protected double salary;
			public ContractEmployee(String fname, String lname, int i, int j, String grade, MyDate md, String name) {
				super(fname, lname,  0,grade,md);
				//this.name=name;
				Contractor.this.name=name;
				salary=i*j;
				countCE++;
				
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
