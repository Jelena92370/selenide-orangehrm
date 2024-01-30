import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static net.bytebuddy.description.annotation.AnnotationList.Empty.asList;

public class SidePanelTest extends BaseTest{


    @Test
    public void allLinksAreDisplayed() {


        loginPage.successLogin("Admin", "admin123");
        sidePanel.getAdminElement().shouldHave(text("Admin"));
        sidePanel.getPimElement().shouldHave(text("PIM"));
        sidePanel.getLeaveElement().shouldHave(text("Leave"));
        sidePanel.getTimeElement().shouldHave(text("Time"));
        sidePanel.getRecruitmentElement().shouldHave(text("Recruitment"));
        sidePanel.getMyInfoElement().shouldHave(text("My Info"));

        sidePanel.getPerformanceElement().shouldHave(text("Performance"));
        sidePanel.getDashboardElement().shouldHave(text("Dashboard"));
        sidePanel.getDirectoryElement().shouldHave(text("Directory"));
        sidePanel.getMaintenanceElement().shouldHave(text("Maintenance"));
        sidePanel.getClaimElement().shouldHave(text("Claim"));
        sidePanel.getBuzzElement().shouldHave(text("Buzz"));


    }

    @Test @Category(Smoke.class)
    public void searchExactLink() {
        String query = "Leave";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
        sidePanel.getOneElement().shouldBe(visible);
        sidePanel.getAvailableLinksNames().get(0).shouldHave(exactText(query));

        sidePanel.checkAvailableLinksAmount(1);    }


    @Test
    public void searchByPartText() {
        String query = "D";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
                sidePanel.checkAvailableLinksAmount(3);
                sidePanel.checkTextofAvailableLinks(query);
    }
    @Test
public void searchOfInvalidNameLink() {
    String query = "DRYGFEHRTUSQ";
    loginPage.successLogin("Admin", "admin123");
    sidePanel.inputSearchRequest(query);
    sidePanel.checkAvailableLinksAmount(0);

}

    @Test
    public void searchInputAndDelete() {
        String query = "Time";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
        sidePanel.checkAvailableLinksAmount(1);
        sidePanel.getAvailableLinksNames().get(0).shouldHave(exactText(query));
        sidePanel.clearSearch();
        sidePanel.checkAvailableLinksAmount(12);

    }

    @Test
    public void checkExpandCollapseSidePanel() {
        //List<String> expectedTextLinks = new ArrayList<>(asList("Admin","PIM",  "Leave","Time",
               // "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance",
                //"Claim", "Buzz"));//

        loginPage.successLogin("Admin", "admin123");
        sidePanel.getExpandButton().click();
        sidePanel.getLogoItem().shouldHave(cssClass("toggled"));
        sidePanel.checkAvailableLinksAmount(12);
        sidePanel.checkAllCorrectCollectionTexts();

        sidePanel.getExpandButton().click();
        sidePanel.getLogoItem().shouldNotHave(cssClass("toggled"));
        sidePanel.checkAvailableLinksAmount(12);




    }
    }

