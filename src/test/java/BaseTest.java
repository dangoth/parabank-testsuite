import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    protected String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

}
