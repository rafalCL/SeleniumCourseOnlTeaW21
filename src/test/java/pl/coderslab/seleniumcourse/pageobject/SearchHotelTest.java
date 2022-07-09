package pl.coderslab.seleniumcourse.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchHotelTest {

    private WebDriver driver;

    private SearchPage searchPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.searchPage = new SearchPage(driver);
    }

    @Test
    public void verifyHotelList(){
        driver.get("https://hotel-testlab.coderslab.pl/en/14-the-hotel-prime?date_from=2022-07-09&date_to=2022-07-10");
        assertTrue(searchPage.isThereAnyHotelPresentInSearchResults());
        assertTrue(searchPage.isThereHotelWithNamePresentInSearchResults("luxury Rooms"));
    }

}
