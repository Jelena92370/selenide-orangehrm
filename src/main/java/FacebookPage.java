import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class FacebookPage {


        private SelenideElement popupText = $(byClassName("xg8j3zb"));
        public SelenideElement getPopupText() {
        return popupText;
    }
    }

