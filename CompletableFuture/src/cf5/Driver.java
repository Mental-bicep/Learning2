package cf5;

import java.util.concurrent.CompletableFuture;

public class Driver {
	public static void main(String [] args) {
		
		CompletableFuture<Integer> fut1 = CompletableFuture.supplyAsync(() -> 10);
		CompletableFuture<Integer> fut2 = CompletableFuture.supplyAsync(() -> 20);
		
		CompletableFuture<Integer> res = fut1.thenCombine(fut2, (res1,res2) -> res1+res2);
		
		System.out.println("Final res is "+ res.join());
		
	}
}
