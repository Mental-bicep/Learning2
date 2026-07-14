package streams1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> brands = new ArrayList<>(List.of("a1","a2","a3","a4"));
		
		Stream<String> st = brands.stream();
		Stream<String> upperCaseStream = st.map(word -> word.toUpperCase());
		
		List<String> finalList = upperCaseStream.collect(Collectors.toList());
		System.out.println(finalList);
		
	}

}
