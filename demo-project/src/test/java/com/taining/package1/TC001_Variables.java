package com.taining.package1;
import com.training.package2.*;
import com.training.package3.*;
import com.training.package3.Class;




class Box{
	
	 double dbWidth =10;
	 double dbheight = 20;
	 double dbLength = 30;
	
	 static int boxId;
	
	 public double calcVolume() {
		
		double doubleTemp;
		doubleTemp = dbheight*dbLength*dbWidth;
		
		return doubleTemp;
	}
}

public class TC001_Variables {
	
	
	
	public static void main(String[] args) {
		
		Box boxObject =  new Box();
		
		Student studentObj = new Student();
		Teacher teacherObj = new Teacher();
		
		Class classObj = new Class();
		School schoolObj = new School();
		
		System.out.println(boxObject.calcVolume());
		
		studentObj.displayPackage21();
		teacherObj.displaypackage22();
		
		classObj.displayPackage31();
		schoolObj.dispalyPackage32();
		
	}
	
	
}
