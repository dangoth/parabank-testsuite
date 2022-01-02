package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'amount']")
    private WebElement textbox_loanAmount;

    @FindBy(xpath = "//input[@id = 'downPayment']")
    private WebElement textbox_downPayment;

    @FindBy(css = "select#fromAccountId")
    private WebElement select_fromAccount;

    @FindBy(xpath = "//input[@value = 'Apply Now']")
    private WebElement button_apply;

    private Select select;

    public RequestLoanPage() {
        PageFactory.initElements(driver, this);
    }

    public void requestLoan(String amount, String downPayment, String account) {
        textbox_loanAmount.sendKeys(amount);
        textbox_downPayment.sendKeys(downPayment);
        select = new Select(select_fromAccount);
        select.selectByVisibleText(account);
        button_apply.click();
    }

}
