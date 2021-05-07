package ru.alexengovatov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    String url = "http://mail.yandex.ru";
    String waitElement = "//div/div/div/div/div/a/span[text()='Войти']";
    String buttonClickElement = "//div/div/div/div/div/a[@href='https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1'][last()]";


    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open(){
        driver.get(url);
    }

    public void atPage(WebDriver driver){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitElement)));
    }

    public void clickToSignIn(WebDriver driver) {
        driver.findElement(By.xpath(buttonClickElement)).click();
    }
}
