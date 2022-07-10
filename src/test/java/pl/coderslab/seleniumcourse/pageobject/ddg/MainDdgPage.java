package pl.coderslab.seleniumcourse.pageobject.ddg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainDdgPage {
    private WebDriver driver;

    public MainDdgPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchPhrase(String phraseToSearch) {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(phraseToSearch);
        searchInput.submit();
    }

    public void enterSearchPhraseToInputBox(String phraseToSearch) {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(phraseToSearch);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();
    }
}
