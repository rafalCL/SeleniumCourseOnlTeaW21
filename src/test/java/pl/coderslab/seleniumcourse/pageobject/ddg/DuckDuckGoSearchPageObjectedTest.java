package pl.coderslab.seleniumcourse.pageobject.ddg;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoSearchPageObjectedTest {
    @Test
    public void shouldSearchWithDDG() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        MainDdgPage mainDdgPage = new MainDdgPage(driver);
        mainDdgPage.searchPhrase("W pustyni i w puszczy");
        //driver.quit();
    }
}
