import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ResetPasswordPage {


        private SelenideElement usernameInputField = $(byName("username"));

    private SelenideElement cancelButton = $(byClassName("orangehrm-forgot-password-button--cancel"));
    private SelenideElement resetButton = $(byClassName("orangehrm-forgot-password-button--reset"));

    private SelenideElement errorMessage = $(byClassName("oxd-input-group__message"));


    public SelenideElement getUsernameInputField() {
        return usernameInputField;
    }

        public SelenideElement getErrorMessage() {
            return errorMessage;

    }
    public SelenideElement getCancelButton() {
        return cancelButton;

    }

    public SelenideElement getResetButton() {
        return resetButton;

    }

    public void clickOnResetButton() {
        resetButton.click();

    }
}

