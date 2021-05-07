package ru.alexengovatov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EMailPage {
    WebDriver driver;
    WebDriverWait wait;
    String pageElement = "//input[@type='text']";
    String theme = "Simbirsoft theme";
    String searchThemeButton = "//button[@title='расширенный поиск']";
    String messageSearchElement = "//span[@class='mail-MessagesSearchInfo-Title']";
    String mailAdvancedSearchElement = "//div[@class='mail-AdvancedSearch']/button[3]";
    String foldersElement = "//button/span/span[text()='Папки']";
    String incomingElement = "//div/div/span[text()='Входящие']";
    String searchResultElement = "//div[@class='mail-MessagesSearchInfo_Summary'][text()='Результаты поиска «Simbirsoft theme» в папке «Входящие» ']";
    String quantityElement = "//span[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']";
    String writeButtonElement = "//a[@title='Написать (w, c)']";
    String sendAddressElement = "(//div[@class='compose-LabelRow'])[1]//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']/div";
    String mailAddress = "engovatovalex@yandex.ru";
    String mailThemeElement = "//input[@class='composeTextField ComposeSubject-TextField']";
    String mailTheme = "Simbirsoft theme";
    String messageBodyElement = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']";
    String sendButtonElement = "//button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']";

    public EMailPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waiting(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageElement)));
    }

    public void searchTheme(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath(pageElement)).sendKeys(theme);
        driver.findElement(By.xpath(searchThemeButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messageSearchElement)));
        driver.findElement(By.xpath(mailAdvancedSearchElement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(foldersElement)));
        driver.findElement(By.xpath(incomingElement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultElement)));
    }

    public String resultQuantity(WebDriver driver) {
        String result = String.valueOf(driver.findElement(By.xpath(quantityElement)).getText());
        return result;
    }

    public void sendMessage(WebDriver driver, String result) {
        driver.findElement(By.xpath(writeButtonElement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sendAddressElement)));
        driver.findElement(By.xpath(sendAddressElement)).sendKeys(mailAddress);
        driver.findElement(By.xpath(mailThemeElement)).sendKeys(mailTheme);
        driver.findElement(By.xpath(messageBodyElement)).sendKeys(result);
        driver.findElement(By.xpath(sendButtonElement)).click();
    }

}
