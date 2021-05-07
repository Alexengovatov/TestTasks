package ru.alexengovatov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    String startWaitElement = "//button[@class='Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit']/span[text()='Войти']";
    String loginFieldElement = "passp-field-login";
    String login = "engovatovalex";
    String signInElement = "//button[@type='submit']";

    public SignInLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitingPage (WebDriver driver, WebDriverWait wait) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(startWaitElement)));
    }

    public void fillLoginField(WebDriver driver) {
        driver.findElement(By.id(loginFieldElement)).sendKeys(login);
    }

    public void clickSubmit (WebDriver driver) {
        driver.findElement(By.xpath(signInElement)).click();
    }

}
