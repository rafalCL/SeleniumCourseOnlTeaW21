package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pl.coderslab.seleniumcourse.Tools.fillInput;

public class CreateAnAccountHotelTestlabPage {
    private WebDriver driver;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    public CreateAnAccountHotelTestlabPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void attemptAccountCreationForUserDetails(UserDetailsDto userDetails) {
        fillInput(customerFirstnameInput, userDetails.getFirstName());
        fillInput(customerLastnameInput, userDetails.getLastName());
        fillInput(passwordInput, userDetails.getPassword());

        submitButton.click();
    }

    public boolean areMandatoryInputsInteractable() {
        boolean isFirstNameInputInteractable = customerFirstnameInput.isDisplayed() && customerFirstnameInput.isEnabled();
        boolean isLastNameInputInteractable = customerLastnameInput.isDisplayed() && customerLastnameInput.isEnabled();
        boolean isPasswordInputInteractable = passwordInput.isDisplayed() && passwordInput.isEnabled();

        return isFirstNameInputInteractable
                && isLastNameInputInteractable
                && isPasswordInputInteractable;
    }

    public String getUserEmail() {
        return emailInput.getAttribute("value");
    }
}
