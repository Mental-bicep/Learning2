package exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prac1 {
	
	public static void main(String [] args) {
		
		try {
			int res = 10/0;
		}
		catch(ArithmeticException e) {
			System.out.println("inside arithmetic catch block");
		}
		finally {
			System.out.println("inside finally block1");
		}
		
		//--------------------------------------
		
		try {
			int res = 10/0;
		}
		catch (NullPointerException | ArithmeticException e) {
			System.out.println("inside multi catch block");
		}
		finally {
			System.out.println("inside finally block2");
		}
		
		
//		FileReader fr = null;
//		try( BufferedReader br1 = new BufferedReader(fr);
//			 BufferedReader br2 = new BufferedReader(fr);
//			 BufferedReader br3 = new BufferedReader(fr)
//				){
//			
//		}
//		catch (Exception e) {
//			
//		}
		
	}
	
}
