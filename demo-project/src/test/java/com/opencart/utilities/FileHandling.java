package com.opencart.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandling {

    public XSSFSheet setFileConfigurations() throws IOException {

        FileInputStream inputFile = new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\src\\test\\java\\com\\opencart\\testdata\\Login Credentials.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(inputFile);

        return workbook.getSheet("Login");
    }
}
