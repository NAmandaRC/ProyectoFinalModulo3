package purchase;

import com.aventstack.extentreports.Status;
import conf.BaseTest;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.models.Model;
import org.example.pages.ClientForm;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PurchaseProductsTest extends BaseTest {
    public static String clientTestDataPath = "resources/testdata/clientInformation/";

    @Test(description = "validar compra", dataProvider = "clientDataProvider")
    public void validateProduct(Model clientForm) throws InterruptedException, IOException{

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.selectCategory();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectValidateProduct();

        DescriptionProduct descriptionProduct = new DescriptionProduct(driver);
        descriptionProduct.addProductToCart();

        AlertPopUp alertPopUp = new AlertPopUp(driver);
        alertPopUp.closePopUp();

        CartPage cartPage = new CartPage(driver);
        cartPage.IngressCart();

        DetailCart detailCart = new DetailCart(driver);
        detailCart.clickPlaceOrder();

        ReportManager.getInstance().getTest().log(Status.INFO, "Test data: " + clientForm.toString());
        ClientForm clientFormData = new ClientForm(driver);
        clientFormData.ingressData(clientForm.getName(), clientForm.getCountry(), clientForm.getCity(), clientForm.getCard(), clientForm.getMonth(), clientForm.getYear());
        clientFormData.clickOnPurchase();


        ThankYou clickOK = new ThankYou(driver);
        Assert.assertTrue(clickOK.validatePurchase());
        Thread.sleep(5000);
        clickOK.clickOK();

    }
    @Test(description = "validate product")
    public void validateCategory() throws InterruptedException, IOException{
        String expectedProduct = "Sony vaio i5";

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.selectCategory();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectValidateProduct();

        OverViewPage overViewPage = new OverViewPage(driver);
        overViewPage.selectValidateProductToCart(expectedProduct);
    }

    @Test(description = "validate price")
    public void validatePrice() throws InterruptedException{
        String expectedPrice = "$790 *includes tax";

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.selectCategory();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectValidateProduct();

        OverViewPage overViewPage = new OverViewPage(driver);
        overViewPage.selectValidatePrice(expectedPrice);
    }

    @Test(description = "validate description")
    public void validateDescriptionProduct(){

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.selectCategory();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectValidateProduct();

        OverViewPage overViewPage = new OverViewPage(driver);
        Assert.assertTrue(overViewPage.getDescription());
    }

   @DataProvider(name = "clientDataProvider")
    public Object[] clientDataProvider() throws FileNotFoundException{
        return JsonTestDataHelper.getInstance().geTestData(clientTestDataPath + "formPurchase.json", Model.class);
    }


}
