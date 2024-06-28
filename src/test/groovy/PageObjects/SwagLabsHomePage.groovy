package PageObjects

import geb.Page

class SwagLabsHomePage extends Page{
    static url = "https://www.saucedemo.com/"
    static at = {
        getTitle() == "Swag Labs"
        loginLogo.isDisplayed()
    }
    static content = {
        loginLogo(wait: true)       { $(".login_logo") }
        usernameInput               { $("#user-name")}
        passwordInput               { $("#password")}
        loginButton                 { $("#login-button")}
        errorMessage(wait: true)    { $("h3[data-test='error']") }

    }

    void enterUsername(String input) {
        usernameInput.value(input)
    }
    void enterPassword(String input) {
        passwordInput.value(input)
    }
    void clickLoginButton() {
        loginButton.click()
    }
    String getMessage() {
        return errorMessage.text()
    }

}
