package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage{

    private final By ingressCategory = By.xpath("//a[contains(text(),'Laptops')]");

    public CategoryPage(WebDriver driver){super(driver);}

    public void selectCategory(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(ingressCategory));
        driver.findElement(ingressCategory).click();
    }
}
