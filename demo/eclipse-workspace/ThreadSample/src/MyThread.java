
public class MyThread implements Runnable{
private int val;
	@Override
	public void run() {
		
		for(int i=0;i<10;i++)
		{	System.out.println(Thread.currentThread().getName()+" val="+val++);
		try{
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		}
		
	}
	
	public int getVal(){
		return val;
	}

}
