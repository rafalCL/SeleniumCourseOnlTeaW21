package pl.coderslab.seleniumcourse;

// usage: Tools.sleep(2000);

public class Tools {
    public static void sleep(long sleepTimeInMs) {
        try {
            Thread.sleep(sleepTimeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
