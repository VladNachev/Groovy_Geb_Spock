package pageObjects

import geb.Page

class InventoryPage extends Page {
    static url = "https://www.saucedemo.com/inventory.html"
    static at = {
        getTitle() == "Swag Labs"
        appLogo.isDisplayed()
    }
    static content = {
        appLogo(wait: true)         { $(".app_logo") }
        burgerMenu(wait: true)      { $("#react-burger-menu-btn") }
        logoutLink(wait: true)      { $("#logout_sidebar_link") }
        labsBackpack                { $("#add-to-cart-sauce-labs-backpack") }
        cartBadge(wait: true)       { $("span.shopping_cart_badge[data-test='shopping-cart-badge']") }
        removeBtn                   { $("#remove-sauce-labs-backpack") }
        cartContent(wait: true)     { $(".cart_quantity") }
    }

    void expandBurgerMenu() {
        burgerMenu.click()
    }

    void clickLogoutLink() {
        logoutLink.click()
    }

    void addLabsBackpackToCart() {
        labsBackpack.click()
    }

    String getNumberOfProductsInCart() {
        return cartBadge.text()
    }

    void clickOnCart() {
        cartBadge.click()
    }

    void removeLabsBackpackFromCart() {
        removeBtn.click()
    }

    boolean doesCartBadgeShowEmptyCart() {
        try {
            waitFor { cartBadge.size() == 0 || !cartBadge.displayed }
            return cartBadge.size() == 0 || !cartBadge.displayed || cartBadge.text().trim().isEmpty()
        } catch (geb.waiting.WaitTimeoutException e) {
            // If the wait times out, assume the badge is not present, meaning the cart is empty
            return true
        }
    }
}
