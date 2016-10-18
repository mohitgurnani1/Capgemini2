import Bank.Bank;
public class Main2 {

	public static void main(String[] args){
		
		Bank b=new Bank(1, "Barclays");
		
		for(int i=0;i<10;i++)
			{b.addAccount("Mohit/"+i,"MH123"+i, 5000);
			}
		System.out.println("Total Banks balance="+b.showTotalBalance());
		
		Runnable tellerAgent=new TellerAgent(b, 1);
	   Thread t1=new Thread(tellerAgent);
	   t1.start();
	   
	   Runnable tellerAgent2=new TellerAgent2(b, 2);
	   Thread t2=new Thread(tellerAgent2);
	   t2.start();
	   
	   
	   
	   try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   System.out.println("Total Banks balance="+b.showTotalBalance());
			
	}
	
	
}
