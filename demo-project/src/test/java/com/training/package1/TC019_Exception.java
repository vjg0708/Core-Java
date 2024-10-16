package com.training.package1;

public class TC019_Exception {
	
	public static void main(String[] args) {
		
		int a = 0;
		try {
			
			String string1 = null;
			string1.equals("Hello");
			
			int c = 2/a;
			
			String[] words = {"hello", "world"};
			System.out.println(words[2]);
				
		}
		catch (NullPointerException e1) {
			
			System.out.println(e1.toString());
			
		}
		
		catch (ArithmeticException e2) {
			
			System.out.println(e2.toString());
			
		}
		catch (ArrayIndexOutOfBoundsException e3) {
			
			System.err.println(e3.toString());
		}
		catch (Exception e) {
			
			System.out.println(e.toString());
		}
		finally {
			
			System.out.println("End of exception");
		}
		
		
		System.out.println("Hello");
	}

}
