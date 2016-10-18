package Bank;

public class Account {
private int id;
private double balance;
private Customer customer;

public Account(int id,double balance, Customer c){
	this.id=id;
	this.balance=balance;
	this.customer=c;
}

public int getId(){
	return id;
}

public double getbalance(){
	return balance;
}


public boolean deposit(double amount){
	double prevbalance=this.balance;
	double balance=this.balance; //READ
	balance+=amount;  // MODIFY	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.balance=balance;  //update
	System.out.println(Thread.currentThread().getName()+": [Deposit] Dear ,"+customer.getName()+" Balance of your Account "+id+" before deposit("+amount+") was "+prevbalance+" and after deposit  is "+this.balance);
	return true;
}
public boolean withdraw(double amount){
	double prevbalance=this.balance;
	double balance=this.balance; //READ
	if(balance<amount)
	{
		System.out.println(Thread.currentThread().getName()+":  [Withdraw] Dear ,"+customer.getName()+" You dont have sufficient balance in your  Account "+id+" for this transaction("+amount+")" );
		return false;
	}
	
	balance-=amount;  // MODIFY	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.balance=balance;  //update
	System.out.println(Thread.currentThread().getName()+":  [Withdraw] Dear ,"+customer.getName()+" Balance of your Account "+id+" before withdraw("+amount+") was "+prevbalance+" and after withdraw  is "+this.balance);
	
	return true;
}



	
}
