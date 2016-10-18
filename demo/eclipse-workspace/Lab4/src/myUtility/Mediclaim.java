package myUtility;

public class Mediclaim {

	private static double coverage;
	
	public static double getCoverage() {
		return coverage;
	}
	public static void setCoverage(double coverage) {
		Mediclaim.coverage = coverage;
	}
	
	public static void claimMediclaim(double cost){
		Mediclaim.coverage-=cost;
	}
	
}
