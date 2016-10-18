import com.simulationdemo.Animal;
import com.simulationdemo.Cat;

public class Entry {
	public static void main(String[] args) {
		
		Cat c = new Cat("Feline","");
		c.roam();
		
		System.out.println(c.getSize());
		
		Animal a;
		
//		IMPLICIT UP-CASTING
		a = c;
		
		a.roam();
		Integer intg=5;
		Integer m=intg;
		m=6;
		System.out.println(intg);
		System.out.println(m);
		
		int i=1;
		byte b=12;
		byte e=127;
		byte l=(byte)(b+e);
		System.out.println(l);
		b+=i;
		
		
		
		
		
//		System.out.println(a.getSize());
	}
}
