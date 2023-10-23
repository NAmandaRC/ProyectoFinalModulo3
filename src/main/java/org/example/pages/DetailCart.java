package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailCart extends BasePage{
    private final By placeOrderButton = By.xpath("//button[@class='btn btn-success']");

    public DetailCart(WebDriver driver){super(driver);}

    public void clickPlaceOrder(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        driver.findElement(placeOrderButton).click();
    }
}
