package ru.alexengovatov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPasswordPage {
    WebDriver driver;
    WebDriverWait wait;
    String nameElement = "passwd";
    String password = "2020Ru14@";
    String submitElement = "//button[@type='submit']";

    public SignInPasswordPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitingPage (WebDriver driver, WebDriverWait wait) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(nameElement)));
    }

    public void fillPassword (WebDriver driver) {
        driver.findElement(By.name(nameElement)).sendKeys(password);
    }

    public void clickSubmit (WebDriver driver) {
        driver.findElement(By.xpath(submitElement)).click();
    }
}
