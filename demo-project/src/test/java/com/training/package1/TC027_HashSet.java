package com.training.package1;

import java.util.HashSet;

public class TC027_HashSet {
	
	public static void main(String[] args) {
		
		HashSet<Integer> useSet = new HashSet<Integer>();
		
		useSet.add(100);
		useSet.add(200);
		useSet.add(300);
		useSet.add(400);
		useSet.add(500);
		useSet.add(500);
		useSet.add(600);
		
		for(Integer i : useSet) {
			
			System.out.println("Element : " + i);
		}
		
		System.out.println("Set size : " + useSet.size());
		System.out.println("remove element : " + useSet.remove(600));
		System.out.println("Display elements : " + useSet + " " + "and size : " + useSet.size());
		//updation is not possible in hashset
	}

}
 