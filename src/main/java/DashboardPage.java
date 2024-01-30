import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement header = $(byTagName("h6"));

    public boolean headerIsDisplayed() {
        return header.isDisplayed();
    }

    public SelenideElement getHeader() {
        return header;
    }
}
