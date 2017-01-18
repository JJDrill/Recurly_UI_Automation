package Test_Case_Sets;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Test_Case_Components.*;
import org.openqa.selenium.WebDriver;
import ui_framework.Browser;

/**
 *
 * @author J. Drill
 */
public class ts_Customer_Accounts {
    
    public ts_Customer_Accounts() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void chrome_Verify_Cust_Accounts() {
        // Setup our browser and broswer properties
        Browser browser = new Browser();
        WebDriver driver = browser.Get_Driver(Browser.Browser_Type.CHROME);
        browser.Window_Maximize(driver);
        browser.Set_Implicit_Wait(driver, 10);
        browser.Set_Page_Timeout(driver, 10);
        
        // Load the page objects we're going to use
        tc_App_Access access = new tc_App_Access(driver);
        tc_Cust_Accounts accounts = new tc_Cust_Accounts(driver);
        tc_Cust_Subscriptions subscriptions = new tc_Cust_Subscriptions(driver);
        tc_Cust_Invoices invoices = new tc_Cust_Invoices(driver);
        tc_Cust_Transactions transactions = new tc_Cust_Transactions(driver);
        
        // Login
        access.login();
        // To accounts
        accounts.nav_Cust_Accounts();
        // Verify account totals on the page
        accounts.verify_Account_Totals();
        // Just for fun naviage to other pages under Customers
        subscriptions.nav_Cust_Subscriptions();
        invoices.nav_Cust_Invoices();
        transactions.nav_Cust_Invoices();
        access.logout();
        driver.close();
    }
    
}
