package Test_Case_Components;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import ui_framework.Customers_Transactions;
import ui_framework.Menus;

/**
 *
 * @author J. Drill
 */
public class tc_Cust_Transactions {
    WebDriver driver = null;
    
    String expectedTitle = "Transactions";
    
    public tc_Cust_Transactions(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void nav_Cust_Invoices() {
        // Goto Invoices
        Menus menu = new Menus(driver);
        Customers_Transactions transactions = menu.Nav_Customers_Transactions();
        // Valiate
        assertEquals(expectedTitle, transactions.Get_Page_Title());
    }
}
