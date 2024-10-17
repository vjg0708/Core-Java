package com.training.package1;

import java.io.FileNotFoundException;
import java.io.FileReader;



class TC022_Inherit extends TC021_UsingThrows{
	
	public  void display() {
		
		try {
			useThrows();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
	}
}

public class TC021_UsingThrows {
	
	public static void useThrows() throws FileNotFoundException{
		
		System.out.println("In method");
		
		FileReader fileOpen = new FileReader("text12.txt");
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		TC022_Inherit handleException = new TC022_Inherit();
		
		handleException.display();
	}

}
