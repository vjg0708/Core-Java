package stepdefinitions_amazon;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginFeature {

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

        WebElement searchResult = pomAmazon.getElementByXpath("//span[normalize-space()='1-16 of 311 results for']");
        String resultText = searchResult.getText();
        Assert.assertEquals(resultText, "1-16 of 311 results for");
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
