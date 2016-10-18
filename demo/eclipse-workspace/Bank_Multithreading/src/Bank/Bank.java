package Bank;
import java.util.ArrayList;
import java.util.List;

public class Bank {
private int bankid;
private String bankName;
List<Account> accounts;
private static int acctCount;

public Bank(int bankid, String bankName) {
	this.bankid = bankid;
	this.bankName = bankName;
	accounts=new ArrayList<Account>();
}
 public void doTransaction( int from, int to,double amount){
	 
	Account withdrawer= getAccount(from);
	Account depositer=getAccount(to);

	synchronized(withdrawer){
		boolean flag= withdrawer.withdraw(amount);
		if(flag)
			synchronized(depositer){
				depositer.deposit(amount);	 
			}
		}
 } 

public Account getAccount(int id){
	for(Account i: accounts)
		if(i.getId()==id)
			return i;
	return null;
}

public Customer addCustomer(String name, String identity){
return new Customer(name,identity);
}


public void addAccount(String name, String identity, double balance){
Customer c=addCustomer(name,identity);
acctCount++;	
accounts.add(new Account(acctCount,balance,c));
}

public double showTotalBalance(){
	double totalbalance=0;
	for(Account i:accounts){
		totalbalance+=i.getbalance();
	}
	return totalbalance;
}



}
