import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class SendPasswordResetPage {

    private SelenideElement confirmationText = $(byTagName("h6"));

    public SelenideElement getConfirmationText() {
        return confirmationText;

    }
}
