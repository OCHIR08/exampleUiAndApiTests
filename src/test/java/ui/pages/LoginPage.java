package ui.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    // локаторы
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "[data-test='error']";

    // действия
    public LoginPage login(String username, String password) {
        open("/");
        $(usernameInput).setValue(username);
        $(passwordInput).setValue(password);
        $(loginButton).click();
        return new LoginPage();
    }

    // проверки
    public LoginPage checkErrorMessage(String expectedText) {
        $(errorMessage).shouldHave(text(expectedText));
        return this;
    }
}
