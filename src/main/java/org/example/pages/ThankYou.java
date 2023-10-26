package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThankYou extends BasePage{

    private final By buttonOK = By.xpath("//button[contains(text(),'OK')]");
    private final By confirmPurchase = By.xpath("//h2[contains(text(), 'Thank you for your purchase')]");
    public ThankYou(WebDriver driver) {super(driver);}


    public boolean validatePurchase(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(buttonOK));
        return driver.findElement(confirmPurchase).isDisplayed();
    }
    public void clickOK(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(buttonOK));
        driver.findElement(buttonOK).click();
    }
}
