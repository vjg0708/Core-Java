package com.training.package1;

import java.util.ArrayList;

public class TC026_ArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("Hello");
		arrayList.add("World");
		arrayList.add("Orange");
		arrayList.add("Apple");
		arrayList.add("Mango");
		
		System.out.println("Array list size : " + arrayList.size());
		System.out.println("Check element availability of World : " + 
		arrayList.contains("World"));
		System.out.println("reterive element in index 1 : " + arrayList.get(1));
		System.out.println("Remove element :" + arrayList.remove("Mango"));
		System.out.println("update element at index 2 : " + arrayList.set(2, "Happy"));
		System.out.println("Display Elements : " + arrayList);
		System.out.println("Remove all elements : " + arrayList.removeAll(arrayList));
		System.out.println("list after deletion : " + arrayList);
		
		
	}
	
}