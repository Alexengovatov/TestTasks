package ru.alexengovatov;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSISoft {

    /**
     * @author Alex Engovatov
     * Apr 2021
     * 24 sec
     *
     * Aim: Make authrization and send a message for myself with quantity of messages with theme "Simbersoft theme"
     * Steps:
     * 1. Open chromedriver and go to mail.yandex.ru
     * 2. Authorization
     * 3. Search quantity of messages
     * 4. Save quantity of messages into variable
     * 5. Send a message with quantity
*/
    private static final Logger logger = LogManager.getLogger(TestSISoft.class);

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void settings() {
        logger.info("Set settings");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver =new ChromeDriver();

    }
    @After
    public void close(){
        driver.quit();

    }
    @Test
    public void test(){
        MainPage mainPage = new MainPage(driver, wait);
        SignInLoginPage signInLoginPage = new SignInLoginPage(driver, wait);
        SignInPasswordPage signInPasswordPage = new SignInPasswordPage(driver, wait);
        EMailPage eMailPage = new EMailPage(driver, wait);
        String result;

        logger.info("Start Chrome");
        mainPage.open();
        mainPage.atPage(driver);
        mainPage.clickToSignIn(driver);

        logger.info("Authorization login page");
        signInLoginPage.waitingPage(driver, wait);
        signInLoginPage.fillLoginField(driver);
        signInLoginPage.waitingPage(driver, wait);
        signInLoginPage.clickSubmit(driver);

        logger.info("Authorization password page");
        signInPasswordPage.waitingPage(driver, wait);
        signInPasswordPage.fillPassword(driver);
        signInPasswordPage.waitingPage(driver, wait);
        signInPasswordPage.clickSubmit(driver);

        logger.info("Searching quantity of messages");
        eMailPage.waiting(driver);
        eMailPage.searchTheme(driver);
        logger.info("Save quantity of messages");
        result = eMailPage.resultQuantity(driver);
        logger.info("Writing message and send");
        eMailPage.sendMessage(driver, result);
        logger.info("Test passed");
    }
}
