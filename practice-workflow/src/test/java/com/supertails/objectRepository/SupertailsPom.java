package com.supertails.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SupertailsPom {

    WebDriver driver;

    public SupertailsPom(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementById(String id) {

        driver.findElement(By.id(id)).click();
    }

    public void clickElementByXpath(String xpath) {

        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean checkVisibilityById(String id) {

        return driver.findElement(By.id(id)).isDisplayed();
    }

    public boolean checkVisibilityByXpath(String xpath) {

        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public void inputDataById(String id, String input) {

        driver.findElement(By.id(id)).sendKeys(input);

    }

    public void inputDataByXpath(String xpath, String input) {

        driver.findElement(By.id(xpath)).sendKeys(input);

    }

    public void toggleActionsById(String id, String action) {

        switch (action) {

            case "select all" -> driver.findElement(By.id(id)).sendKeys(Keys.CONTROL + "A");
            case "backspace" -> driver.findElement(By.id(id)).sendKeys(Keys.BACK_SPACE);
            case "enter" -> driver.findElement(By.id(id)).sendKeys(Keys.ENTER);
            case "hover" -> {

                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.id(id))).perform();
            }
        }
    }

    public void toggleActionsByXpath(String xpath, String action) {

        switch (action) {

            case "select all" -> driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL + "A");
            case "backspace" -> driver.findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE);
            case "enter" -> driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
            case "hover" -> {

                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.xpath(xpath))).perform();
            }
        }
    }
}
