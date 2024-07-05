import pageObjects.CheckoutPage
import pageObjects.InventoryPage
import pageObjects.CheckoutStepTwoPage
import pageObjects.CheckoutCompletePage
import spock.lang.Issue
import spock.lang.Unroll

class OrderSpec extends BaceSpec{

    @Unroll("Scenarios for filling personal info - #description")
    @Issue(["Place and complete an order",
            "Place order but fail on personal info"])
    void placeOrderAndFillInIncorrectPersonalInfo() {
        when: "We navigate to the QAware homepage"
            navigateToHomepageAndLogin(userName, password)
        then: "We are forwarded to inventory page"
            InventoryPage inventoryPage = at InventoryPage
        when: "Add Labs Backpack to Cart"
            inventoryPage.addLabsBackpackToCart()
        and: "Click on cart"
            inventoryPage.clickOnCart()
        then: "We are forwarded to cart inventory content"
            inventoryPage.isCartInventoryDisplayed()
        when: "Click on Checkout button"
            inventoryPage.clickCheckoutButton()
        then: "We are forwarded to the Checkout Information page"
            CheckoutPage checkoutPage = at CheckoutPage
        and: "Checkout information title is displayed"
            assert checkoutPage.isCheckoutInformationTitleDisplayed()
        expect: "Fill in the information and verify the outcome"
            checkoutPage.enterFirstName(firstName)
            checkoutPage.enterLastName(lastName)
            checkoutPage.enterPostalCode(postalCode)
            checkoutPage.clickContinueButton()
            if (message) {
                assert checkoutPage.getErrorMessage() == message
                // if assert passes - skip the else block and continue with the test
            }
            else {
                // Filled information passes the checks
                CheckoutStepTwoPage checkoutStepTwoPage = at CheckoutStepTwoPage
                checkoutStepTwoPage.clickFinishButton()
                CheckoutCompletePage checkoutCompletePage = at CheckoutCompletePage
                verifyAll(checkoutCompletePage) {
                    getHeaderText() == "Thank you for your order!"
                    getBodyText() == "Your order has been dispatched, " +
                            "and will arrive just as fast as the pony can get there!"
                }
                return // Stop the test execution here for successful order scenario
            }
        when: "Empty the cart"
            // we need to empty the cart in order to iterate with the other scenario in where block
            inventoryPage.emptyTheCart()
        then:"Cart is empty"
            assert inventoryPage.doesCartBadgeShowEmptyCart()
        where:
            description       | firstName          | lastName          | postalCode            | message
            "Positive TC"     | randomFirstName()  | randomLastName()  | randomZip()           | ""
            "Firstname empty" | ""                 | randomLastName()  | randomZip()           | "Error: First Name is required"
            "Lastname empty"  | randomFirstName()  | ""                | randomZip()           | "Error: Last Name is required"
            "Zip code empty"  | randomFirstName()  | randomLastName()  | ""                    | "Error: Postal Code is required"
    }

    private String randomFirstName() {
        UUID.randomUUID().toString().substring(0, 8)
    }

    private String randomLastName() {
        UUID.randomUUID().toString().substring(0, 8)
    }

    private String randomZip() {
        (10000 + new Random().nextInt(90000)).toString()
    }
}
