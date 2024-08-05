package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains abstraction of low-level Selenium browser
 * automation code as simple methods.
 *
 * @Author Louis H.
 * @Date 07/29/2024
 */
public class Automations {

    private static WebDriver driver;
    private static WebDriverWait waits;

    /**
     * Initializes the global driver-related variables that will be used
     * inside this class. You must call this method before using any of the
     * methods this class offers.
     */
    public static void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        waits = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Sets the WebDriver instance to be used by this class.
     *
     * @param inputDriver The WebDriver instance to use.
     */
    public static void setDriver(WebDriver inputDriver) {
        driver = inputDriver;
        waits = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Navigates to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    public static void visit(String url) {
        driver.get(url);
    }

    /**
     * Clicks on the element located by the specified selector.
     *
     * @param location The selector of the element to click.
     */
    public static void click(By location) {
        WebElement element = waits.until(ExpectedConditions.elementToBeClickable(location));
        element.click();
    }

    /**
     * Types the specified text into the element located by the specified selector.
     *
     * @param location The selector of the element to type into.
     * @param text     The text to type.
     */
    public static void type(By location, String text) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Checks if the element located by the specified selector is visible.
     *
     * @param location The selector of the element to check.
     * @return True if the element is visible, otherwise false.
     */
    public static boolean isVisible(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        return element.isDisplayed();
    }

    /**
     * Switches to the tab with the specified title.
     *
     * @param targetTitle The title of the tab to switch to.
     */
    public static void switchToTab(String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String each : ids) {
            driver.switchTo().window(each);
            String title = driver.getTitle();
            if (title.contains(targetTitle)) {
                break;
            }
        }
    }

    /**
     * Closes the current browser window.
     */
    public static void closeWindow() {
        driver.close();
    }

    /**
     * Pauses execution for the specified number of seconds.
     *
     * @param sec The number of seconds to sleep.
     */
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException ignore) {
            // NO-OP
        }
    }

    /**
     * Highlights the element located by the specified selector.
     *
     * @param location The selector of the element to highlight.
     */
    public static void highlight(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
    }

    /**
     * Quits the WebDriver and closes all associated windows.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Hovers over the element located by the specified selector.
     *
     * @param location The selector of the element to hover over.
     */
    public static void hoverOverElement(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        highlight(location); // Highlight to confirm hover
    }

    /**
     * Clicks, holds, and drags the element located by the specified selector.
     *
     * @param location The selector of the element to drag.
     * @param xOffset  The horizontal offset to drag to.
     * @param yOffset  The vertical offset to drag to.
     */
    public static void clickAndHoldAndDrag(By location, int xOffset, int yOffset) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }
}
