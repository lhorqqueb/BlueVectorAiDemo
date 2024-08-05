package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class contains driver-related common methods
 * that will be used in order to automate test scripts.
 *
 * @Author Louis H.
 * @Date 07/29/2024
 */
public class DriverUtil {

    private static WebDriver driver;

    /**
     * Creates a connection between the driver and the specified browser.
     * After invoking this method, the driver will refer to the corresponding browser driver object.
     *
     * @param browserType The type of browser to use [chrome, edge, firefox, headless].
     */
    public static void openBrowser(String browserType) {
        // Determine the chosen browser
        boolean isChrome = browserType.equalsIgnoreCase("chrome");
        boolean isEdge = browserType.equalsIgnoreCase("edge");
        boolean isFirefox = browserType.equalsIgnoreCase("firefox");
        boolean isHeadlessChrome = browserType.equalsIgnoreCase("headless");

        if (isChrome) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (isEdge) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (isFirefox) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (isHeadlessChrome) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1200");
            options.addArguments("--disable-extensions");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
    }

    /**
     * Provides access to the current driver instance.
     *
     * @return The current WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Terminates the driver-to-browser connection and quits the browser.
     */
    public static void closeBrowser() {
        driver.quit();
    }

    /**
     * Closes the current window that the driver is focused on.
     */
    public static void closeWindow() {
        driver.close();
    }

    /**
     * Quits the driver and closes all associated windows.
     * Sets the driver instance to null.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Refreshes the current window.
     */
    public static void refresh() {
        driver.navigate().refresh();
    }
}
