package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    @FindBy(className = "room_cont")
    private List<WebElement> hotelContentList;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public boolean isThereAnyHotelPresentInSearchResults() {
//        WebElement hotels = driver.findElement(By.className("room_cont"));
//        return hotels.isDisplayed();
//    }
    public boolean isThereAnyHotelPresentInSearchResults(){
        return hotelContentList.size() > 0;
    }

//    public boolean isThereHotelWithNamePresentInSearchResults(String hotelName){
//        List<WebElement> hotels = driver.findElements(By.className("rm_heading"));
//        for (WebElement hotel: hotels){
//            if (hotel.getText().equals(hotelName)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isThereHotelWithNamePresentInHotelResults(String hotelName){
        for (WebElement hotel: hotelContentList){
            WebElement hotelNameField = hotel.findElement(By.className("rm_heading"));
            if (hotelNameField.getText().equals(hotelName)) {
                return true;
            }
        }
        return false;
    }

}
