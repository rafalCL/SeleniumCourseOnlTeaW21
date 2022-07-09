package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountHotelTestlabPage {
    private WebDriver driver;

    public MyAccountHotelTestlabPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountCreationSuccessful() {
        WebElement accountCreationSuccessPanel = driver.findElement(By.cssSelector("p.alert.alert-success"));
        if (accountCreationSuccessPanel == null) {
            return false;
        }
        return accountCreationSuccessPanel.getText().equals("Your account has been created.");
    }
}
