package Test_Case_Components;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import ui_framework.Customers_Subscriptions;
import ui_framework.Menus;

/**
 *
 * @author J. Drill
 */
public class tc_Cust_Subscriptions {
    WebDriver driver = null;
    
    String expectedTitle = "Subscriptions";
    
    public tc_Cust_Subscriptions(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void nav_Cust_Subscriptions() {
        // Goto Accounts
        Menus menu = new Menus(driver);
        Customers_Subscriptions subscriptions = menu.Nav_Customers_Subscriptions();
        // Valiate
        assertEquals(expectedTitle, subscriptions.Get_Page_Title());
    }
}
