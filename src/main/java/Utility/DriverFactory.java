package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverFactory {
    public static WebDriver driver;
    private static String browser;

    public static WebDriver getDriver(){
        //Obtengo el browser desde PropertiesFile
        browser = PropertiesFile.getProperty("browser");

        if (browser.equals("chrome")){ //Si el browser obtenido es chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){ //Si el browser obtenido es firefox
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equals("edge")){ //Si el browser obtenido es edge
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }
}
