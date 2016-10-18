
public class EmpKey implements Comparable {

	String dept;
	String name;
	int count;
	public EmpKey(String dept,String name,int count){
		this.dept=dept;
		this.name=name;
		this.count=count;
	}
	
	@Override
	public String toString(){
		return dept.substring(0,1)+String.format("%03d", count)+name;
	}
	
	public String getkey(){
		return dept.substring(0,1)+String.format("%03d", count)+name;
	}
	
	public EmpKey getObject(){
		return this;
	}

	@Override
	public int hashCode() {
	//	return (name.length()+count)%dept.length();
	//return name.length();
		return dept.length();
	}
	
	@Override
	public boolean equals(Object obj) {
		EmpKey e1=this;
		EmpKey e2=(EmpKey)obj;
		if(e1.name.toUpperCase().equals(e2.name.toUpperCase())&& e1.dept.equals(e2.dept)&&e1.count==e2.count)
			return true;
		else
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		EmpKey e1=this;
		EmpKey e2=(EmpKey)o;
		if(e1.name.equals(e2.name))
		{
			if(e1.dept.equals(e2.dept))
			{
				return e1.count-e2.count;
			}
			else
			{
				return e1.dept.compareTo(e2.dept);
			}
		}
		else
		{
			return e1.name.compareTo(e2.name);
		}		

	}
	
}
