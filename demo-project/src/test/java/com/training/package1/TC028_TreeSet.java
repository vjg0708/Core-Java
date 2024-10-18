package com.training.package1;

import java.util.Iterator;
import java.util.TreeSet;

public class TC028_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<String> useSet = new TreeSet<String>();
		
		useSet.add("Apple");
		useSet.add("HP");
		useSet.add("Dell");
		useSet.add("Lenovo");
		useSet.add("Asus");
		useSet.add("Acer");
		
		//display in sorted order
		for(String str : useSet) {
			
			System.out.println("Elements : " + str);
		}
		

	}

}
