package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmPuchase extends BasePage{

    private final By purchase = By.xpath("//button[contains(text(),'OK')]");
    public ConfirmPuchase(WebDriver driver) {
        super(driver);
    }

    public void clickOK(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(purchase));
        driver.findElement(purchase).click();
    }
}
