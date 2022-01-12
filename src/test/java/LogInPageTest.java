import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void registerNewUser() throws InterruptedException {
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
        Thread.sleep(1000);
        // first registration
        WebElement registrationResult = driver.findElement(By.xpath("//div[@id = 'rightPanel']/p"));
        Assertions.assertEquals("Your account was created successfully. You are now logged in.", registrationResult.getText());

        /* after registering successfully
        WebElement registerMessage = driver.findElement(By.id("customer.username.errors"));
        Assertions.assertEquals("This username already exists.", registerMessage.getText());
         */
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
        WebElement resetResult = driver.findElement(By.className("error"));
        Assertions.assertEquals("The customer information provided could not be found.", resetResult.getText());
    }

    @Test
    public void performLogin() {
        String userName = "DanB";
        String password = "password987";
        new LogInPage(driver).performLogin(userName, password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Log Out']")));
    }

}
