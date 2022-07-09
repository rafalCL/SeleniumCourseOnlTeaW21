package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainHotelTestlabPage {
    private WebDriver driver;

    public MainHotelTestlabPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInButton = driver.findElement(By.cssSelector("a.user_login.navigation-link"));
        signInButton.click();
    }
}
