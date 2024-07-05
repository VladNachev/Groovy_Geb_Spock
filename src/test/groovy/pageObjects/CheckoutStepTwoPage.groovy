package pageObjects

import geb.Page

class CheckoutStepTwoPage extends Page{
    static url = "https://www.saucedemo.com/checkout-step-two.html"
    static at = {
        getTitle() == "Swag Labs"
        appLogo.isDisplayed()
    }

    static content = {
        appLogo(wait: true)             { $(".app_logo") }
        finishButton(wait: true)        { $("#finish") }
    }

    void clickFinishButton() {
        finishButton.click()
    }
}
