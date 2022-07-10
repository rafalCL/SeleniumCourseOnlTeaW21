package pl.coderslab.seleniumcourse.pageobject.ddg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ResultsDdgPage {
    private WebDriver driver;

    public ResultsDdgPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getSearchResultsHeaders() {
        List<String> result = new ArrayList<>();
        List<WebElement> resultsHeaders = driver.findElements(By.cssSelector("div.nrn-react-div article h2"));
        for (int i = 0; i < resultsHeaders.size(); i++) {
            String headerText = resultsHeaders.get(i).getText();
            result.add(headerText);
        }

        return result;
    }
}
