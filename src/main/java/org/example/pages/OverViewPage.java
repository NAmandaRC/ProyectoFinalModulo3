package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OverViewPage extends BasePage{

    private final By itemProduct = By.xpath("//h2[@class='name']");
    private final By priceProduct = By.xpath("//h3[contains(text(), '$790')]");
    private final By addToCart = By.xpath("//a[contains(text(),'Add to cart')]");

    private final By descriptionProduct = By.xpath("//div[@class='tab-pane fade active in']");
    public OverViewPage(WebDriver driver){super(driver);}

    /*public void validateProduct(String name){
        //boolean isVisible = driver.findElement(By.xpath("//a[contains(text()," + name + ")]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text()," + name + ")]")).click();
    }*/
    public String getProductName() {
        return driver.findElement(itemProduct).getText();
    }
    public String getProductPrice() {
        return driver.findElement(priceProduct).getText();
    }
    public boolean getDescription(){return driver.findElement(descriptionProduct).isDisplayed();}
    public void selectValidateProductToCart(String product) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        Assert.assertEquals(getProductName(), product);
        driver.findElement(addToCart).click();
    }

   /* public void validatePrice(String price){
        String actualPrice = driver.findElement(By.id("totalm")).getText();
        Assert.assertEquals(actualPrice, price);
    }*/
    public void selectValidatePrice(String price){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        Assert.assertEquals(getProductPrice(), price);
        driver.findElement(addToCart).click();
    }

}
