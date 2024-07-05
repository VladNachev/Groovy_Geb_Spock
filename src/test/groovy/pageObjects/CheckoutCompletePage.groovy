package pageObjects

import geb.Page

class CheckoutCompletePage extends Page{
    static url = "https://www.saucedemo.com/checkout-complete.html"
    static at = {
        getTitle() == "Swag Labs"
        appLogo.isDisplayed()
    }

    static content = {
        appLogo(wait: true)             { $(".app_logo") }
        completeHeader(wait: true)      { $("h2[data-test='complete-header']") }
        completeText(wait: true)        { $("div[data-test='complete-text']") }
    }

    String getHeaderText() {
        return completeHeader.text()
    }

    String getBodyText() {
        return completeText.text()
    }

}
