package com.odyssey.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataSource {

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\test-odysessy\\src\\test\\java\\com\\odyssey\\testdata\\Odyssey.xlsx"));
        XSSFSheet worksheet = workbook.getSheetAt(0);

        List<Object[]> dataList = new ArrayList<>();

        for(Row row : worksheet){

            List<Object> rowData = new ArrayList<>();
            for (Cell cell : row){

                rowData.add(cell.getStringCellValue());
            }
            dataList.add(rowData.toArray());
        }

        return  dataList.toArray(new Object[0][]);
    }


}
