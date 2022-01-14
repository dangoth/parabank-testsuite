import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BillPayPage;
import pages.HomePage;
import pages.LogInPage;

public class BillPayTest extends BaseTest {

    @BeforeAll
    static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void defaultBrowser() {
        driver.manage().window().maximize();
        String userName = "DanB";
        String password = "password987";
        driver.navigate().to(baseUrl);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
        new LogInPage(driver).performLogin(userName, password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Open New Account']")));
        new HomePage(driver).clickBillPay();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type = 'submit']")));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void setupBillPay() throws InterruptedException {
        String name = "Joe";
        String address = "668 Long Drive";
        String city = "San Jose";
        String state = "CA";
        String zipCode = "82259";
        String phoneNumber = "19925782";
        String account = "232323";
        String amount = "100";
        new BillPayPage(driver).setupBillPay(name, address, city, state, zipCode, phoneNumber, account, amount);
        Thread.sleep(1000);
        WebElement billPaymentComplete = driver.findElement(By.xpath("//div[@ng-show = 'showResult']/h1"));
        Assertions.assertEquals("Bill Payment Complete", billPaymentComplete.getText());
    }

}
