package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Prac1 {
	
	public static void main(String [] args) {
		List<Integer> list = Arrays.asList(1,2,10,9,4,6);
		Optional<Integer> res = list.stream().filter(n-> n!=null).sorted((a,b)-> Integer.compare(b,a)).skip(1).findFirst();
		System.out.println(res.get());
	}
	
	
	
}
