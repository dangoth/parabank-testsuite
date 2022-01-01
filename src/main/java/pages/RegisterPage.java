package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    @FindBy(id = "customer.firstName")
    private WebElement textbox_firstName;

    @FindBy(id = "customer.lastName")
    private WebElement textbox_lastName;

    @FindBy(id = "customer.address.street")
    private WebElement textbox_address;

    @FindBy(id = "customer.address.city")
    private WebElement textbox_city;

    @FindBy(id = "customer.address.state")
    private WebElement textbox_state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement textbox_zipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement textbox_phoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement textbox_ssn;

    @FindBy(id = "customer.username")
    private WebElement textbox_userName;

    @FindBy(id = "customer.password")
    private WebElement textbox_password;

    @FindBy(id = "repeatedPassword")
    private WebElement textbox_repeatPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement button_register;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public void registerNewUser (String firstname, String lastname, String address, String city,
                                 String state, String zipcode, String phonenumber, String ssn,
                                 String username, String password, String repeatpassword) {
        textbox_firstName.sendKeys(firstname);
        textbox_lastName.sendKeys(lastname);
        textbox_address.sendKeys(address);
        textbox_city.sendKeys(city);
        textbox_state.sendKeys(state);
        textbox_zipCode.sendKeys(zipcode);
        textbox_phoneNumber.sendKeys(phonenumber);
        textbox_ssn.sendKeys(ssn);
        textbox_userName.sendKeys(username);
        textbox_password.sendKeys(password);
        textbox_repeatPassword.sendKeys(repeatpassword);
        button_register.click();
    }
}
