import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class LinkedInPage {
    private SelenideElement popupText = $(byClassName("contextual-sign-in-modal__join-now"));
    public SelenideElement getPopupText() {
        return popupText;
    }
}
