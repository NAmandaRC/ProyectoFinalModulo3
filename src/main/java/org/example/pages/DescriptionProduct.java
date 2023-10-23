package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DescriptionProduct extends BasePage{
    private final By addProduct = By.xpath("//a[contains(text(),'Add to cart')]");

    public DescriptionProduct(WebDriver driver){super(driver);}

    public void addProductToCart(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(addProduct));
        driver.findElement(addProduct).click();
    }
}
