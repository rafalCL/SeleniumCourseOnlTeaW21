package pl.coderslab.seleniumcourse;

// usage: Tools.sleep(2000);

import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

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

    public static void assertDisplayedAndEnabled(WebElement element) {
        if(!element.isDisplayed() || !element.isEnabled()) {
            fail("email input NOT displayed or NOT enabled");
        }
    }

    public static String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString();
        return uuid + "@mail.pl";
    }
}
