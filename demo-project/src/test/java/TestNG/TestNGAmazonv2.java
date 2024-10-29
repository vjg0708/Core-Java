package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pom_object_repository.POM_Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNGAmazonv2 {

    WebDriver driver;
    JavascriptExecutor js;
    POM_Amazon pomAmazon;

    @Test
    public void startFlow() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*user login*/

        System.out.println("User login:");
        //sending and typing username
        pomAmazon.typeTextByXpath("//*[@id=\"ap_email\"]", pomAmazon.getUsername());
        pomAmazon.clickActionById("continue");

        //entering the password and signing in
        pomAmazon.typeTextById("ap_password", pomAmazon.getPassword());
        pomAmazon.clickActionById("signInSubmit");

        if(pomAmazon.checkElementsDisplayedByXpath("/html")){

            Assert.assertTrue(true);
            System.out.println("Page is successfully displayed with source URl : " +
                    driver.getCurrentUrl());

        }
        else { Assert.fail();}

        /*search product from search box*/

        System.out.println("Products search:");
        //enter product name and enter
        pomAmazon.typeTextById("twotabsearchtextbox", "monitors of LG brand");
        pomAmazon.toggleActionsById("twotabsearchtextbox", "enter");

        /*sort products based on bestseller*/

        System.out.println("Sort products:");
        //toggle the sort option
        pomAmazon.clickActionByXpath("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span");

        //click on bestsellers
        pomAmazon.clickActionByXpath("//*[@id=\"s-result-sort-select_5\"]");

        if(pomAmazon.checkElementsDisplayedByXpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']//div[@class='sg-col-inner']")){

            Assert.assertTrue(true);
            System.out.println("Product page displayed successfully");
        }
        else{ Assert.fail();}

        /*click and view product details*/

        System.out.println("Product details :");
        //navigating to product page
        pomAmazon.clickActionByXpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a");

       //creating a list to store window handle
        List<String> window = new ArrayList<>(driver.getWindowHandles());


        //switch window to product details
        driver.switchTo().window(window.get(1));

        Thread.sleep(2000);
        //scrolling below
        js.executeScript("window.scrollBy(0,380)");

        /*add product to cart*/

        System.out.println("add to cart:");
        //click add to cart button
        pomAmazon.clickActionByXpath("//input[@id='add-to-cart-button']");

        //to check a popup for cart is displayed
        if (pomAmazon.checkElementsDisplayedByXpath("/html/body/div[8]/div[3]/div[3]/div")){

            Assert.assertTrue(true);
            pomAmazon.clickActionByXpath("/html/body/div[8]/div[3]/div[3]/div/div[1]/a");
        }
        else{ Assert.fail();}

        //scroll to top of the page
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,0)");

        /*visit cart and delete products*/

        System.out.println("delete items in cart");
        //navigate to product cart
        pomAmazon.clickActionByXpath("//a[@id='nav-cart']");

        //check products are displayed in cart
        if (pomAmazon.checkElementsDisplayedByXpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]")){

            Assert.assertTrue(true);

            //delete item from cart
            pomAmazon.clickActionByXpath("//button[@aria-label='Decrease quantity by one']");

            System.out.println("items deleted successfully");
        }




    }

    @BeforeMethod
    public void setUp() {

        /*setup driver to open amazon*/
        System.out.println("Driver initialization and page loading");
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();

        System.out.println("Driver session started..");
        /*storing username and password*/
        pomAmazon.setUsername("harrishvijay0708@gmail.com");
        pomAmazon.setPassword("vijay#0780");
    }

    @AfterMethod
    public void tearDown() {


        /*logout*/
        pomAmazon.toggleActionsByXpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]",
                "hover");
        pomAmazon.checkElementsDisplayedByXpath("//span[normalize-space()='Sign Out']");

        System.out.println("logout successful");
        driver.close();
    }

    @BeforeClass
    public void beforeClass() {

        /*setting up chrome driver*/

        System.out.println("setting up the driver..");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /*setting up POM object */

        System.out.println("creating POM object..");
        pomAmazon = new POM_Amazon(driver);

        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void afterClass() {

        driver.quit();

        System.out.println("Driver session closed");
    }
}
