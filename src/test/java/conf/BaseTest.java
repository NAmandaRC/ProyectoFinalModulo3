package conf;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    private String url = "https://www.demoblaze.com/";
    private String browser = "chrome";
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public static void setupSuite() throws Exception {
        ReportManager.init("Reports", "PurchaseSuite");
    }
    @BeforeMethod
    public void setup(ITestResult iTestResult) throws Exception{

        ReportManager.getInstance().startTest(iTestResult.getMethod().getDescription());
        switch (browser){
            case "chrome":
                 System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                 driver = new ChromeDriver();
                 break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception(browser + " no soportado");

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(url);
        log.info("navigate to {}", url);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Navigate to login page");
    }
   @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failes");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test paso XD");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test Skiped");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incompleto");
            }


            if (iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "failuer image");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(5000);
            if (driver != null)
                driver.quit();
            log.info("closing the driver");

        }
        
    }


    @AfterSuite
    public static void tearDownSuite() {
        ReportManager.getInstance().flush();
    }
}
