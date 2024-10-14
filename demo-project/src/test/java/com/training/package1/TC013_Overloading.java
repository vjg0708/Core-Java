package com.training.package1;

class BoxType{
	
	double length;
	double width;
	double height;
	
	BoxType(){
		System.out.println("Constructor without parameter");
	}
	
	BoxType(double l, double w, double h){
		
		this.length = l;
		this.width = w;
		this.height = h;
		
		System.out.println("Constructor with parameters");
	}
	
	
}

public class TC013_Overloading {
	
	
	public static void main(String[] args) {
		
		BoxType withoutParam = new BoxType();
		BoxType withParam = new BoxType(100,20,60);
		
		
		
	}
}
