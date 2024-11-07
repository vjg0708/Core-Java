package com.opencart.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelConfig {

    @DataProvider(name = "loginCredentials")
    public String[][] readExcelData() throws IOException {



        FileInputStream inputFile = new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\src\\test\\java\\com\\opencart\\testdata\\Login Credentials.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputFile);

        XSSFSheet sheet = workbook.getSheet("Login");

        int rowSize = sheet.getPhysicalNumberOfRows();
        int columnSize = sheet.getRow(0).getLastCellNum();

        System.out.println("Row size : " + rowSize);
        System.out.println("Column size : " + columnSize);

        String[][] loginData = new String[rowSize][columnSize-1];

        for (int i=0;i<rowSize;i++){

            String username = sheet.getRow(i).getCell(1).getStringCellValue();
            int password = (int)sheet.getRow(i).getCell(2).getNumericCellValue();

            String pwd = Integer.toString(password);

            String browserType = sheet.getRow(i).getCell(3).getStringCellValue();

            loginData[i][0] = username;
            loginData[i][1] = pwd;
            loginData[i][2] = browserType;
        }

        workbook.close();

        return loginData;
    }
}
