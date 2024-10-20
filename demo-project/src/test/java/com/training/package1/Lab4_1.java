package com.training.package1;


import java.io.*;

public class Lab4_1 {

    
    public  String reverseFileContent(String sourcepath){
    	
    	Reader readFile = null;
        Writer writeFile = null;


        StringBuilder content = new StringBuilder();
    
        try {

            readFile = new FileReader(sourcepath);
           

            int data ;

            while((data = readFile.read())!=-1){

                content.append((char) data);
         
            }

            if(readFile!=null) readFile.close();
            

        }

        catch (IOException e1) {

            System.out.println("Exception : " + e1.getMessage());
        }
        
        try {
        	
        	 writeFile = new FileWriter(sourcepath);
        	 
        	 content.reverse();
        	 
        	 writeFile.write(content.toString());
        	 
        	 if(writeFile!=null) writeFile.close();
        }
        catch( IOException e) {
        	
        	System.out.println("Exception : "+ e.getMessage());
        }


        return content.toString();
    }

    
    

    public static void main(String[] args) {

        String sourcepath = "Lab4.txt";
       

        Lab4_1 useObject = new Lab4_1();

        String resultContent = useObject.reverseFileContent(sourcepath);

        System.out.println("Reversed file content is : " + resultContent);

       
    }
}
