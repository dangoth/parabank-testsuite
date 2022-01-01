package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

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

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public OpenNewAccountPage clickOpenNewAccount() {
        link_openNewAccount.click();
        return new OpenNewAccountPage();
    }

    public AccountOverviewPage clickAccountsOverview() {
        link_accountsOverview.click();
        return new AccountOverviewPage();
    }

    public TransferFundsPage clickTransferFunds() {
        link_transferFunds.click();
        return new TransferFundsPage();
    }

    public RequestLoanPage clickRequestLoan() {
        link_requestLoan.click();
        return new RequestLoanPage();
    }

    public LogInPage clickLogout() {
        link_logOut.click();
        return new LogInPage(driver);
    }

}
