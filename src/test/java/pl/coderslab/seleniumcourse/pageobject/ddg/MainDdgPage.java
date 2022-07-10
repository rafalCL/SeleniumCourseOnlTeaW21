package pl.coderslab.seleniumcourse.pageobject.ddg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainDdgPage {
    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    public MainDdgPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchPhrase(String phraseToSearch) {
        searchInput.sendKeys(phraseToSearch);
        searchInput.submit();
    }

    public void enterSearchPhraseToInputBox(String phraseToSearch) {
        searchInput.sendKeys(phraseToSearch);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
