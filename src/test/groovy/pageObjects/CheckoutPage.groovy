package pageObjects

import geb.Page

class CheckoutPage extends Page {
    static url = "https://www.saucedemo.com/checkout-step-one.html"
    static at = {
        getTitle() == "Swag Labs"
        appLogo.isDisplayed()
    }

    static content = {
        appLogo(wait: true)             { $(".app_logo") }
        checkoutInformationTitle        { $(".title", text: 'Checkout: Your Information') }
        firstNameInput                  { $("#first-name") }
        lastNameInput                   { $("#last-name") }
        postCodeInput                   { $("#postal-code") }
        continueButton                  { $("#continue") }
        errorMsg(wait: true)            { $("h3[data-test='error']") }
    }

    boolean isCheckoutInformationTitleDisplayed() {
        return checkoutInformationTitle.displayed
    }

    void enterFirstName(String input) {
        firstNameInput.value(input)
    }

    void enterLastName(String input) {
        lastNameInput.value(input)
    }

    void enterPostalCode(String input) {
        postCodeInput.value(input)
    }

    void clickContinueButton() {
        continueButton.click()
    }

    String getErrorMessage() {
        return errorMsg.text()
    }
}
