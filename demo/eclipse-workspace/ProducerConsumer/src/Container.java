import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Container {
private int size;

Lock lock=new ReentrantLock();

private final Condition isEmpty = lock.newCondition(); 
   private final Condition isFull = lock.newCondition(); 


public void get() throws InterruptedException{
lock.lock();
	try{
	while(size<=0)
		isFull.await();

		size--;
		System.out.println(Thread.currentThread().getName()+" : Consumed : size="+size);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	isEmpty.signal();
	}
	finally{
	lock.unlock();	
	}
	
	
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


public void put() throws InterruptedException{
lock.lock();
try{
	while(size>=5)
		isEmpty.await();
		
	size++;	
	System.out.println(Thread.currentThread().getName()+" : Produced  : size="+size);
	
	try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
isFull.signal();
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
finally{
	lock.unlock();
}


}



}
