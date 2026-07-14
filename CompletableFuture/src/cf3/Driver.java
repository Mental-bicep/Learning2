package cf3;

import java.util.concurrent.CompletableFuture;

public class Driver {
	public static void main(String [] args) {
		// WAP to convert a string from lowercase to uppercase using chaining
		
		// total=1 thread uses the same thread which was used in supplyAsync
//		CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> {return "hodewala";})
//														.thenApply((n)-> {return n.toUpperCase();});
//		
//		System.out.println("Output : "+ name.join());
		
		
		// creates new threaf for the then function . total=2threads
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{return "kodewala";})
														.thenApplyAsync((name)-> {return name.toUpperCase();});
		
		System.out.println("Output : "+ cf.join());
		
	}
}
	