package com.training.package1;


class Base{
	
	public void displayBase() {
		System.out.println("In Class Base");
	}
	
}

class Derived extends Base{
	
	public void displayDerived() {
		
		super.displayBase();
		System.out.println("In Class Derived");
	}
}

public class TC013_Inheritance {
	
	public static void main(String[] args) {
		
		Derived derivedObj = new Derived();
		derivedObj.displayDerived();
		
		if(derivedObj instanceof Derived && derivedObj instanceof Base) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
	}

}
