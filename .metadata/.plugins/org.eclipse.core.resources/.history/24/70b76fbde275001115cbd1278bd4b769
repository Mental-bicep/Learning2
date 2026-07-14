package cf4;

import java.util.concurrent.CompletableFuture;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// thenaccept, thenacceptasync
//		CompletableFuture.supplyAsync(()-> "Hello world in CF")
//						.thenAccept((str) -> System.out.println(str));
		
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(()-> "same str")
														.thenAccept((str)-> System.out.println(str));
		
		
		
		CompletableFuture.supplyAsync(()-> "Hello world in CF")
		.thenAcceptAsync((str)-> System.out.println(str));
		

	}

}
