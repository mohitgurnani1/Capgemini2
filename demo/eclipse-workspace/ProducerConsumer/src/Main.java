
public class Main {

	public static void main(String[] args){
		
		Container2 c=new Container2();
		Runnable producer=new Produce(c);
		Runnable consume=new Consumer(c);
		
		
		Thread t1=new Thread(producer);
		Thread t2=new Thread(consume);
		
		
		t1.start();
		t2.start();
		
	}
	
	
}
