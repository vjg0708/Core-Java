package pom_object_repository;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class POM_Amazon {

    WebDriver driver;

    @Setter
    @Getter
    String username;

    @Setter
    @Getter
    String password;


    public POM_Amazon(WebDriver driver){

        this.driver = driver;
    }

    public void clickActionById(String id){

         driver.findElement(By.id(id)).click();
    }

    public void clickActionByXpath(String xPath){

        driver.findElement(By.xpath(xPath)).click();
    }

    public void typeTextById(String id, String text){

        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void typeTextByXpath(String xPath, String text){

        driver.findElement(By.xpath(xPath)).sendKeys(text);
    }

    public void toggleActionsById(String id, String text){

        if(text.equalsIgnoreCase("enter")){

            driver.findElement(By.id(id)).sendKeys(Keys.ENTER);

        } else if(text.equalsIgnoreCase("backspace")) {

            driver.findElement(By.id(id)).sendKeys(Keys.BACK_SPACE);

        } else if(text.equalsIgnoreCase("select all")) {

            driver.findElement(By.id(id)).sendKeys(Keys.CONTROL + "A");

        } else if (text.equalsIgnoreCase("hover")) {

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.id(id))).perform();
        }
    }

    public void toggleActionsByXpath(String xPath, String text){

        if(text.equalsIgnoreCase("enter")){

            driver.findElement(By.xpath(xPath)).sendKeys(Keys.ENTER);

        } else if(text.equalsIgnoreCase("backspace")) {

            driver.findElement(By.xpath(xPath)).sendKeys(Keys.BACK_SPACE);

        } else if(text.equalsIgnoreCase("select all")) {

            driver.findElement(By.xpath(xPath)).sendKeys(Keys.CONTROL + "A");
        }
        else if (text.equalsIgnoreCase("hover")) {

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(xPath))).perform();
        }
    }

    public boolean checkElementsDisplayedById(String id){

        return driver.findElement(By.id(id)).isDisplayed();
    }

    public boolean checkElementsDisplayedByXpath(String xPath){

        return  driver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public WebElement getElementById(String id){

        return driver.findElement(By.id(id));

    }

    public WebElement getElementByXpath(String xpath){

        return driver.findElement(By.xpath(xpath));
    }
}
