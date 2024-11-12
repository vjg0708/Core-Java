package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pom_object_repository.POM_Login;

import java.util.concurrent.TimeUnit;

public class OpenCartLogin {

    WebDriver driver;
    POM_Login login;
    JavascriptExecutor js;
    //open browser
    @Given("launch the browser")
    public void launch_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

    }
    @Given("Navigate to the URL")
    public void navigate_to_the_url() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        login = PageFactory.initElements(driver, POM_Login.class);


    }

    //successful login
    @When("Enter the valid username and password")
    public void enter_the_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        login.enterUserName("harrishvijay0708@gmail.com");
        login.enterPassword("123456");


    }
    @When("Click on login button")
    public void click_on_login_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        js.executeScript("window.scrollBy(0,370)");
        Thread.sleep(3000);
        login.clickLoginButton();


    }
    @Then("Verify the login")
    public void login_should_be_successful() {
        // Write code here that turns the phrase above into concrete actions


        try{
            if(driver.findElement(By.linkText("Logout")).isDisplayed()){

                System.out.println("Login successful");
            }
            else {

                System.out.println("Login unsuccessful");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    //unsuccessful login
    @When("Enter the invalid username and password")
    public void enter_the_invalid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        login.enterUserName("hhh0708@gmail.com");
        login.enterPassword("111111");


    }

    @And("close the browser")
    public void close_the_browser(){

        driver.close();
        driver.quit();
    }





}
