package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanResultsPage {

    @FindBy(xpath="//div[@id='rightPanel']/td[@id='loanStatus']")
    private WebElement loanStatus;

    //@FindBy(xpath="//div[@id='rightPanel']")
    @FindBy(xpath="//div[@id='rightPanel']//td[@id='loanProviderName']")
    private WebElement loanProvider;

    public RequestLoanResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLoanProvider() {
        return loanProvider.getText();
    }

    public String getLoanStatus() {
        return loanStatus.getText();
    }

}
