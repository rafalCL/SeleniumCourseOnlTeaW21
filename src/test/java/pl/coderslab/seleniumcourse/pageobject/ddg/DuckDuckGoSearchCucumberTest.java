package pl.coderslab.seleniumcourse.pageobject.ddg;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/duckduckgosearchpageobjectexample.feature", plugin = {"pretty","html:out"})
public class DuckDuckGoSearchCucumberTest {
}
