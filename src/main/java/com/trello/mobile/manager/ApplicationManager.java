package com.trello.mobile.manager;

import com.trello.mobile.tests.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
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
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public void init() throws InterruptedException, IOException {
        logger.info("Initianalisation driver");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "ce061606aa3a0f2203");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");

        capabilities.setCapability("app",
                "C:/Users/Daniel/Documents/GitHub/mobileTrello/apk/Trello_new.apk");


        driver = new AndroidDriver(new URL("Http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Ready!");
        properties = new Properties();
        String target = System.getProperty("target", "android");
        /*properties.load(new
                FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        driver.navigate().to(properties.getProperty("web.baseURL"));*/
        session = new SessionHelper(driver);
        /*session.login(properties.getProperty("web.user"), properties.getProperty("web.pwd"));*/
       /* board = new BoardHelper(wd);
        group = new GroupHelper(wd);
        profile = new ProfileHelper(wd);*/

    }

    public void stop() throws InterruptedException {
        driver.quit();
        logger.info("Finished");
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
