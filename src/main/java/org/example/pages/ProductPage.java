package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class ProductPage  extends BasePage{

    private final By itemProduct = By.xpath("//div[@class='Sony vaio 15']/div");
    private final By priceProduct = By.xpath("//div[@class='$790']/div");
    private final By descriptionProduct = By.xpath("//div[@class='card-text']");

    public ProductPage(WebDriver driver){ super(driver);}

    public String getProductName(){ return driver.findElement(itemProduct).getText(); }

    public String getProductPrice(){ return driver.findElement(priceProduct).getText(); }

    public String getProductDescription(){ return driver.findElement(descriptionProduct).getText(); }
}
