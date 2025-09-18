package ui.tests;

import org.junit.jupiter.api.Test;
import ui.pages.LoginPage;
import ui.pages.ProductsPage;

public class ProductTests extends TestBase {

    @Test
    void addProductBasket() {
        new LoginPage()
                .login("standard_user","secret_sauce");
        new ProductsPage()
                .clickAddToCart()
                .checkBasket("1");
    }

    @Test
    void removeProductBasket() {
        new LoginPage()
                .login("standard_user","secret_sauce");
        new ProductsPage()
                .clickAddToCart()
                .clickBasket()
                .clickRemoveProduct()
                .checkBasketEmpty();
    }
}
