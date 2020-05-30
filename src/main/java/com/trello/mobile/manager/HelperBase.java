package com.trello.mobile.manager;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
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

    public void swipeToLeft(By locator) {
        TouchAction action = new TouchAction(driver);
        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX() * 0.2);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);
        int upperY = (int) (element.getLocation().getY());
        int lowerY = (int) (upperY + element.getSize().getHeight());
        int middleY = (upperY + lowerY) / 2;

        action
                .press(PointOption.point(rightX, middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();
    }

    //scrolling monitor
    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        TouchAction action = new TouchAction(driver);

        int middleX = size.width / 2;
        int lowerY = (int) (size.height * 0.7);
        int upperY = (int) (size.height * 0.2);

        action
                .press(PointOption.point(middleX, lowerY))
                .moveTo(PointOption.point(middleX, upperY))
                .release()
                .perform();

    }

}
