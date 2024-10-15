package com.training.package1;

class TV{
	
	public void switchOnTV() {
		
		System.out.println("TV ON");
	}
}

class SmartTV extends TV{
	
	@Override
	public void switchOnTV() {
		
		System.out.println("Smart TV ON");
	}
}

public class TC015_Override {
	
	public static void main(String[] args) {
		
		SmartTV useTv = new SmartTV();
		
		useTv.switchOnTV();
	}

}
