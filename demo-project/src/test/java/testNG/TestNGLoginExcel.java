package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import com.opencart.pageobjects.POM_LoginPageFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestNGLoginExcel {

    WebDriver driver;
    JavascriptExecutor js;

    @Test
    public void initiateLogin() throws IOException, ParserConfigurationException, SAXException {

        /*using property configuration*/

        //getting project directory
        String projectpath = System.getProperty("user.dir");
        System.out.println(projectpath);

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

        /*using Excel sheet*/
        //getting the Excel file
        FileInputStream input = new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\Book 1.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheet("Login");

        int noOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows : " + noOfRows);



        for(int i=0;i<noOfRows;i++) {



            String openCartUrl = sheet.getRow(i).getCell(0).getStringCellValue();
            String username = sheet.getRow(i).getCell(1).getStringCellValue();
            Integer pwd = (int) sheet.getRow(i).getCell(2).getNumericCellValue();

            String password = Integer.toString(pwd);

            driver.get(openCartUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            js = (JavascriptExecutor) driver;

            POM_LoginPageFactory pomLogin = PageFactory.initElements(driver, POM_LoginPageFactory.class);

            pomLogin.enterUserName(username);
            pomLogin.enterPassword(password);

            js.executeScript("window.scrollBy(0,300)");

            pomLogin.clickLoginButton();



        }
    }

    @AfterMethod
    public void tearDown() {

        driver.close();

    }

    @BeforeMethod
    public void setUp() {


    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("before class");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
}
