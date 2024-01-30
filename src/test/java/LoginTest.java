import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends BaseTest {


    @Test @Category(Smoke.class)
    public void successLogin() {


        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();


        dashboardPage.getHeader().shouldBe(visible).shouldHave(text("Dashboard"));

        //$(byTagName("h6")).shouldBe(Condition.visible).shouldHave(text());


        //$(byText("Dashboard"));
    }

    //@Test
    public void loginWithInvalidPassword() {


        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin");
        loginPage.clickOnLoginButton();
        loginPage.getErrorString().shouldBe(visible);

        loginPage.getErrorStringText().contains("Invalid credentials");


    }

   // @Test
    public void invalidUsername() {

        loginPage.enterUsername("sdfdsf");
        loginPage.enterPassword("dfghasgdhs");
        loginPage.clickOnLoginButton();
        loginPage.getErrorString().shouldBe(visible);
        loginPage.getErrorStringText().contains("Invalid credentials");
    }

   // @Test
    public void elementsAreDisplayed() {

        loginPage.getFirstLogo().shouldBe(visible);
        loginPage.firstLogoImageIsCorrect();

        loginPage.getDemoCredentials().shouldBe(visible);
        loginPage.getLinkedinIcon().shouldBe(visible);
        loginPage.getFacebookIcon().shouldBe(visible);
        loginPage.getTwitterIcon().shouldBe(visible);
        loginPage.getYoutubeIcon().shouldBe(visible);

    }

    // @Test
    public void allLinksAreCorrect() {

        loginPage.clickOnLinkedInIcon();

        switchTo().window(1);
        linkedInPage.getPopupText().shouldHave(text("LinkedIn"));
        WebDriverRunner.closeWindow();

        switchTo().window(0);
        loginPage.clickOnFacebookIcon();


        switchTo().window(1);
        facebookPage.getPopupText().shouldHave(text("Facebook"));
        WebDriverRunner.closeWindow();

        switchTo().window(0);
        loginPage.clickOnTwitterIcon();

        switchTo().window(1);
        twitterPage.getElementText().shouldHave(text("Follow"));
        WebDriverRunner.closeWindow();

        switchTo().window(0);
        loginPage.clickOnYoutubeIcon();

        switchTo().window(1);
        youtubePage.getPopupText().shouldHave(text("Google"));
        WebDriverRunner.closeWindow();
    }

    //@Test
    public void linkedInLinkIsCorrect() {


        loginPage.clickOnLinkedInIcon();

        switchTo().window(1);
        linkedInPage.getPopupText().shouldHave(text("LinkedIn"));


    }

    //@Test
    public void FacebookLinkIsCorrect() {

        loginPage.clickOnFacebookIcon();


        switchTo().window(1);
        facebookPage.getPopupText().shouldHave(text("Facebook"));


    }

    //@Test
    public void TwitterLinkIsCorrect() {


        loginPage.clickOnTwitterIcon();

        switchTo().window(1);
        twitterPage.getElementText().shouldHave(text("Follow"));


    }

    //@Test
    public void YoutubeLinkIsCorrect() {


        loginPage.clickOnYoutubeIcon();

        switchTo().window(1);


        youtubePage.getPopupText().shouldHave(text("YouTube"));


    }

    //@Test
    public void resetPasswordPage() {

        loginPage.clickOnForgotPasswordLink();

        resetPasswordPage.getUsernameInputField().shouldBe(visible);
        resetPasswordPage.getCancelButton().shouldBe(visible);
        resetPasswordPage.getResetButton().shouldBe(visible);


    }

    //@Test
    public void resetLinkSending() {

        loginPage.clickOnForgotPasswordLink();

        resetPasswordPage.getUsernameInputField().setValue("Admin");
        resetPasswordPage.clickOnResetButton();


        sendPasswordResetPage.getConfirmationText().shouldHave(text("Reset Password link sent successfully"));

    }

    //@Test
    public void resetPasswordWithoutUsername() {

        loginPage.clickOnForgotPasswordLink();


        resetPasswordPage.clickOnResetButton();


        resetPasswordPage.getErrorMessage().shouldHave(text("Required"));

    }
}
