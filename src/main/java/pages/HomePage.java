package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[text() = 'Open New Account']")
    private WebElement link_openNewAccount;

    @FindBy(xpath = "//a[text() = 'Accounts Overview']")
    private WebElement link_accountsOverview;

    @FindBy(xpath = "//a[text() = 'Transfer Funds']")
    private WebElement link_transferFunds;

    @FindBy(xpath = "//a[text() = 'Request Loan']")
    private WebElement link_requestLoan;

    @FindBy(xpath = "//a[text() = 'Log Out']")
    private WebElement link_logOut;

    @FindBy(xpath = "//a[text() = 'Bill Pay']")
    private WebElement link_billPay;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOpenNewAccount() {
        link_openNewAccount.click();
    }

    public void clickAccountsOverview() {
        link_accountsOverview.click();
    }

    public void clickTransferFunds() {
        link_transferFunds.click();
    }

    public void clickRequestLoan() {
        link_requestLoan.click();
    }

    public void clickLogout() {
        link_logOut.click();
    }

    public void clickBillPay() {
        link_billPay.click();
    }

}
