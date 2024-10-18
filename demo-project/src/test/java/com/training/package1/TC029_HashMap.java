package com.training.package1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TC029_HashMap {
	
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("1001","Apple");
		map.put("1002","Samsung");
		map.put("1003","OnePlus");
		map.put("1004","Nothing");
		map.put("1005","Redmi");
		map.put(null, null);//null k,v pairs are accepted
		map.put("1006","Realme");
		
		System.out.println(map);
		System.out.println(map.get("1002"));
		System.out.println(map.values());
		System.out.println(map.keySet());
		
		Set<?> sm = map.entrySet();
		
		Iterator<?> itr = sm.iterator();
		
		while(itr.hasNext()) {
			
			Map.Entry m = (Map.Entry)itr.next();
			
			System.out.println("Key : " + m.getKey() + " " + "Values : " + m.getValue());
		}
		
		Set s = new TreeSet();
		
		s.add("2");
		s.add("2");
		s.add("4");
		s.add("3");
		
		Iterator i = s.iterator();
		
		while(i.hasNext()) {
			
			System.out.print(i.next() + " ");
			
		}
		
		
		
	}

}
