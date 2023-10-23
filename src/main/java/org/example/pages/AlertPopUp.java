package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertPopUp extends BasePage{

    public AlertPopUp(WebDriver driver){super(driver);}

    public void closePopUp() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String print = alert.getText();
        System.out.println(print);
        alert.accept();
    }
}
