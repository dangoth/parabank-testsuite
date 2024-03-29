import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LogInPage;
import pages.RequestLoanPage;
import pages.RequestLoanResultsPage;

public class RequestLoanPageTest extends BaseTest {

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
        new LogInPage(driver).performLogin(userName, password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Request Loan']")));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void request10000LoanWith1000DownPayment() throws InterruptedException {
        String amount = "10000";
        String downPayment = "1000";
        new HomePage(driver).clickRequestLoan();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Apply Now']")));
        new RequestLoanPage(driver).requestLoan(amount, downPayment);
        Thread.sleep(1000);
        Assertions.assertEquals("Wealth Securities Dynamic Loans (WSDL)", new RequestLoanResultsPage(driver).getLoanProvider());
    }

}
