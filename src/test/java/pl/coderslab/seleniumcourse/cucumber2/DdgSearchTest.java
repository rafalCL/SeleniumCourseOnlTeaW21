package pl.coderslab.seleniumcourse.cucumber2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/ddgsearch.feature", plugin = {"pretty","html:out"})
public class DdgSearchTest {
}
