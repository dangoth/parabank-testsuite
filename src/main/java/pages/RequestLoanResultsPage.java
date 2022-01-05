package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestLoanResultsPage extends BasePage {

    @FindBy(id="loanStatus")
    private WebElement loanStatus;

    @FindBy(id = "loanProviderName")
    private WebElement loanProvider;

    public String getLoanProvider() {
        return loanProvider.getText();
    }

    public String getLoanStatus() {
        return loanStatus.getText();
    }

}
