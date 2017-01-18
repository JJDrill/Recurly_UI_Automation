package Test_Case_Components;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import ui_framework.*;

/**
 *
 * @author J. Drill
 */
public class tc_Cust_Accounts {
    WebDriver driver = null;
    
    String expectedTitle = "Accounts";
    
    public tc_Cust_Accounts(WebDriver driver) {
        this.driver = driver;
    }
    
    @Test
    public void nav_Cust_Accounts() {
        // Goto Accounts
        Menus menu = new Menus(driver);
        Customers_Accounts accounts = menu.Nav_Customers_Accounts();
        // Valiate
        assertEquals(expectedTitle, accounts.Get_Page_Title());
    }
    
    @Test
    public void verify_Account_Totals() {
        Customers_Accounts accounts = new Customers_Accounts(driver);
        // Get the account status total
        String totalAccounts = accounts.Get_Account_Status(Customers_Accounts.Account_Status_Types.All);
        // Count up all the listed accounts, including any 'next' pages
        String tableCount = String.valueOf(accounts.Get_Accts_Table_Size());
        // Validate
        assertEquals(totalAccounts, tableCount);
    }
    
    @Test
    public void verify_Account_Status_Calculations(){
        Customers_Accounts accounts = new Customers_Accounts(driver);
        
        // Verify all sums under Account Status
        int runningSum = 0;
        runningSum += Integer.parseInt(accounts.Get_Account_Status(Customers_Accounts.Account_Status_Types.Open));
        runningSum += Integer.parseInt(accounts.Get_Account_Status(Customers_Accounts.Account_Status_Types.Closed));
        // Get the total on the page
        int totalAcctSum = Integer.parseInt(accounts.Get_Account_Status(Customers_Accounts.Account_Status_Types.All));
        assertEquals(runningSum, totalAcctSum);
    }
    
    @Test
    public void verify_Subscription_Status_Calculations(){
        Customers_Accounts accounts = new Customers_Accounts(driver);
        
        // Verify all sums under Suubscription Status
        int runningSum = 0;
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.Active));
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.Renewing));
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.Non_Renewing));
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.Future_State_Date));
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.In_Trial));
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.Past_Due));
        runningSum += Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.No_Subscription));
        // Get the total on the page
        int totalSubSum = Integer.parseInt(accounts.Get_Subscription_Status(Customers_Accounts.Subscription_Status_Types.All));
        assertEquals(runningSum, totalSubSum);
    }
}
