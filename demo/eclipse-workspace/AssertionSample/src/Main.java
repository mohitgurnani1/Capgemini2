
public class Main {

	public static void main(String[] args){
		
		System.out.println("1");
		int distance=98;
		assert (distance>0);
		System.out.println("2");
		distance=-90;
		assert (distance>0): "negative no not allowed"+distance;
		System.out.println("3");

		
	}
	
}
