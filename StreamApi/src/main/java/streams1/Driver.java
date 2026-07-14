package streams1;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<>();
		arr.add("a1");
		arr.add("a2");
		arr.add("a3");
		arr.add("a4");
		
		Iterator<String> it = arr.iterator();
		
		while(it.hasNext()) {
			String str = it.next();
			if(str.startsWith("a")) System.out.println(str);
		}
	}

}
