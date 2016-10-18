package Bank;

public class Customer {
private String name;
private byte age;
private String address;
private String identity;


public Customer(String name,String identity){
	this.name=name;
	this.identity=identity;
}
public Customer(String name,String identity,byte age, String address){
	this.name=name;
	this.identity=identity;
	this.age=age;
	this.address=address;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getIdentity() {
	return identity;
}
public void setIdentity(String identity) {
	this.identity = identity;
}



}
