package com.training.package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TC032_FileIOStream {
	
	FileInputStream srcFile;
	FileOutputStream destFile;
	
	public void initFile(String srcPath, String destPath) {
		
		try {
			srcFile = new FileInputStream(srcPath);
			destFile = new FileOutputStream(destPath);
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
	public void copyFile() {
		
		try {
			
			int i = srcFile.read();
			
			while(i!=-1) {
				
				destFile.write(i);
				i  = srcFile.read();
			}
			
			
		} catch (IOException e) {
			
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
	public void closeFile() {
		
		
		try {
			
			srcFile.close();
			destFile.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		String sourceFile = "Source.txt";
		String destFile = "Dest.txt";
		
		TC032_FileIOStream fileIO = new TC032_FileIOStream();
		
		fileIO.initFile(sourceFile, destFile);
		fileIO.copyFile();
		fileIO.closeFile();
	}

}
