import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LogInPage;
import pages.PasswordResetPage;
import pages.RegisterPage;

public class LogInPageTest extends BaseTest {

    private LogInPage logInPage;
    private RegisterPage registerPage;

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

    @BeforeAll
    static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void defaultBrowser() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void registerNewUser(String firstName, String lastName, String address, String city, String state,
                                String zipCode, String ssn, String phoneNumber, String userName, String password) {
        driver.navigate().to(baseUrl);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Register']")));
        logInPage.selectRegister();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Register']")));
        registerPage.registerNewUser(firstName, lastName, address, city, state, zipCode, ssn, phoneNumber, userName, password, password);
    }

    @Test
    public void recoverPassword(String firstName, String lastName, String address, String city, String state,
                                String zipCode, String ssn) {
        driver.navigate().to(baseUrl);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Register']")));
        PasswordResetPage resetPage = logInPage.selectForgotPassword();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Find My Login Info']")));
        resetPage.findLoginInfo(firstName, lastName, address, city, state, zipCode, ssn);

    }





}
