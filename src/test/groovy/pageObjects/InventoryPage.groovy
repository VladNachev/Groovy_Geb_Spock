package pageObjects

import geb.Page

class InventoryPage extends Page{
    static url = "https://www.saucedemo.com/inventory.html"
    static at = {
        getTitle() == "Swag Labs"
        appLogo.isDisplayed()
    }
    static content = {
        appLogo(wait: true)       { $(".app_logo") }
        burgerMenu(wait: true)    { $("#react-burger-menu-btn")}
        logoutLink(wait: true)    { $("#logout_sidebar_link")}
        labsBackpack              { $("#add-to-cart-sauce-labs-backpack")}
        cart(wait: true)          { $(".shopping_cart_badge")}
        removeBtn                 { $("#remove-sauce-labs-backpack")}
        cartContent(wait: true)   { $(".cart_quantity")}

        //$(".cart_quantity")
        //remove-sauce-labs-backpack
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
        return cart.text()
    }

    void clickOnCart() {
        cart.click()
    }
    void removeLabsBackpackFromCart() {
        removeBtn.click()
    }
    boolean isCardContentDisplayed() {
        return cartContent.isDisplayed()
    }
}
