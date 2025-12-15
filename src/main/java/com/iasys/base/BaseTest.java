package com.iasys.base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.iasys.utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    // ThreadLocal driver for parallel execution
    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    
    public Logger logger;
    public Properties properties;
   
    public static WebDriver getDriver() {
        return tdriver.get();
    }

    private static void setDriver(WebDriver driver) {
        tdriver.set(driver);
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String br) throws IOException {

        logger = LogManager.getLogger(this.getClass());
        properties = new ConfigReader().getProperties();

        WebDriver driver = initializeLocalDriver(br);
        setDriver(driver);

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
    //    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().get(properties.getProperty("baseUrl"));

        logger.info("WebDriver initialized for: " + br);
    }

    private WebDriver initializeLocalDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications",
                        "--disable-popup-blocking",
                        "--disable-extensions",
                        "--disable-infobars",
                        "--ignore-certificate-errors",
                        "--disable-blink-features=AutomationControlled"
                        
                        );
               chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.setAcceptInsecureCerts(true);
               
                return new ChromeDriver(chromeOptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications",
                        "--disable-popup-blocking",
                        "--disable-extensions",
                        "disable-infobars",
                        "--ignore-certificate-errors");
                edgeOptions.setAcceptInsecureCerts(true);
                return new EdgeDriver(edgeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications",
                        "--disable-popup-blocking",
                        "--disable-extensions",
                        "disable-infobars",
                        "--ignore-certificate-errors");
                firefoxOptions.setAcceptInsecureCerts(true);
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.addPreference("dom.disable_open_during_load", true);
                return new FirefoxDriver(firefoxOptions);

            default:
                throw new RuntimeException("Invalid Browser: " + browser);
        }
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            tdriver.remove();
            logger.info("WebDriver quit and removed from ThreadLocal.");
        }
    }

}
