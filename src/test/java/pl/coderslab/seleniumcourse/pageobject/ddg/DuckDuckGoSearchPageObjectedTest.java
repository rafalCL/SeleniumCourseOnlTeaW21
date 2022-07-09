package pl.coderslab.seleniumcourse.pageobject.ddg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoSearchPageObjectedTest {
    private WebDriver driver;
    private MainDdgPage mainDdgPage;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.mainDdgPage = new MainDdgPage(driver);
    }

    @Test
    public void shouldSearchWPustyniWithDDG() {
        // given
        driver.get("https://duckduckgo.com/");
        // when
        mainDdgPage.searchPhrase("W pustyni i w puszczy");
        // then
        // assert
        //driver.quit();
    }

    @Test
    public void shouldSearchBobkowskiWithDDG() {
        driver.get("https://duckduckgo.com/");
        mainDdgPage.searchPhrase("Szkice piórkiem Andrzej Bobkowski");
        // assert
        //driver.quit();
    }
}
