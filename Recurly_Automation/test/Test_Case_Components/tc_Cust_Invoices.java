package Test_Case_Components;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import ui_framework.Customers_Invoices;
import ui_framework.Menus;

/**
 *
 * @author J. Drill
 */
public class tc_Cust_Invoices {
    WebDriver driver = null;
    
    String expectedTitle = "Invoices";
    
    public tc_Cust_Invoices(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void nav_Cust_Invoices() {
        // Goto Invoices
        Menus menu = new Menus(driver);
        Customers_Invoices invoices = menu.Nav_Customers_Invoices();
        // Valiate
        assertEquals(expectedTitle, invoices.Get_Page_Title());
    }
}
