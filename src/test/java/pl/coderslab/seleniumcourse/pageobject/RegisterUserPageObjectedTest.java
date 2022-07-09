package pl.coderslab.seleniumcourse.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.coderslab.seleniumcourse.Tools.generateRandomEmail;

public class RegisterUserPageObjectedTest {
    private WebDriver driver;
    private MainHotelTestlabPage mainPage;
    private LoginHotelTestlabPage loginPage;
    private CreateAnAccountHotelTestlabPage createAccountPage;
    private MyAccountHotelTestlabPage myAccountPage;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.mainPage = new MainHotelTestlabPage(driver);
        this.loginPage = new LoginHotelTestlabPage(driver);
        this.createAccountPage = new CreateAnAccountHotelTestlabPage(driver);
        this.myAccountPage = new MyAccountHotelTestlabPage(driver);
    }

    @Test
    public void shouldFillRegisterUserForm() {
        // given
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        // when
        mainPage.clickSignIn();
        loginPage.attemptAccountCreationForEmail(generateRandomEmail());
        UserDetailsDto userDetails = new UserDetailsDto()
                .setFirstName("ala")
                .setLastName("makota")
                .setPassword("supertajnehaslo");
        createAccountPage.attemptAccountCreationForUserDetails(userDetails);
        // then
        assertTrue(myAccountPage.isAccountCreationSuccessful());

//        assertDisplayedAndEnabled(emailInput);
//        assertDisplayedAndEnabled(createAnAccountButton);

//        assertDisplayedAndEnabled(customerFirstnameInput);
//        assertDisplayedAndEnabled(customerLastnameInput);
//        assertDisplayedAndEnabled(customerEmailInput);
//        assertDisplayedAndEnabled(passwordInput);
//        assertDisplayedAndEnabled(submitButton);
        //driver.quit();
    }
}
