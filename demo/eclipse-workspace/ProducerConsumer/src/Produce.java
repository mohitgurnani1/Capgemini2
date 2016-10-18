
public class Produce implements Runnable {

	Container2 c;
	
	public Produce(Container2 c){
		this.c=c;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			{
			
			try {
				c.put();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	}
	
}
