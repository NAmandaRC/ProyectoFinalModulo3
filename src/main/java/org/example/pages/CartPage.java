package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
    private final By selectCart = By.xpath("//a[contains(text(),'Cart')]");
    public CartPage(WebDriver driver){super(driver);}

    public void IngressCart(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(selectCart));
        driver.findElement(selectCart).click();
    }
}
