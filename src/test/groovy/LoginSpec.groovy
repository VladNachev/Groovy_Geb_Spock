import pageObjects.InventoryPage
import spock.lang.Issue
import pageObjects.SwagLabsHomePage
import spock.lang.Unroll

class LoginSpec extends BaseSpec {

    @Issue("Test login with valid user and logout")
    void LogInAndLogOut() {
        when: "We navigate to the Swag Labs homepage"
            to SwagLabsHomePage
        then: "We are on Swag Labs home page"
            SwagLabsHomePage homePage = at SwagLabsHomePage
        when: "Type in login credentials and login"
            homePage.login(userName, password)
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
            to SwagLabsHomePage
        then: "We are on Swag Labs home page"
            SwagLabsHomePage homePage = at SwagLabsHomePage
        when: "Type in login credentials and login"
            homePage.login(testUserName, testPassword)
        then: "Proper message is displayed"
            assert homePage.getMessage().toString() == message
        where:
            description      | testUserName      | testPassword    | message
            "Locked user"    | "locked_out_user" | "secret_sauce"  | "Epic sadface: Sorry, this user has been locked out."
            "Username empty" | ""                | "secret_sauce"  | "Epic sadface: Username is required"
            "Password empty" | "standard_user"   | ""              | "Epic sadface: Password is required"
            "Wrong username" | "dummyUsername"   | "secret_sauce"  | "Epic sadface: Username and password do not match any user in this service"
            "Wrong password" | "standard_user"   | "dummyPassword" | "Epic sadface: Username and password do not match any user in this service"
    }
}