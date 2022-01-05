import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class RequestLoanPageTest extends BaseTest {

    @BeforeAll
    static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void defaultBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String userName = "DanB";
        String password = "password987";
        driver.navigate().to(baseUrl);
        new LogInPage().performLogin(userName, password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Request Loan']")));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void requestNewLoan() {
        String amount = "10000";
        String downPayment = "1000";
        String account = "12345";
        new HomePage().clickRequestLoan();
        new RequestLoanPage().requestLoan(amount, downPayment, account);
        Assertions.assertEquals("Wealth Securities Dynamic Loans (WSDL)", new RequestLoanResultsPage().getLoanProvider());

    }

}
