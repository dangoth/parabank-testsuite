package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {

    @FindBy(id = "firstName")
    private WebElement textbox_firstName;

    @FindBy(id = "lastName")
    private WebElement textbox_lastName;

    @FindBy(id = "address.street")
    private WebElement textbox_address;

    @FindBy(id = "address.city")
    private WebElement textbox_city;

    @FindBy(id = "address.state")
    private WebElement textbox_state;

    @FindBy(id = "address.zipCode")
    private WebElement textbox_zipCode;

    @FindBy(id = "ssn")
    private WebElement textbox_ssn;

    @FindBy(xpath = "//input[@value='Find My Login Info']")
    private WebElement button_validate;

    public PasswordResetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void findLoginInfo(String firstname, String lastname, String address, String city,
                              String state, String zipcode, String ssn) {
        textbox_firstName.sendKeys(firstname);
        textbox_lastName.sendKeys(lastname);
        textbox_address.sendKeys(address);
        textbox_city.sendKeys(city);
        textbox_state.sendKeys(state);
        textbox_zipCode.sendKeys(zipcode);
        textbox_ssn.sendKeys(ssn);
        button_validate.click();

    }

}
