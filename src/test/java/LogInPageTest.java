import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LogInPage;
import pages.PasswordResetPage;
import pages.RegisterPage;

public class LogInPageTest extends BaseTest {

    //todo use ParameterizedTest and include login credentials in an external source

    @BeforeAll
    static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void defaultBrowser() {
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);
        System.out.println("Navigated to base url");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
        System.out.println("Wait done");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void registerNewUser() {
        String firstName = "Dan";
        String lastName = "Bough";
        String address = "23 Cincinatti Rd.";
        String city = "Fort Worth";
        String state = "TX";
        String zipCode = "02361";
        String phoneNumber = "08012362473";
        String ssn = "70906649";
        String userName = "DanB";
        String password = "password987";
        new LogInPage(driver).selectRegister();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Register']")));
        new RegisterPage(driver).registerNewUser(firstName, lastName, address, city, state, zipCode, ssn, phoneNumber, userName, password, password);
    }

    @Test
    public void recoverPassword() {
        String firstName = "Dan";
        String lastName = "Bough";
        String address = "23 Cincinatti Rd.";
        String city = "Fort Worth";
        String state = "TX";
        String zipCode = "02361";
        String ssn = "70906649";
        new LogInPage(driver).selectForgotPassword();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Find My Login Info']")));
        new PasswordResetPage(driver).findLoginInfo(firstName, lastName, address, city, state, zipCode, ssn);
    }

    @Test
    public void performLogin() {
        String userName = "DanB";
        String password = "password987";
        new LogInPage(driver).performLogin(userName, password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Log Out']")));
    }

}
