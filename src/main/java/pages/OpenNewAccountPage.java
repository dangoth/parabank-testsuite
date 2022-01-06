package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage {

    @FindBy(css = "select#type")
    private WebElement select_AccountType;

    @FindBy(css = "select#fromAccountId")
    private WebElement select_ExistingAccount;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement button_openAccount;

    private Select select;

    public OpenNewAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openNewAccount(String accountType, String accountNumber) {
        select = new Select(select_AccountType);
        select.selectByVisibleText(accountType);
        select = new Select(select_ExistingAccount);
        select.selectByVisibleText(accountNumber);
        button_openAccount.click();
    }

}
