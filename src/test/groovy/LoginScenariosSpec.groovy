import PageObjects.InventoryPage
import geb.spock.GebReportingSpec
import spock.lang.Issue
import PageObjects.SwagLabsHomePage
import spock.lang.Unroll

class LoginScenariosSpec extends GebReportingSpec {

    @Issue("Test login with valid user")
    void LoginWithValidUser() {
        when: "We navigate to the QAware homepage"
            goToSwagLabsHomePage()
        then: "We are on Swag Labs home page"
            SwagLabsHomePage homePage = at SwagLabsHomePage
        when: "Type in login credentials and login"
            String userName = "standard_user"
            String password = "secret_sauce"
            login(userName, password, homePage)
        then: "We are forwarded to inventory page"
            InventoryPage inventoryPage = at InventoryPage
        when: "Expand burger menu"
            inventoryPage.expandBurgerMenu()
        and: "Click on the logout link"
            inventoryPage.clickLogoutLink()
        then: "We are forwarded to the home page"
            at SwagLabsHomePage
    }

    @Unroll("LoginWithDifferentUsers() - #description")
    @Issue("Different login scenarios")
    void LoginWithDifferentUsers() {
        when: "Go to Swag Labs home page"
            goToSwagLabsHomePage()
        then: "We are on Swag Labs home page"
            SwagLabsHomePage homePage = at SwagLabsHomePage
        when: "Type in login credentials and login"
            login(userName, password, homePage)
        then: "Proper message is displayed"
            assert homePage.getMessage().toString() == message
        where:
            description      | userName          | password        | message
            "Locked user"    | "locked_out_user" | "secret_sauce"  | "Epic sadface: Sorry, this user has been locked out."
            "Username empty" | ""                | "secret_sauce"  | "Epic sadface: Username is required"
            "Password empty" | "standard_user"   | ""              | "Epic sadface: Password is required"
            "Wrong username" | "dummyUsername"   | "secret_sauce"  | "Epic sadface: Username and password do not match any user in this service"
            "Wrong password" | "standard_user"   | "dummyPassword" | "Epic sadface: Username and password do not match any user in this service"
    }

    private void login(String userName, String password, SwagLabsHomePage homePage) {
        homePage.enterUsername(userName)
        homePage.enterPassword(password)
        homePage.clickLoginButton()
    }

    private void goToSwagLabsHomePage(){
        to SwagLabsHomePage
    }

}