import pageObjects.InventoryPage
import geb.spock.GebReportingSpec
import spock.lang.Issue
import pageObjects.SwagLabsHomePage

class CartSpec extends GebReportingSpec {

    @Issue("Test adding and removing product from the cart")
    void addAndRemoveProduct() {
            when: "We navigate to the QAware homepage"
                to SwagLabsHomePage
            then: "We are on Swag Labs home page"
                SwagLabsHomePage homePage = at SwagLabsHomePage
            when: "Type in login credentials and login"
                String userName = "standard_user"
                String password = "secret_sauce"
                login(userName, password, homePage)
            then: "We are forwarded to inventory page"
                InventoryPage inventoryPage = at InventoryPage
            when: "Add Labs Backpack to Cart"
                inventoryPage.addLabsBackpackToCart()
            then: "Cart displays that has 1 product inside"
                assert inventoryPage.getNumberOfProductsInCart() == "1"
            when: "Click on cart"
                inventoryPage.clickOnCart()
            and: "Remove the product from cart"
                inventoryPage.removeLabsBackpackFromCart()
            then: "sadasdas"
                verifyAll(inventoryPage) {
                    getNumberOfProductsInCart() == ""
                    !isCardContentDisplayed()
                }
    }

    private void login(String userName, String password, SwagLabsHomePage homePage) {
        homePage.enterUsername(userName)
        homePage.enterPassword(password)
        homePage.clickLoginButton()
    }

}
