package cf2;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncDemo {
	
	public static void main(String [] args) {
		
		System.out.println("Before the fucntion call");
		CompletableFuture<String> cf = CompletableFuture.supplyAsync( ()-> {
			System.out.println("Inside the supply async ");
			return "successful async call ";
		} );
		
		System.out.println(cf.join());
		System.out.println("after the function call in the end");
	}
	
}
