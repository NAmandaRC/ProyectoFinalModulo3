package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ClientForm extends BasePage{

    private final By clientName = By.id("name");
    private final By clientCountry = By.id("country");
    private final By clientCity = By.id("city");
    private final By clientCard = By.id("card");
    private final By clientMonth = By.id("month");
    private final By clientYear = By.id("year");

    private final By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");

    private final By closeButton = By.xpath("//button[contains(text(),'Close')]");


    public ClientForm(WebDriver driver) {
        super(driver);
    }

    public void enterName(String clientName) {
        driver.findElement(this.clientName).sendKeys(clientName);
    }
    public void enterCountry(String clientCountry) {
        driver.findElement(this.clientCountry).sendKeys(clientCountry);
    }
    public void enterCity(String clientCity) {
        driver.findElement(this.clientCity).sendKeys(clientCity);
    }
    public void enterCard(String clientCard) {
        driver.findElement(this.clientCard).sendKeys(clientCard);
    }
    public void enterMonth(String clientMonth) {
        driver.findElement(this.clientMonth).sendKeys(clientMonth);
    }
    public void enterYear(String clientYear) {
        driver.findElement(this.clientYear).sendKeys(clientYear);
    }
    public void ingressData(String clientName, String clientCountry, String clientCity, String clientCard, String clientMonth, String clientYear) throws IOException {
        enterName(clientName);
        enterCountry(clientCountry);
        enterCity(clientCity);
        enterCard(clientCard);
        enterMonth(clientMonth);
        enterYear(clientYear);
    }

    public void clickOnPurchase(){
        driver.findElement(purchaseButton).click();
    }
    public void clickClosePurchase(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        driver.findElement(closeButton).click();
    }



}
