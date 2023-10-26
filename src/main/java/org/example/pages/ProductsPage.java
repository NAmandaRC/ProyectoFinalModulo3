package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{
    private final By selectProduct = By.xpath("//a[contains(text(),'Sony vaio i5')]");



    public ProductsPage(WebDriver driver){super(driver);}

    public void selectValidateProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(selectProduct));
        driver.findElement(selectProduct).click();
    }

}
