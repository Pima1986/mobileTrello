package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {


    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initLogin() {
        waitForElementAndClick(By.id("log_in_button"));
    }

    public void confirmLogin() {
       //wait.until(presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login-submit"));
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
