import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LogInPage;
import pages.OpenNewAccountPage;

import java.util.HashMap;
import java.util.Map;

public class OpenNewAccountTest extends BaseTest {

    @BeforeAll
    static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void defaultBrowser() {
        System.out.println("Default browser beforeall");
        driver.manage().window().maximize();
        String userName = "DanB";
        String password = "password987";
        driver.navigate().to(baseUrl);
        new LogInPage(driver).performLogin(userName, password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Open New Account']")));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void openCheckingAccount() throws InterruptedException {
        new HomePage(driver).clickAccountsOverview();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='accountTable']/tbody/tr/td/a")));
        String accountNumber = driver.findElement(By.xpath(String.format("//table[@id='accountTable']/tbody/tr[1]/td/a"))).getText();
        String accountType = "CHECKING";
        new HomePage(driver).clickOpenNewAccount();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type = 'submit']")));
        new OpenNewAccountPage(driver).openNewAccount(accountType, accountNumber);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id = 'newAccountId']")));
        WebElement openAccountResult = driver.findElement(By.xpath("//div[@id = 'rightPanel']/div/div/p"));
        Assertions.assertEquals("Congratulations, your account is now open.", openAccountResult.getText());

    }

    @Test
    void openSavingsAccount() throws InterruptedException {
        new HomePage(driver).clickAccountsOverview();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='accountTable']/tbody/tr/td/a")));
        String accountNumber = driver.findElement(By.xpath(String.format("//table[@id='accountTable']/tbody/tr[1]/td/a"))).getText();
        String accountType = "SAVINGS";
        new HomePage(driver).clickOpenNewAccount();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type = 'submit']")));
        new OpenNewAccountPage(driver).openNewAccount(accountType, accountNumber);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id = 'newAccountId']")));
        WebElement openAccountResult = driver.findElement(By.xpath("//div[@id = 'rightPanel']/div/div/p"));
        Assertions.assertEquals("Congratulations, your account is now open.", openAccountResult.getText());

    }
}
