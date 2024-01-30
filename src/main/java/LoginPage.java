import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement usernameInputField = $("[name='username']");
    private SelenideElement passwordInputField = $("[placeholder=\"Password\"]");

    private SelenideElement loginButton = $("[type='submit']");

    private SelenideElement errorString = $(byClassName("oxd-alert-content-text"));


    private SelenideElement firstLogo = $(byAttribute("alt", "company-branding"));


    private SelenideElement linkedinIcon = $x("//a[contains(@href,'linkedin')]");

    private SelenideElement facebookIcon = $x("//a[contains(@href,'facebook')]");

    private SelenideElement twitterIcon = $x("//a[contains(@href,'twitter')]");

    private SelenideElement forgotPasswordLink = $(byClassName("orangehrm-login-forgot-header"));

    public void clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public SelenideElement getFacebookIcon() {
        return facebookIcon;
    }



    public SelenideElement getTwitterIcon() {
        return twitterIcon;
    }

    public SelenideElement getYoutubeIcon() {
        return youtubeIcon;
    }

    private SelenideElement youtubeIcon = $x("//a[contains(@href,'youtube')]");
    public SelenideElement getLinkedinIcon() {
        return linkedinIcon;
    }

    public void clickOnLinkedInIcon() {
        linkedinIcon.click();
    }

    public void clickOnFacebookIcon() {
        facebookIcon.click();
    }

    public void clickOnTwitterIcon() {
        twitterIcon.click();
    }

    public void clickOnYoutubeIcon() {
        youtubeIcon.click();
    }

    private SelenideElement demoCredentials = $(byClassName("oxd-sheet"));

    public SelenideElement getDemoCredentials() {
        return demoCredentials;
    }

    public SelenideElement getErrorString() {
        return errorString;
    }

    public void enterUsername(String usernameValue){
        usernameInputField.shouldBe(visible, Duration.ofSeconds(5));
        usernameInputField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue){
        passwordInputField.setValue(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();

    }

    public String getErrorStringText() {
        return errorString.getText();
    }

    public SelenideElement getFirstLogo() {
        return firstLogo;
    }

    public void firstLogoImageIsCorrect() {
        firstLogo.shouldHave(Condition.attributeMatching("src", ".*ohrm_branding.png.*"));
    }

    public void successLogin(String usernameValue, String passwordValue) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickOnLoginButton();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getHeader().shouldBe(visible).shouldHave(text("Dashboard"));
    }


}
