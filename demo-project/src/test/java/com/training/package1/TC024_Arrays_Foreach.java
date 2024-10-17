package com.training.package1;

public class TC024_Arrays_Foreach {

	
		public static void main(String[] args) {
			
			
			
			int arr[] = {1,2,3,4,5,6,7};
			
			for(int i : arr) {
				
				System.out.println(i);
			}
			
			int twoDimArr[][] = new int[5][5];
			
			System.out.println(twoDimArr.length);
			
			
			for(int i=0; i<twoDimArr.length;i++) {
				
				for(int j=0; j<twoDimArr.length;j++) {
					
					twoDimArr[i][j] = i;
					System.out.print(twoDimArr[i][j] + "\t");
					
				}
				
				System.out.println();
			}
		}
}
