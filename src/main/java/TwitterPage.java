import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class TwitterPage {


    private SelenideElement twitterElement = $(By.xpath("//span[contains(text(),'Follow')]"));

    public SelenideElement getElementText() {

        return twitterElement;
}
}

