package PageObjects

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

    }

    void expandBurgerMenu() {
        burgerMenu.click()
    }

    void clickLogoutLink() {
        logoutLink.click()
    }
}
