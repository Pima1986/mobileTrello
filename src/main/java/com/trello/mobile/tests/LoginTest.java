package com.trello.mobile.tests;

import org.testng.annotations.Test;

public class LoginTest extends  TestBase {

    @Test
    public void testLogin(){
       app.getSession().initLogin();
        //fillLogin();
        //submitLogin();
        //Assert();

    }
}
