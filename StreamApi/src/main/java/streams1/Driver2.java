package streams1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<>(List.of("a1","s2","a3","s4"));
		
		List<String>finalRes =  arr.stream().map(word-> word.toUpperCase()).collect(Collectors.toList());
		System.out.println(finalRes);
	}

}
