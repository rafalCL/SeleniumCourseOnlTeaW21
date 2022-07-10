package pl.coderslab.seleniumcourse.pageobject.ddg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsDdgPage {
    @FindBy(css = "div.nrn-react-div article h2")
    private List<WebElement> resultsHeaders;

    public ResultsDdgPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getSearchResultsHeaders() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < resultsHeaders.size(); i++) {
            String headerText = resultsHeaders.get(i).getText();
            result.add(headerText);
        }

        return result;
    }
}
