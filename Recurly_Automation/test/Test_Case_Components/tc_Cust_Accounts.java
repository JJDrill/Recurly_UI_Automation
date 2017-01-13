package Test_Case_Components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    String accountsTitle = "Accounts";
    String accountsTagStringStart = "Displaying all ";
    String accountsTagStringEnd = " accounts";
    
    public tc_Cust_Accounts(WebDriver driver) {
        this.driver = driver;
    }
    
    @Test
    public void nav_Cust_Accounts() {
        // Goto Accounts
        Menus menu = new Menus(driver);
        Customers_Accounts accounts = menu.Nav_Customers_Accounts();
        // Valiate
        assertEquals(accountsTitle, accounts.Get_Page_Title());
    }
    
    @Test
    public void verify_Account_Totals() {
        Customers_Accounts accounts = new Customers_Accounts(driver);
        
        String totalAccounts =
                accounts.Get_Account_Status(Customers_Accounts.Account_Status_Types.All);
        
        String tableCount = String.valueOf(accounts.Get_Accts_Table_Size());
        
        assertEquals(totalAccounts, tableCount);
        
        assertEquals(accountsTagStringStart + totalAccounts + accountsTagStringEnd,
                accounts.Get_Accts_Table_Tag());
    }
}
