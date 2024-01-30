import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SidePanel {
    private ElementsCollection availableLinksNames = $$(byClassName("oxd-main-menu-item"));

    public ElementsCollection getAvailableLinksNames() {
        return availableLinksNames;
    }

    private SelenideElement oneElement = $(By.className("oxd-main-menu-item--name"));

    private SelenideElement searchElement = $(byAttribute("placeholder", "Search"));

    private SelenideElement adminElement = $(".oxd-main-menu-item--name", 0);

    private SelenideElement pimElement = $(".oxd-main-menu-item--name", 1);

    private SelenideElement leaveElement = $(".oxd-main-menu-item--name", 2);
    private SelenideElement timeElement = $(".oxd-main-menu-item--name", 3);

    private SelenideElement recruitmentElement = $(".oxd-main-menu-item--name", 4);

    private SelenideElement myInfoElement = $(".oxd-main-menu-item--name", 5);

    private SelenideElement performanceElement = $(".oxd-main-menu-item--name", 6);
    private SelenideElement dashboardElement = $(".oxd-main-menu-item--name", 7);

    private SelenideElement directoryElement = $(".oxd-main-menu-item--name", 8);

    private SelenideElement maintenanceElement = $(".oxd-main-menu-item--name", 9);

    private SelenideElement claimElement = $(".oxd-main-menu-item--name", 10);

    private SelenideElement expandButton = $(By.cssSelector("[class=\"oxd-icon-button oxd-main-menu-button\"]"));

    private SelenideElement logoItem = $(byClassName("oxd-brand-banner"));

    public SelenideElement getLogoItem() {
        return logoItem;
    }

    public SelenideElement getAdminElement() {
        return adminElement;
    }

    public SelenideElement getPimElement() {
        return pimElement;
    }

    public SelenideElement getSearchElement() {
        return searchElement;
    }

    public SelenideElement getLeaveElement() {
        return leaveElement;
    }

    public SelenideElement getTimeElement() {
        return timeElement;
    }

    public SelenideElement getRecruitmentElement() {
        return recruitmentElement;
    }

    public SelenideElement getMyInfoElement() {
        return myInfoElement;
    }

    public SelenideElement getPerformanceElement() {
        return performanceElement;
    }

    public SelenideElement getDashboardElement() {
        return dashboardElement;
    }

    public SelenideElement getOneElement() {
        return oneElement;
    }

    public SelenideElement getDirectoryElement() {
        return directoryElement;
    }

    public SelenideElement getMaintenanceElement() {
        return maintenanceElement;
    }

    public SelenideElement getClaimElement() {
        return claimElement;
    }

    public SelenideElement getBuzzElement() {
        return buzzElement;
    }

    private SelenideElement buzzElement = $(".oxd-main-menu-item--name", 11);



public void checkAvailableLinksAmount(int expectedAmount) {
    availableLinksNames.shouldHave(size(expectedAmount));
}

    public void inputSearchRequest(String query){
        searchElement.shouldBe(Condition.visible, Duration.ofSeconds(10));
        searchElement.setValue(query);
    }

    public void clearSearch(){
        searchElement.shouldBe(Condition.visible, Duration.ofSeconds(10));
        searchElement.sendKeys(Keys.BACK_SPACE);
        searchElement.sendKeys(Keys.BACK_SPACE);
        searchElement.sendKeys(Keys.BACK_SPACE);
        searchElement.sendKeys(Keys.BACK_SPACE);
    }

public void checkTextofAvailableLinks(String partText) {
    for (SelenideElement element : availableLinksNames) {
        element.shouldHave(Condition.partialText(partText));


    }
}
    public void checkAllCorrectCollectionTexts(List<String> expected){
        availableLinksNames.shouldHave(textsInAnyOrder(expected));
    }
    public void checkAllCorrectCollectionTexts(){
        availableLinksNames.shouldHave(texts("Admin", "PIM", "Leave","Time",
                "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance",
                "Claim", "Buzz"));
    }


    public SelenideElement getExpandButton() {
        return expandButton;
    }
}
