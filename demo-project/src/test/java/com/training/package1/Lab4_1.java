package com.training.package1;


import java.io.*;

public class Lab4_1 {

    Reader readFile = null;
    Writer writeFile = null;

    public  String reverseFileContent(String path){

        StringBuilder content = new StringBuilder();
        String result = null;
        try {

            readFile = new FileReader(path);
            writeFile = new FileWriter(path);

            int data;

            while((data = readFile.read())!=-1){

                content.append((char) data);
            }
            result = content.reverse().toString();
             writeFile.write(result);

        }

        catch (IOException e1) {

            System.out.println("Exception : " + e1.getMessage());
        }


        return result;
    }

    public void closeFileObjects(){

         {
            try {

                if (readFile!=null) readFile.close();
                if(writeFile!=null) writeFile.close();

            } catch (IOException e) {

                System.out.println("Exception : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        String filepath = "lab4.1.txt";

        Lab4_1 useObject = new Lab4_1();

        String resultContent = useObject.reverseFileContent(filepath);

        System.out.println("Reversed file content is : " + resultContent);

        useObject.closeFileObjects();
    }
}
