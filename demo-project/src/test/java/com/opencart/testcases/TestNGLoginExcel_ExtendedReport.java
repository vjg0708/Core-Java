package com.opencart.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.methods.BaseClass;
import com.opencart.utilities.FileHandling;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import pom_object_repository.POM_LoginPageFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestNGLoginExcel_ExtendedReport{

    WebDriver driver;
    JavascriptExecutor js;



    @Test
    public void initiateLogin() throws IOException, ParserConfigurationException, SAXException, InterruptedException {

        /*using property configuration*/

        //getting project directory
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

       /* Properties properties = new Properties();
        InputStream input = Files.newInputStream(Paths.get(projectpath+"\\login.properties"));

        properties.load(input);

        String opencartURl = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");*/

        //reading xml file
       /* File xmlFile = new File(projectpath+"\\Login.xml");

        *//*getting data from XML using documnet builder*//*
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document dbDoc = (Document) dbBuilder.parse(xmlFile);

        //getting child nodes
        NodeList nodeList = ((Node) dbDoc).getChildNodes();
        Node node = nodeList.item(0);

        System.out.println("List count : " + nodeList.getLength());
        System.out.println("Node : " + node.getNodeName());
        //getting elements from xml
        Element element = (Element) node;

        //storing the xml elements as string variables
        String openCartUrl = element.getElementsByTagName("url").item(0).getTextContent();
        String username = element.getElementsByTagName("username").item(0).getTextContent();
        String password = element.getElementsByTagName("password").item(0).getTextContent();*/

        /*Creating customised report*/

        //creating a report object
        ExtentReports extent = new ExtentReports();
        //creating the report source file as html document
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        //attaching report object to html document
        extent.attachReporter(spark);

        //create a testcase object for checking the title of the page
        ExtentTest test = extent.createTest("Verify the title");

        XSSFSheet testData;
        FileHandling useUtility = new FileHandling();
        testData = useUtility.setFileConfigurations();

        int noOfRows = testData.getPhysicalNumberOfRows();

        for(int i=0;i<noOfRows;i++) {

            String openCartUrl = testData.getRow(i).getCell(0).getStringCellValue();
            String username = testData.getRow(i).getCell(1).getStringCellValue();

            int pwd = (int) testData.getRow(i).getCell(2).getNumericCellValue();
            String password = Integer.toString(pwd);

            String browserType = testData.getRow(i).getCell(3).getStringCellValue();

            BaseClass baseClass = new BaseClass(driver);
            driver = baseClass.setup(openCartUrl, browserType);


            Thread.sleep(4000);
            if(driver.getTitle().equals("Your Store")){

                test.pass("Page Title is displayed successfully");
            }
            else {

                test.fail("Page Title is not displayed");
                File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(ssFile, new File("ssFile1.jpg"));
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            js = (JavascriptExecutor) driver;

            POM_LoginPageFactory pomLogin = PageFactory.initElements(driver, POM_LoginPageFactory.class);

            pomLogin.enterUserName(username);
            pomLogin.enterPassword(password);

            js.executeScript("window.scrollBy(0,300)");

            pomLogin.clickLoginButton();

            //closing the resource
            extent.flush();

            baseClass.tearDown();

        }
    }

    @AfterMethod
    public void tearDown() {


    }

    @BeforeMethod
    public void setUp() {


    }

    @AfterClass
    public void afterClass() {


    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("before class");


    }
}
