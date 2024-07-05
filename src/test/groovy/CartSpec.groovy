import pageObjects.InventoryPage
import spock.lang.Issue

class CartSpec extends BaseSpec {
    String userName = "standard_user"
    String password = "secret_sauce"

    @Issue("Test adding and removing product from the cart")
    void addAndRemoveProduct() {
            when: "We navigate to the QAware homepage"
                navigateToHomepageAndLogin(userName, password)
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
            then: "Cart is empty"
                assert inventoryPage.doesCartBadgeShowEmptyCart()
    }
}
