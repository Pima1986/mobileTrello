package com.trello.mobile.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin()
    {
        click(By.cssSelector("[href='/login']"));
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
