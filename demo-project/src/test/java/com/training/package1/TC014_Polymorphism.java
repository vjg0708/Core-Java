package com.training.package1;


class Swipemachine{
	
	public void readCard() {
		
		System.out.println("In Swipemachine");
	}
}

class ChipCardmachine extends Swipemachine{
	
	public void readCard() {
		
		//super.readCard();
		System.out.println("In Chip card machine");
	}
}

public class TC014_Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Swipemachine usemachine = new Swipemachine();
		usemachine.readCard();
		
		usemachine = new ChipCardmachine();
		usemachine.readCard();

	}

}
