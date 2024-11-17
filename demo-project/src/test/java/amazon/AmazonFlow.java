package amazon;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pom_object_repository.POM_Amazon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AmazonFlow {

    WebDriver driver;
    JavascriptExecutor js;
    POM_Amazon pomAmazon;
    Properties properties;
    String url;
    String username;
    String password;


    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        pomAmazon = new POM_Amazon(driver);
    }


    @Given("open the browser")
    public void open_the_browser() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\amazonLogin.properties"));


        driver.manage().window().maximize();
        System.out.println("driver");
    }

    @Given("navigate to the url")
    public void navigate_to_the_url() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        url = properties.getProperty("url");
        driver.get(url);
        js = (JavascriptExecutor) driver;
    }

    @When("enter valid username and password")
    public void enter_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions

        username = properties.getProperty("username");
        password = properties.getProperty("password");
        System.out.println("set driver to pom");


        pomAmazon.typeTextByXpath("//*[@id=\"ap_email\"]", username);
        pomAmazon.clickActionById("continue");
        pomAmazon.typeTextById("ap_password", password);

    }

    @When("click the login button")
    public void click_the_login_button() {
        // Write code here that turns the phrase above into concrete actions

        pomAmazon.clickActionById("signInSubmit");

    }

    @Then("verify the login")
    public void verify_the_login() {
        // Write code here that turns the phrase above into concrete actions

        try{

            Thread.sleep(5000);
            WebElement greetingMessage = pomAmazon.getElementByXpath("//span[@id='nav-link-accountList-nav-line-1']");
            String message = greetingMessage.getText();

            Assert.assertEquals(message,"Hello, Harrish");
            System.out.println("Message : "+message);
            System.out.println("Login successful");
        }catch (Exception e){

            System.out.println("Login unsuccessful");
            throw new RuntimeException(e);

        }



    }

    @Given("enter product name in search")
    public void enter_product_name_in_search() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);

        pomAmazon.typeTextByXpath("//input[@id='twotabsearchtextbox']", "monitors of LG brand");
        pomAmazon.toggleActionsByXpath("//input[@id='twotabsearchtextbox']", "enter");


    }

    @Then("check whether the products are displayed")
    public void check_whether_the_products_are_displayed() {
        // Write code here that turns the phrase above into concrete actions

        WebElement searchResult = pomAmazon.getElementByXpath("//span[@class='a-size-base a-color-base'][normalize-space()='Computers & Accessories']");
        String resultText = searchResult.getText();
        Assert.assertEquals(resultText, "Computers & Accessories");
    }

    @Then("sort the product details")
    public void sort_the_product_details() {
        // Write code here that turns the phrase above into concrete actions
        pomAmazon.clickActionByXpath("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span");
        pomAmazon.clickActionByXpath("//*[@id=\"s-result-sort-select_5\"]");
    }

    @Then("open the product details")
    public void open_the_product_details() {
        // Write code here that turns the phrase above into concrete actions


        pomAmazon.clickActionByXpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a");
        List<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(1));

    }

    @Then("add the product to cart")
    public void add_the_product_to_cart() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,380)");
        WebElement addToCart = pomAmazon.getElementByXpath("//input[@id='add-to-cart-button']");

        addToCart.click();

        WebElement popUpCart = pomAmazon.getElementByXpath("//div[@class='a-scroller attach-accessory-section a-scroller-vertical']");
        Assert.assertTrue(popUpCart.isDisplayed());

        pomAmazon.clickActionByXpath("//a[@id='attach-close_sideSheet-link']");


    }

    @Then("verify the cart has the product")
    public void verify_the_cart_has_the_product() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,0)");
        pomAmazon.clickActionByXpath("//a[@id='nav-cart']");

        WebElement cartItem = pomAmazon.getElementById("sc-active-cart");
        Assert.assertTrue(cartItem.isDisplayed());


    }

    @Then("delete the product from the cart")
    public void delete_the_product_from_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        pomAmazon.clickActionByXpath("//button[@aria-label='Decrease quantity by one']");
    }

    @Then("logout from the page")
    public void logout_from_the_page() {
        // Write code here that turns the phrase above into concrete actions
        pomAmazon.toggleActionsByXpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]",
                "hover");
        pomAmazon.checkElementsDisplayedByXpath("//span[normalize-space()='Sign Out']");
        System.out.println("logout successful...");
    }



    @When("enter invalid username and password")
    public void enter_invalid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        pomAmazon.typeTextByXpath("//*[@id=\"ap_email\"]", "harrishvijay0708@gmail.com");
        pomAmazon.clickActionById("continue");
        pomAmazon.typeTextById("ap_password", "vijay");

    }

    @After
    public void tearDown(){

        driver.close();
        driver.quit();
    }

}
