package com.training.package1;

abstract class Shape{
	
	public abstract void draw();
	
	public abstract void paint();
}

class Rectangle extends Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is a rectangle");
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle is painted");
		
	}
	
	
}

public class TC016_Abstractkeyword {
	
	public static void main(String[] args) {
			
		Shape drawShape = new Rectangle();
		
		drawShape.draw();
		
		drawShape.paint();
	}
}
