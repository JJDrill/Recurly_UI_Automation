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
public class Login {
    WebDriver driver = null;
    
    // Page Objects
    By byUserName = By.id("user_email");
    By byPassword = By.id("user_password");
    By byLogIn = By.id("submit_button");
    
    // Constructor
    public Login(WebDriver driver){
        this.driver = driver;
    }
    
    // Set the user name
    public void setUserName(String userName){
        driver.findElement(byUserName).sendKeys(userName);
    }
    
    // Set the password
    public void setPassword(String password){
        driver.findElement(byPassword).sendKeys(password);
    }
    
    // Click the login button
    public void clickLogin(){
        driver.findElement(byLogIn).click();
    }
    
    // Shortcut function to login a user
    public Get_Started loginUser(String userName, String password){
        this.setUserName(userName);
        this.setPassword(password);
        this.clickLogin();
        
        return new Get_Started(driver);
    }
}
