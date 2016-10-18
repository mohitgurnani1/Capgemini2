package myUtility;

public class Mediclaim {

	private double coverage;
	
	public  double getCoverage() {
		return coverage;
	}
	public  void setCoverage(double coverage) {
	  this.coverage = coverage;
	}
	
	public void claimMediclaim(double cost){
		this.coverage-=cost;
	}
	
}
