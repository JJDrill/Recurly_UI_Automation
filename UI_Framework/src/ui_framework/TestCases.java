/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_framework;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author J. Drill
 */
public class TestCases {
    
    public static void main(String[] args) {
        //Chrome
        Browser browser = new Browser();
        WebDriver driver = browser.Get_Driver(Browser.Browser_Type.CHROME);
        browser.Window_Maximize(driver);
        browser.Set_Implicit_Wait(driver, 5);
        browser.Set_Page_Timeout(driver, 5);
        
        driver.close();
        browser.Clear_Driver();
        
        //EDGE
        driver = browser.Get_Driver(Browser.Browser_Type.EDGE);
        browser.Window_Maximize(driver);
        browser.Set_Implicit_Wait(driver, 5);
        browser.Set_Page_Timeout(driver, 5);
        
        driver.close();
        browser.Clear_Driver();
    }
    
}
