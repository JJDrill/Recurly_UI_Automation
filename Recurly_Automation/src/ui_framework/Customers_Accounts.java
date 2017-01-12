/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author J. Drill
 */
public class Customers_Accounts {
    WebDriver driver = null;
    
    public enum Account_Status_Types {
        All, Open, Closed;
    }
    
    public enum Subscription_Status_Types {
        All, Active, Renewing, Non_Renewing, Future_State_Date, In_Trial, Past_Due, No_Subscription;
    }
    
    // Page Objects - Status
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
    
    // Constructor
    public Customers_Accounts(WebDriver driver){
        this.driver = driver;
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
    
}
