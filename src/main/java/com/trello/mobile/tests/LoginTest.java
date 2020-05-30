package com.trello.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends  TestBase {

    @Test
    public void testLogin() throws InterruptedException {
       app.getSession().initLogin();
        app.getSession().fillLoginForm("daniel.pimshteyn@gmail.com", "Qwerty12345");
        //submitLogin();
        Assert.assertTrue(app.getSession().waitForElementsPresent(By
                .xpath("//*[@content-desc='Open Drawer']"), 60));

    }
}
