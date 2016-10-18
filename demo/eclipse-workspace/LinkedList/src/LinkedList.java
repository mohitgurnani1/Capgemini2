
public class LinkedList <E>{

	public Node head=null;
	
	public class Node{
		private E data;
		private Node next;
		}
	
	public  void add(E val){
		if(head==null)
		{	head=new Node();
			head.data=val;
		}
		else
		{
			Node temp=new Node();
			temp.data=val;
			temp.next=head;
			head=temp;
		}
	}
	
	public void display(){
	
		
		Node head=LinkedList.this.head;
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.next;
		}
		
		
	}
	
	public void update(E val,E newval){
		Node head=LinkedList.this.head;
		boolean flag=false;
		while(head!=null)
		{
			//System.out.println(head.data);
			if(head.data.equals(val))
				{head.data=newval;
				System.out.println("Successfully updated");
				flag=true;
				}
			head=head.next;
	}
		if(flag==false)
			System.out.println("Node does not exist");

	}
	
	
	public void delete(E val){

		boolean flag=false;
		Node  head=LinkedList.this.head;
		Node helper=null;
		while(head!=null)
		{
			//System.out.println(head.data);
			if(head.data.equals(val))
				{
				if(helper==null)
				{
					LinkedList.this.head=head.next;
					flag=true;
					
				}
				else if(head.next==null)
				{
					head=helper;
					helper.next=null;
					flag=true;
				}
				else{
				helper.next=head.next;
				head=null;
				head=helper;
				flag=true;
				}
				
					System.out.println("Successfully Deleted");		
					break;
				}
			helper=head;
			head=head.next;
	}
		if(flag==false)
			System.out.println("Node does not exist");
}
	
	
}
