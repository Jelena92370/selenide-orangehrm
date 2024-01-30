import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before

    public void setup() {
        open(BASE_URL);

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @After
    public void tearDown() {
        closeWebDriver();
        ;
    }

    LoginPage loginPage = new LoginPage();

    LinkedInPage linkedInPage = new LinkedInPage();

    FacebookPage facebookPage = new FacebookPage();
    TwitterPage twitterPage = new TwitterPage();

    YoutubePage youtubePage = new YoutubePage();

    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    SendPasswordResetPage sendPasswordResetPage = new SendPasswordResetPage();
    SidePanel sidePanel = new SidePanel();

    DashboardPage dashboardPage = new DashboardPage();
}
