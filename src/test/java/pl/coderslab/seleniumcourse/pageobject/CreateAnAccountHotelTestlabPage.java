package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pl.coderslab.seleniumcourse.Tools.assertDisplayedAndEnabled;
import static pl.coderslab.seleniumcourse.Tools.fillInput;

public class CreateAnAccountHotelTestlabPage {
    private WebDriver driver;

    public CreateAnAccountHotelTestlabPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptAccountCreationForUserDetails(UserDetailsDto userDetails) {
        WebElement customerFirstnameInput = driver.findElement(By.id("customer_firstname"));
        fillInput(customerFirstnameInput, userDetails.getFirstName());
        WebElement customerLastnameInput = driver.findElement(By.id("customer_lastname"));
        fillInput(customerLastnameInput, userDetails.getLastName());
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        fillInput(passwordInput, userDetails.getPassword());

        WebElement submitButton = driver.findElement(By.id("submitAccount"));
        submitButton.click();
    }
}
