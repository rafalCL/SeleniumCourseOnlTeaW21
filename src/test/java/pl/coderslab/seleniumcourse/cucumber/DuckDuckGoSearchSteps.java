package pl.coderslab.seleniumcourse.cucumber;

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

public class DuckDuckGoSearchSteps {
    private WebDriver driver;

    @Given("^Browser with open page at address (.*)$")
    public void browserNavigate(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(url);
    }

    @When("^Entered (.*) in the search input box$")
    public void fillSearchInputBox(String searchPhrase) {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(searchPhrase);
    }

    @And("Search button \\(magnifying glass\\) clicked")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();
    }

    @Then("^First (.*) search results contain phrase: (.*)$")
    public void firstResultsContainPhrase(int count, String expectedPhrase) {
        List<WebElement> results = driver.findElements(By.cssSelector(".nrn-react-div"));
        for (int i = 0; i < results.size() && i < count; i++) {
            WebElement currentResultElement = results.get(i);
            WebElement currentResultHeader = currentResultElement.findElement(By.cssSelector("h2"));
            if (!currentResultHeader.getText().contains(expectedPhrase)) {
                fail(String.format("Phrase %s NOT found in search result: %s",
                        expectedPhrase, currentResultHeader.getText()));
            }
        }
    }
}
