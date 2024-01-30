import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class YoutubePage {


    private SelenideElement popupTextYoutube = $(byTagName("h1"));
    public SelenideElement getPopupText() {
        return popupTextYoutube;
    }
}

