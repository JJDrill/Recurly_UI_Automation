/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_framework;

import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author J. Drill
 */
public class Menu_Side {
    
    WebDriver driver = null;
    
    // Page Objects
    By Customers = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/h4/button");
    By Customers_Accounts = By.linkText("Accounts");
    By Customers_Subscriptions = By.linkText("Subscriptions");
    By Customers_Invoices = By.linkText("Invoices");
    By Customers_Transactions = By.linkText("Transactions");
    
    public Menu_Side(WebDriver driver){
        this.driver = driver;
    }
    
    public void Nav_Customers(){
        //TODO Make this click smarter by checking to see if it's open first
        driver.findElement(Customers).click();
    }
    
    public void Nav_Customers_Accounts(){
        this.Nav_Customers();
        driver.findElement(Customers_Accounts).click();
    }
    
    public void Nav_Customers_Subscriptions(){
        this.Nav_Customers();
        driver.findElement(Customers_Subscriptions).click();
    }
    
    public void Nav_Customers_Invoices(){
        this.Nav_Customers();
        driver.findElement(Customers_Invoices).click();
    }
    
    public void Nav_Customers_Transactions(){
        this.Nav_Customers();
        driver.findElement(Customers_Transactions).click();
    }
}
