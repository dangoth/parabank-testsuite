package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    @FindBy(name = "username")
    private WebElement textbox_userName;

    @FindBy(name = "password")
    private WebElement textbox_password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement button_login;

    @FindBy(xpath = "//a[text() = 'Register']")
    private WebElement link_register;

    @FindBy(xpath = "//a[text() = 'Forgot login info?']")
    private WebElement link_forgotPassword;

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage performLogin(String username, String password) {
        textbox_userName.sendKeys(username);
        textbox_password.sendKeys(password);
        button_login.click();
        return new HomePage();
    }

    public RegisterPage selectRegister() {
        link_register.click();
        return new RegisterPage();
    }

    public PasswordResetPage selectForgotPassword() {
        link_forgotPassword.click();
        return new PasswordResetPage();
    }




}
