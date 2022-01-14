package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage {

    @FindBy(xpath = "//input[@id = 'amount']")
    private WebElement textbox_loanAmount;

    @FindBy(xpath = "//input[@id = 'downPayment']")
    private WebElement textbox_downPayment;

    @FindBy(xpath = "//input[@value = 'Apply Now']")
    private WebElement button_apply;

    public RequestLoanPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void requestLoan(String amount, String downPayment) {
        textbox_loanAmount.sendKeys(amount);
        textbox_downPayment.sendKeys(downPayment);
        button_apply.click();
    }

}
