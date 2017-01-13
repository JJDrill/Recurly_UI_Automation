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
import ui_framework.Get_Started;
import ui_framework.Login;
import ui_framework.Menus;

/**
 *
 * @author J. Drill
 */
public class tc_App_Access {
    WebDriver driver = null;
    
    public tc_App_Access(WebDriver driver) {
        this.driver = driver;
    }
    
    @Test
    public void login() {
        String startingTitle = "Getting Started With Recurly";
        String privateUsername = "";
        String privatePassword = "";
        
        // Stored my username and pass in the private.properties file
        // so it does not get pushed to Github
        try {
            Properties props = new Properties();
            InputStream input = new FileInputStream("nbproject\\private\\private.properties");
            props.load(input);
            privateUsername = props.getProperty("login.username");
            privatePassword = props.getProperty("login.password");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tc_App_Access.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(tc_App_Access.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        driver.get("https://app.recurly.com/login");
        Login login = new Login(driver);
        Get_Started started = login.loginUser(privateUsername, privatePassword);
        assertEquals(startingTitle, started.Get_Page_Title());
    }
    
    @Test
    public void logout() {
        Menus menu = new Menus(driver);
        menu.Nav_LogOut();
    }
}
