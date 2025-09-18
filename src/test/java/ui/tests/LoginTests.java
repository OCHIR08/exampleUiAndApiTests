package ui.tests;

import org.junit.jupiter.api.Test;
import ui.pages.LoginPage;
import ui.pages.ProductsPage;

public class LoginTests extends TestBase{

    @Test
    void successfulLogin() {
        new LoginPage()
                .login("standard_user","secret_sauce");
        new ProductsPage()
                .checkPageOpened();
    }

    @Test
    void failedLogin() {
        new LoginPage()
                .login("locked_out_user", "secret_sauce")
                .checkErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }
}
