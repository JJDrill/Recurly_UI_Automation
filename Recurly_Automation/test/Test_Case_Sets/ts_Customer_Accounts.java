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
        Browser browser = new Browser();
        WebDriver driver = browser.Get_Driver(Browser.Browser_Type.CHROME);
        browser.Window_Maximize(driver);
        browser.Set_Implicit_Wait(driver, 5);
        browser.Set_Page_Timeout(driver, 5);
        
        tc_App_Access access = new tc_App_Access(driver);
        tc_Cust_Accounts accounts = new tc_Cust_Accounts(driver);
        tc_Cust_Subscriptions subscriptions = new tc_Cust_Subscriptions(driver);
        tc_Cust_Invoices invoices = new tc_Cust_Invoices(driver);
        tc_Cust_Transactions transactions = new tc_Cust_Transactions(driver);
        
        access.login();
        accounts.nav_Cust_Accounts();
        accounts.verify_Account_Totals();
        subscriptions.nav_Cust_Subscriptions();
        invoices.nav_Cust_Invoices();
        transactions.nav_Cust_Invoices();
        access.logout();
        driver.close();
    }
}
