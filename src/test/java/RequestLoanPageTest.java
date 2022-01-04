import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountOverviewPage;
import pages.HomePage;
import pages.LogInPage;
import pages.RequestLoanPage;

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
        new LogInPage(driver).performLogin(userName, password);
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

    }

}
