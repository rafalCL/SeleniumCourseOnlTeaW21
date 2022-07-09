package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isThereAnyHotelPresentInSearchResults(){
        WebElement hotels = driver.findElement(By.className("room_cont"));
        return hotels.isDisplayed();
    }

    public boolean isThereHotelWithNamePresentInSearchResults(String hotelName){
        List<WebElement> hotels = driver.findElements(By.className("rm_heading"));
        for (WebElement hotel: hotels){
            if (hotel.getText().equals(hotelName)) {
                return true;
            }
        }
        return false;
    }

    public String getNameOfHotelInResults(){
        List<WebElement> hotels = driver.findElements(By.className("rm_heading"));
        return hotels.get(0).getText();
    }
}
