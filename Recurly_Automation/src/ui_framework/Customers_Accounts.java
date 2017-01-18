package ui_framework;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author J. Drill
 */
public class Customers_Accounts extends Common_Page_Functions {
    
    public enum Account_Status_Types {
        All, Open, Closed;
    }
    
    public enum Subscription_Status_Types {
        All, Active, Renewing, Non_Renewing, Future_State_Date, In_Trial, Past_Due, No_Subscription;
    }
    
    // Page Objects - Status
    By Status_Acct_Header   = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div[1]");
    By Status_Acct_All      = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div[2]/a[1]/span[3]");
    By Status_Acct_Open     = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div[2]/a[2]/span[3]");
    By Status_Acct_Closed   = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div[2]/a[3]/span[3]");
    By Status_Sub_All = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[1]/span[3]");
    By Status_Sub_Active = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[2]/span[3]");
    By Status_Sub_Renewing = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[3]/span[3]");
    By Status_Sub_NonRenewing = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[4]/span[3]");
    By Status_Sub_FutureStartDate = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[5]/span[3]");
    By Status_Sub_InTrial = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[6]/span[3]");
    By Status_Sub_PastDue = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[7]/span[3]");
    By Status_Sub_NoSubscription = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[8]/span[3]");
    
    // Page Objects
    By Accts_Table = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/a");
    By Accts_Table_Displaying_Tag = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[2]/div/div[2]/div[1]");
    By Accts_Table_Next_Enabled = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/div/a[2]");
    
    // Constructor
    public Customers_Accounts(WebDriver driver){
        super(driver);
    }
    
    public String Get_Account_Status(Account_Status_Types status_type){
        
        switch(status_type){
            case All:
                return driver.findElement(Status_Acct_All).getText();
            case Open:
                return driver.findElement(Status_Acct_Open).getText();
            case Closed:
                return driver.findElement(Status_Acct_Closed).getText();
            default:
                return "Error: Property not found";
        }
    }
    
    public String Get_Subscription_Status(Subscription_Status_Types status_type){
        
        switch(status_type){
            case All:
                return driver.findElement(Status_Sub_All).getText();
            case Active:
                return driver.findElement(Status_Sub_Active).getText();
            case Renewing:
                return driver.findElement(Status_Sub_Renewing).getText();
            case Non_Renewing:
                return driver.findElement(Status_Sub_NonRenewing).getText();
            case Future_State_Date:
                return driver.findElement(Status_Sub_FutureStartDate).getText();
            case In_Trial:
                return driver.findElement(Status_Sub_InTrial).getText();
            case Past_Due:
                return driver.findElement(Status_Sub_PastDue).getText();
            case No_Subscription:
                return driver.findElement(Status_Sub_NoSubscription).getText();
            default:
                return "Error: Property not found";
        }
    }
    
    public int Get_Accts_Table_Size(){
        int numAccounts = 0;
        boolean areMorePages = true;
        
        // loop through each page in the results list
        do {
            numAccounts += driver.findElements(Accts_Table).size();
            WebElement nextLink = driver.findElement(Accts_Table_Next_Enabled);
            
            // if the 'Next' link is clickable we have a next page
            if (nextLink.getText().equals("Next")) {
                WebElement header = driver.findElement(Status_Acct_Header);
                
                /**
                 * Issue #1: The chat box at the bottom of the page is preventing
                 * the moveToElement from working, so will hit the end key to
                 * get to the bottom of the page.
                 */
                Actions builder = new Actions(driver);
                builder.moveToElement(header).click().perform();
                builder.sendKeys(Keys.END).perform();
                
                /**
                 * Should be using WebDriverWait wait here but that is not working
                 * since there are issues with the chat box at the bottom preventing
                 * Selenium from being able to click the link.
                 */
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customers_Accounts.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                WebElement elmtNextLink = driver.findElement(Accts_Table_Next_Enabled);
                elmtNextLink.click();
                
            }else{
                // no more pages, so let's end it
                areMorePages = false;
            }
        } while (areMorePages);
        
        return numAccounts;
    }
    
    public String Get_Accts_Table_Tag() {
        return driver.findElement(Accts_Table_Displaying_Tag).getText();
    }
    
}
