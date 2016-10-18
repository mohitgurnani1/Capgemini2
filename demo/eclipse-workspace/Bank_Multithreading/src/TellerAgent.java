import java.util.Random;

import Bank.*;

public class TellerAgent  implements Runnable{

private int agentid;
private Bank bank;
public TellerAgent(Bank b,int agentid){
	this.bank=b;
	this.agentid=agentid;
}
@Override
public void run() {
	// TODO Auto-generated method stub
	
	
	
	Random randomGenerator = new Random();
	
	for(int i=0;i<10;i++){
	int from = randomGenerator.nextInt(10)+1;
	int to = randomGenerator.nextInt(10)+1;
	int amount = randomGenerator.nextInt(5000);
	
	if(from==to)
		continue;
	
	bank.doTransaction(from,to , amount);
	
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
		/*
		bank.doTransaction(2,1 , 2000);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bank.doTransaction(1,3 , 2000);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bank.doTransaction(2,3 , 2000);
		bank.doTransaction(3,4 , 2000);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bank.doTransaction(4,2 , 2000);
*/		
}




/* For MASTER/VISA
public void doTransaction(Bank b, int from, Bank c,int to,double amount){
	b.getAccount(from).withdraw(amount);
	c.getAccount(to).deposit(amount);
}
*/

}
