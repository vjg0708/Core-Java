package com.training.package1;

class ArrayDemo{
	
	private int nums[];
	
	public ArrayDemo(int i) {
		
		nums = new int[i];
	}
	
	public void populateArray() {
		
		for(int i=0; i<nums.length; i++) {
			
			nums[i] = i;
		}
	}
	
	public void displayArray() {
		
		for(int i = 0; i<nums.length; i++) {
			
			System.out.println("Array value of " + i + " index is : " + nums[i]);
		}
	}
}


public class TC023_Arrays {
	
	public static void main(String[] args) {
		
		int arr[] = new int[5];
		
		System.out.println(arr.length);
		
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		arr[3] = 400;
		arr[4] = 500;
		
		System.out.println("Array values : " + (arr[1]+arr[2]) );
		
		String stringData[] = new String[4];
		
		stringData[0] = "Apple";
		stringData[1] = "Orange";
		
		System.out.println("String values : " + stringData[0] + stringData[1]);
		
		int arr2[][] = new int[3][3];
		
		ArrayDemo useArray = new ArrayDemo(5);
		
		useArray.populateArray();
		
		useArray.displayArray();
		
	}

}
