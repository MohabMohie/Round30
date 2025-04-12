package flatPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A8W3SchoolsTableTests extends TestCase {
    /**
     * Open Google Chrome
     * Navigate to [<a href="https://www.w3schools.com/html/html_tables.asp">w3schools/tables</a>]
     * Assert that the Country for the Company [Ernst Handel] is [Austria]
     * Close Google Chrome
     */
    @Test (description = "Given I am on the w3schools tables page, when I check the country for the company Ernst Handel, then I should see Austria")
    public void navigateToTablesAndCheckTheCountryForTheTargetCompanyName(){
        // Given I am on the w3schools tables page
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

        // TODO: When I check the country for the company Ernst Handel
        String country = bot.getText(By.xpath(""));

        // Then I should see Austria
        Assert.assertEquals(country, "Austria", "Expected country to be Austria, but was " + country);
    }

}
