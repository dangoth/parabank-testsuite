package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillPayPage extends BasePage {

    @FindBy(xpath = "//input[@ng-model='payee.name']")
    private WebElement textbox_payeeName;

    @FindBy(xpath = "//input[@ng-model='payee.address.street']")
    private WebElement textbox_payeeAddress;

    @FindBy(xpath = "//input[@ng-model='payee.address.city']")
    private WebElement textbox_payeeCity;

    @FindBy(xpath = "//input[@ng-model='payee.address.state']")
    private WebElement textbox_payeeState;

    @FindBy(xpath = "//input[@ng-model='payee.address.zipCode']")
    private WebElement textbox_payeeZipCode;

    @FindBy(xpath = "//input[@ng-model='payee.phoneNumber']")
    private WebElement textbox_payeePhoneNumber;

    @FindBy(xpath = "//input[@ng-model='payee.accountNumber']")
    private WebElement textbox_payeeAccountNumber;

    @FindBy(xpath = "//input[@ng-model='verifyAccount']")
    private WebElement textbox_payeeAccountNumberRepeat;

    @FindBy(xpath = "//input[@ng-model='amount']")
    private WebElement textbox_amount;

    @FindBy(xpath = "//input[@value = 'Send Payment']")
    private WebElement button_sendPayment;

    public BillPayPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setupBillPay(String name, String address, String city, String state, String zipCode,
                             String phoneNumber, String account, String amount) {
        textbox_payeeName.sendKeys(name);
        textbox_payeeAddress.sendKeys(address);
        textbox_payeeCity.sendKeys(city);
        textbox_payeeState.sendKeys(state);
        textbox_payeeZipCode.sendKeys(zipCode);
        textbox_payeePhoneNumber.sendKeys(phoneNumber);
        textbox_payeeAccountNumber.sendKeys(account);
        textbox_payeeAccountNumberRepeat.sendKeys(account);
        textbox_amount.sendKeys(amount);
        button_sendPayment.click();
    }


}
