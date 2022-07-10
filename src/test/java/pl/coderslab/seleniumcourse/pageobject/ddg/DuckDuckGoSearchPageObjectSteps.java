package pl.coderslab.seleniumcourse.pageobject.ddg;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
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
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
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

    @And("Save screenshot")
    public void saveScreenshot() throws IOException {
//Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//Copy the screenshot to desired location
//Path to the location to save screenshot
//(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "ddg-search-"+currentDateTime+".png"));
    }

    @And("Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
