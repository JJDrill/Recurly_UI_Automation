package ui_framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author J. Drill
 */
public class Browser {
    
    public static WebDriver driver = null;
    
    public enum Browser_Type {
        CHROME, IE, FIREFOX, EDGE;
    }
    
    public WebDriver Get_Driver(Browser_Type browser_choice){
        
        switch(browser_choice){
            case CHROME:
                System.setProperty("webdriver.chrome.driver",
                "D:\\Documents\\Development\\Selenium\\chromedriver_2.27\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
                
            case IE:
                System.setProperty("webdriver.ie.driver",
                "D:\\Documents\\Development\\Selenium\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
                
            case EDGE:
                System.setProperty("webdriver.edge.driver",
                "D:\\Documents\\Development\\Selenium\\Edge v14393\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
                
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",
                "D:\\Documents\\Development\\Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setEnableNativeEvents(false);
                driver = new FirefoxDriver(profile);
                break;
        }
        
        return driver;
    }
    
    public void Clear_Driver(){
        driver = null;
    }
    
    public void Window_Maximize(WebDriver driver){
        driver.manage().window().maximize();
    }
    
    //public void Window_Set_Phone(WebDriver driver){
        //ToDo
    //}
    
    //public void Window_Set_Tablet(WebDriver driver){
        //ToDo
    //}
    
    public void Set_Implicit_Wait(WebDriver driver, long timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
    
    public void Set_Page_Timeout(WebDriver driver, long timeout){
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }
}
