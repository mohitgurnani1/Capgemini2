import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Container2 {
private int size;

synchronized
public void get() throws InterruptedException{

	while(size<=0)
		this.wait();

		size--;
		System.out.println(Thread.currentThread().getName()+" : Consumed : size="+size);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	this.notify();
	
	
	/*	
	while(size>0)
		{
		System.out.println(Thread.currentThread().getName()+" : Produced  : size="+size);
		size--;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
*/		
}

synchronized
public void put() throws InterruptedException{

	while(size>=5)
		this.wait();
		
	size++;	
	System.out.println(Thread.currentThread().getName()+" : Produced  : size="+size);
	
	try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	this.notify();
/*	while(size<5)         //condition
		{
//this.wait();	
		System.out.println(Thread.currentThread().getName()+" : Consumed  : size="+size);
		size++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	
*/	
}






}
