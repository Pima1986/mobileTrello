package com.trello.mobile.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    /*BoardHelper board;
    GroupHelper group;*/
    SessionHelper session;
    private WebDriverWait wait;
    String browser;
    //ProfileHelper profile;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException, IOException {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        properties = new Properties();

        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(
                String.format("src/test/resources/%s.properties", target))));

        wd.navigate().to(properties.getProperty("web.baseURL"));

        session = new SessionHelper(wd);
        session.login(properties.getProperty("web.user"), properties.getProperty("web.pwd"));

       /* board = new BoardHelper(wd);
        group = new GroupHelper(wd);
        profile = new ProfileHelper(wd);*/

    }


    public void stop() throws InterruptedException {
        Thread.sleep(2000);
        wd.quit();
    }

   /* public ProfileHelper getProfile() {
        return profile;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public GroupHelper getGroup() {
        return group;
    }*/

    public SessionHelper getSession() {
        return session;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
