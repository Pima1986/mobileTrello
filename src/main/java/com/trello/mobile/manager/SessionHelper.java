package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {


    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initLogin() {
        waitForElementAndClick(By.xpath("//*[@resource-id='com.trello:id/log_in_button']"));
    }

    public void confirmLogin() {
       //wait.until(presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login-submit"));
    }

    public void fillLoginForm(String userEmail, String password) throws InterruptedException {
        type(By.xpath("//*[@resource-id='com.trello:id/user']"), userEmail);
        click(By.xpath("//*[@resource-id='android:id/button1']"));
        Thread.sleep(7000);
        waitForElementAndClick(By.xpath("//*[@class='android.view.View']"));
        //type(By.id("password"), password);
    }

    public void fillLoginFormAtlassian(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        Thread.sleep(1000);
        type(By.id("password"), password);
    }


    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassian(email, password);
        confirmLogin();
    }
}
