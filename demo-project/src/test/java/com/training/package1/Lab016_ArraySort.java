package com.training.package1;

import java.util.Arrays;

public class Lab016_ArraySort {
	
	public static void sortArrays(String...input) {
		
		Arrays.sort(input);
		
		//System.out.println(Arrays.toString(input));
		
		for(String i : input) {
			
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		String products[] = {"Book", "Table", "AC", "Refridgerator", "Television"};
		
		sortArrays(products);
	}

}
