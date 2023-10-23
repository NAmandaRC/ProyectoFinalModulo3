package purchase;

import com.aventstack.extentreports.Status;
import conf.BaseTest;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.models.Client;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PurchaseProductsTest extends BaseTest {
    public static String clienTestDataPath = "resources/testdata/clientInformation/";

    @Test(description = "validar el producto", dataProvider = "clientDataProvider")
    public void validateProduct(ClienteForm clientForm) throws InterruptedException, IOException{

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

        ReportManager.getInstance().getTest().log(Status.INFO, "Test data: " +clientForm.toString());
        ClienteForm clientFormData = new ClienteForm(driver);
        clientFormData.ingressData(clientForm.getName(), clientForm.getCountry(), clientForm.getCity(), clientForm.getCard(), clientForm.getMonth(), clientForm.getYear());
        clientFormData.clickOnPurchase();

    }


    @Test(description = "validar valor del carrito")
    public void validateValuecart() throws InterruptedException, IOException{

    }

    @Test(description = "validar resumen del producto")
    public void validaResume() throws InterruptedException, IOException{

    }

    @Test(description = "validar compra exitosa")
    public void validateSuccess() throws InterruptedException, IOException{

    }

    @DataProvider(name = "clientDataProvider")
    public Object[] clientDataProvider() throws FileNotFoundException{
        return JsonTestDataHelper.getInstance().geTestData(clienTestDataPath + "clientData.json", Client.class);
    }


}
