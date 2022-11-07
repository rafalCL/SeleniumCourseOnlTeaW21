package pl.coderslab.seleniumcourse.cucumber2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DdgSearchSteps {
    private WebDriver driver;

    @Given("Web page https:\\/\\/duckduckgo.com opened in browser")
    public void openDdgInBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://duckduckgo.com/");
    }

    @When("Search phrase 'W pustyni i w puszczy' entered in search input box")
    public void enterSearchPhrase() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("W pustyni i w puszczy");
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();
    }

    @Then("First 3 results contain phrase 'W pustyni i w puszczy'")
    public void searchResultsAreValid() {
        List<WebElement> elements = driver.findElements(By.cssSelector("div.nrn-react-div article div h2 a span"));
        for (int i = 0; i < 3; i++) {
            WebElement searchResultLink = elements.get(i);
            assertTrue(searchResultLink.getText().contains("W pustyni i w puszczy"));
        }
    }
}
