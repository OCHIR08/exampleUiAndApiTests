package ui.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ProductsPage {

    private final String addToCart = "#add-to-cart-sauce-labs-backpack";
    private final String shoppingCartBadge = ".shopping_cart_badge";
    private final String basket = ".shopping_cart_container";
    private final String remove = "#remove-sauce-labs-backpack";

    public ProductsPage checkPageOpened() {
        String title = ".title"; // локальная переменная
        $(title).shouldHave(text("Products"));
        return this;
    }

    public ProductsPage clickAddToCart() {
        $(addToCart).click();
        return this;
    }

    public ProductsPage clickBasket() {
        $(basket).click();
        return this;
    }

    public ProductsPage clickRemoveProduct() {
        $(remove).click();
        return this;
    }

    public ProductsPage checkBasket(String expectedCount) {
        $(shoppingCartBadge).shouldHave(text(expectedCount));
        return this;
    }

    public ProductsPage checkBasketEmpty() {
        $(shoppingCartBadge).shouldNot(exist); // убрали двойной ";"
        return this;
    }
}
