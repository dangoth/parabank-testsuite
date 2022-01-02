package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'amount']")
    private WebElement textbox_amount;

    @FindBy(css = "select#fromAccountId")
    private WebElement select_fromAccount;

    @FindBy(css = "select#toAccountId")
    private WebElement select_toAccount;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement button_transfer;

    private Select select;

    public TransferFundsPage() {
        PageFactory.initElements(driver, this);
    }

    public void transferFunds(String amount, String fromAccount, String toAccount) {
        textbox_amount.sendKeys(amount);
        select = new Select(select_fromAccount);
        select.selectByVisibleText(fromAccount);
        select = new Select(select_toAccount);
        select.selectByVisibleText(toAccount);
        button_transfer.click();
    }

}
