
public class Client {

	public static void main(String[] args){

	 MyThread runnable=new MyThread();
     Thread myThread=new Thread(runnable,"Rosh");
     myThread.start();
	}

}
