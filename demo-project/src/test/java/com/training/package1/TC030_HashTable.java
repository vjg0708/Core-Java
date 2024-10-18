package com.training.package1;

import java.util.Hashtable;

public class TC030_HashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Double> table = new Hashtable<String, Double>();
		
		table.put("Ram", 80.5);
		table.put("Harrish", 89.0);
		//table.put(null, 0.0);//key should not be null
		table.put("Pooja", 90.0);
		
		System.out.println(table.keys());
		System.out.println(table);
		System.out.println(table.keySet());
		System.out.println(table.values());
	}

}
