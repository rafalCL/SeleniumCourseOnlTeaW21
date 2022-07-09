package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pl.coderslab.seleniumcourse.Tools.fillInput;

public class CreateAnAccountHotelTestlabPage {
    private WebDriver driver;

    private By customerFirstnameLocator = By.id("customer_firstname");

    private By customerLastNameLocator = By.id("customer_lastname");

    private By customerPasswordLocator = By.id("passwd");

    private By submitButtonLocator = By.id("submitAccount");

    public CreateAnAccountHotelTestlabPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptAccountCreationForUserDetails(UserDetailsDto userDetails) {
        WebElement customerFirstnameInput = driver.findElement(customerFirstnameLocator);
        fillInput(customerFirstnameInput, userDetails.getFirstName());
        WebElement customerLastnameInput = driver.findElement(customerLastNameLocator);
        fillInput(customerLastnameInput, userDetails.getLastName());
        WebElement passwordInput = driver.findElement(customerPasswordLocator);
        fillInput(passwordInput, userDetails.getPassword());

        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }

    public boolean areMandatoryInputsInteractable() {
        WebElement customerFirstnameInput = driver.findElement(customerFirstnameLocator);
        WebElement customerLastnameInput = driver.findElement(customerLastNameLocator);
        WebElement passwordInput = driver.findElement(customerPasswordLocator);
        boolean isFirstNameInputInteractable = customerFirstnameInput.isDisplayed() && customerFirstnameInput.isEnabled();
        boolean isLastNameInputInteractable = customerLastnameInput.isDisplayed() && customerLastnameInput.isEnabled();
        boolean isPasswordInputInteractable = passwordInput.isDisplayed() && passwordInput.isEnabled();

        return isFirstNameInputInteractable
                && isLastNameInputInteractable
                && isPasswordInputInteractable;
    }

    public String getUserEmail() {
        WebElement emailInput = driver.findElement(By.id("email"));
        return emailInput.getAttribute("value");
    }
}
