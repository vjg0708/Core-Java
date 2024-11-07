package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import com.opencart.pageobjects.POM_LoginPageFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestNGLogin {

    WebDriver driver;
    JavascriptExecutor js;

    @Test
    public void initiateLogin() throws IOException {

        /*using property configuration*/

        //getting project directory
        String projectpath = System.getProperty("user.dir");
        System.out.println(projectpath);

        Properties properties = new Properties();
        InputStream input = Files.newInputStream(Paths.get(projectpath+"\\login.properties"));

        properties.load(input);

        String opencartURl = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        driver.get(opencartURl);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;

        POM_LoginPageFactory pomLogin = PageFactory.initElements(driver, POM_LoginPageFactory.class);

        pomLogin.enterUserName(username);
        pomLogin.enterPassword(password);

        js.executeScript("window.scrollBy(0,300)");

        pomLogin.clickLoginButton();
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
