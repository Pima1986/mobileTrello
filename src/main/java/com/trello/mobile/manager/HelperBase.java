package com.trello.mobile.manager;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HelperBase {
    AppiumDriver driver;
    private Object TakesScreenshot;


    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void waitForElementLocatedAndType(By locator, String text, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys();
    }

    public void waitForElementAndClick(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void click(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        //no need line 30, can be deleted
        /*wd.findElement(locator).click();*/

    }

    public void returnHomePage() {
        driver.navigate().to("https://trello.com/danielpimshteyn/boards");
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean waitForElementsPresent(By locator, int timeout) {
        List<WebElement> elements = new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return elements.size() > 0;
    }

    public void waitForElementAndType(By locator, String text) {
        new WebDriverWait(driver, 20).until(presenceOfElementLocated(locator)).
                sendKeys(text);

    }

    public void takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screen " + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
