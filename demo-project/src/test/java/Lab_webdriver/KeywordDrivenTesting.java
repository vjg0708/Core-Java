package Lab_webdriver;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;
import testNG.TestNGLoginExcel;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KeywordDrivenTesting {


    public static void login(TestNGLoginExcel login) throws IOException, ParserConfigurationException, SAXException {

        login.beforeClass();
        login.initiateLogin();
        login.tearDown();
    }

    public  static  void close(TestNGLoginExcel close){


        close.beforeClass();
        close.afterClass();

    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        FileInputStream input = new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\KeywordDriven.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet module = workbook.getSheet("Module");

        int noOfRows = module.getPhysicalNumberOfRows();
        System.out.println("No of Rows : " + noOfRows);

        for (int i=0;i<noOfRows;i++){

            String moduleExe = module.getRow(i).getCell(2).getStringCellValue();
            if(moduleExe.equals("Y")){

                String moduleId = module.getRow(i).getCell(0).getStringCellValue();

                XSSFSheet testcase = workbook.getSheet("Testcase");

                int rowOfTC = testcase.getPhysicalNumberOfRows();
                System.out.println("No of rows for sheet2 : " + rowOfTC);

                for (int j=0;j<rowOfTC;j++){

                    String moduleIDTc = testcase.getRow(j).getCell(3).getStringCellValue();
                    String testCaseExc = testcase.getRow(j).getCell(2).getStringCellValue();
                    String testCaseName = testcase.getRow(j).getCell(1).getStringCellValue();

                    if (moduleIDTc.equals(moduleId) && testCaseExc.equals("Y")){

                        String testCaseID = testcase.getRow(j).getCell(0).getStringCellValue();

                        XSSFSheet teststep = workbook.getSheet("Teststep");
                        int rowOfTs = teststep.getPhysicalNumberOfRows();
                        System.out.println("No of rows for sheet3 : " + rowOfTs);

                        for (int k=0;k<rowOfTs;k++){

                            String testCaseIdTs = teststep.getRow(k).getCell(4).getStringCellValue();
                            String testCaseKeyword = teststep.getRow(k).getCell(3).getStringCellValue();

                            if (testCaseIdTs.equals(testCaseID)){

                                TestNGLoginExcel testNG = new TestNGLoginExcel();
                                switch (testCaseKeyword){

                                    case "ln":
                                        KeywordDrivenTesting.login(testNG);
                                        break;
                                    case "ca":
                                        KeywordDrivenTesting.close(testNG);
                                        break;
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
