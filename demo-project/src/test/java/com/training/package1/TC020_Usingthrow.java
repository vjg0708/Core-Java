package com.training.package1;

import java.io.FileNotFoundException;

public class TC020_Usingthrow {
	
	public void createRunTimeError() {
		
		try {
			throw new FileNotFoundException("File Not Found!");
			//used for creating and throwing any user defined exception based on the data handled
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Caught inside the demo");
			
		}
	}
	
	
	public static void main(String[] args) {
		
		TC020_Usingthrow useExecption = new TC020_Usingthrow();
		
		useExecption.createRunTimeError();
	}

}
