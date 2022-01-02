package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class AccountOverviewPage extends BasePage {

    @FindBy(xpath = "//table[@id='accountTable']")
    private WebElement table_accounts;

    HashMap<Integer, String> accounts=  new HashMap<Integer, String>();
    // todo implement account to hashmap parsing, total checking


    public AccountOverviewPage() {
        PageFactory.initElements(driver, this);
    }

}
