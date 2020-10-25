package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public  static WebDriver driver;

    public void openBrowser() throws Exception
    {
        String browser = getDataFrmPrprty("browser");
        String device = getDataFrmPrprty("device");
        switch(browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                switch(device)
                {
                    case "iphone6":
                        Dimension dimension = new Dimension(414,736);
                        driver.manage().window().setSize(dimension);
                        break;

                    case "Samsungs3":
                        Dimension dimension1 = new Dimension(360,640);
                        driver.manage().window().setSize(dimension1);
                        break;
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                switch(device)
                {
                    case "iphone6":
                        Dimension dimension = new Dimension(414,736);
                        driver.manage().window().setSize(dimension);
                        break;

                    case "Samsungs3":
                        Dimension dimension1 = new Dimension(360,640);
                        driver.manage().window().setSize(dimension1);
                        break;

                }
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;
        }

    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public String getDataFrmPrprty(String key) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(FilePaths.configFilePath);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    public void implicitwait(int waittime)
    {
        driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
    }

    public void explicitWait( WebElement element, int maxTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, maxTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

