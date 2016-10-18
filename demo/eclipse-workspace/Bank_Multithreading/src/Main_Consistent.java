import Bank.Bank;
public class Main_Consistent {

	public static void main(String[] args){
		
		Bank b=new Bank(1, "Barclays");
		
		for(int i=0;i<10;i++)
			{b.addAccount("Mohit/"+i,"MH123"+i, 5000);
			}
		System.out.println("Total Banks balance="+b.showTotalBalance());
		Runnable tellerAgent=new TellerAgent(b, 1);
	   
		Thread t1=new Thread(tellerAgent);
	   t1.start();
	   try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   System.out.println("Total Banks balance="+b.showTotalBalance());
			
	}
	
	
}
