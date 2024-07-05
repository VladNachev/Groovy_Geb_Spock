import geb.spock.GebReportingSpec
import pageObjects.SwagLabsHomePage

class BaseSpec extends GebReportingSpec {
    static String userName = "standard_user"
    static String password = "secret_sauce"

    void navigateToHomepageAndLogin (String username, String password) {
        SwagLabsHomePage homePage = to(SwagLabsHomePage)
        at(SwagLabsHomePage)
        homePage.login(username, password)
    }
}
