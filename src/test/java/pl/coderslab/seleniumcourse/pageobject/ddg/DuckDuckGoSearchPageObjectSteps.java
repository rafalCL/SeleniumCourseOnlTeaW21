package pl.coderslab.seleniumcourse.pageobject.ddg;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class DuckDuckGoSearchPageObjectSteps {
    private WebDriver driver;
    private MainDdgPage mainDdgPage;
    private ResultsDdgPage resultsDdgPage;

    @Given("^2Browser with open page at address (.*)$")
    public void browserNavigate(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(url);
        this.mainDdgPage = new MainDdgPage(driver);
        this.resultsDdgPage = new ResultsDdgPage(driver);
    }

    @When("^2Entered (.*) in the search input box$")
    public void fillSearchInputBox(String searchPhrase) {
        mainDdgPage.enterSearchPhraseToInputBox(searchPhrase);
    }

    @And("2Search button \\(magnifying glass\\) clicked")
    public void clickSearchButton() {
        mainDdgPage.clickSearchButton();
    }

    @Then("^2First (.*) search results contain phrase: (.*)$")
    public void firstResultsContainPhrase(int count, String expectedPhrase) {
        List<String> headers = resultsDdgPage.getSearchResultsHeaders();

        for (int i = 0; i < headers.size() && i < count; i++) {
            String currentHeader = headers.get(i);
            if (!currentHeader.toLowerCase().contains(expectedPhrase.toLowerCase())) {
                fail(String.format("Phrase %s NOT found in search result: %s",
                        expectedPhrase, currentHeader));
            }
        }
    }
}
