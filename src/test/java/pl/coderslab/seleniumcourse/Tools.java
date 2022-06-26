package pl.coderslab.seleniumcourse;

// usage: Tools.sleep(2000);

import org.openqa.selenium.WebElement;

public class Tools {
    public static void sleep(long sleepTimeInMs) {
        try {
            Thread.sleep(sleepTimeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillInput(WebElement input, String text) {
        input.clear();
        input.sendKeys(text);
    }
}
