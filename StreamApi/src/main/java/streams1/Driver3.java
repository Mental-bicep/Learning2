package streams1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver3 {
	public static void main(String [] args) {
		ArrayList<Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
		
		ArrayList<Integer> gtThan50 = (ArrayList<Integer>) arr.stream().map(n -> n*10).filter(n -> n>50).collect(Collectors.toList());
		System.out.println(gtThan50);
	}
}
