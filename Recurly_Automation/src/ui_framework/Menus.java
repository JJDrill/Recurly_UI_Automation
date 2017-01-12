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
public class Menus {
    
    WebDriver driver = null;
    
    // Page Objects - Top
    By Log_Out = By.linkText("Log Out");
    
    // Page Objects - Side
    By Customers = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/h4/button");
    By Customers_Accounts = By.linkText("Accounts");
    By Customers_Subscriptions = By.linkText("Subscriptions");
    By Customers_Invoices = By.linkText("Invoices");
    By Customers_Transactions = By.linkText("Transactions");
    
    // TODO Code in rest of the side menu
    
    public void Nav_LogOut(){
        driver.findElement(Log_Out).click();
    }
    
    public Menus(WebDriver driver){
        this.driver = driver;
    }
    
    public void Nav_Customers(){
        //TODO Make this click smarter by checking to see if it's open first
        driver.findElement(Customers).click();
    }
    
    public Customers_Accounts Nav_Customers_Accounts(){
        this.Nav_Customers();
        driver.findElement(Customers_Accounts).click();
        return new Customers_Accounts(driver);
    }
    
    public Customers_Subscriptions Nav_Customers_Subscriptions(){
        this.Nav_Customers();
        driver.findElement(Customers_Subscriptions).click();
        return new Customers_Subscriptions(driver);
    }
    
    public Customers_Invoices Nav_Customers_Invoices(){
        this.Nav_Customers();
        driver.findElement(Customers_Invoices).click();
        return new Customers_Invoices(driver);
    }
    
    public Customers_Transactions Nav_Customers_Transactions(){
        this.Nav_Customers();
        driver.findElement(Customers_Transactions).click();
        return new Customers_Transactions(driver);
    }
}
