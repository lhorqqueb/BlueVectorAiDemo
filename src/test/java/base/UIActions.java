package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import io.qameta.allure.Attachment;

import java.io.*;
import java.time.*;

public class UIActions {

    private static WebDriver driver;
    private static WebDriverWait waits;

    /**
     * Sets the WebDriver instance for UI actions.
     *
     * @param inputDriver The WebDriver instance to be used.
     */
    public static void setDriver(WebDriver inputDriver) {
        driver = inputDriver;
        waits = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Highlights the specified element by applying a red border.
     *
     * @param location The By locator of the element to be highlighted.
     */
    @Step("Highlight element {location}")
    public static void highlight(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
    }

    /**
     * Moves the mouse to the specified element.
     *
     * @param location The By locator of the element to move to.
     */
    @Step("Move to element {location}")
    public static void moveToElement(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Clicks and holds the mouse button on the specified element.
     *
     * @param location The By locator of the element to click and hold.
     */
    @Step("Click and hold element {location}")
    public static void clickAndHold(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    /**
     * Drags an element from its current position and drops it at the specified offset.
     *
     * @param source  The By locator of the element to drag.
     * @param xOffset The horizontal offset.
     * @param yOffset The vertical offset.
     */
    @Step("Drag and drop element {source} by offset ({xOffset}, {yOffset})")
    public static void dragAndDropBy(By source, int xOffset, int yOffset) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(source));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xOffset, yOffset).perform();
    }

    /**
     * Pauses the execution for the specified number of seconds.
     *
     * @param sec The number of seconds to sleep.
     */
    @Step("Sleep for {sec} seconds")
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException ignore) {
            // Do nothing
        }
    }

    /**
     * Scrolls the view to the specified element.
     *
     * @param location The By locator of the element to scroll to.
     */
    @Step("Scroll to element {location}")
    public static void scrollToElement(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Takes a screenshot of the current browser window and saves it with the specified file name.
     *
     * @param fileName The name of the file to save the screenshot as.
     */
    @Step("Take screenshot {fileName}")
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("path/to/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Clicks on the specified element.
     *
     * @param location The By locator of the element to click.
     */
    @Step("Click on element {location}")
    public static void click(By location) {
        WebElement element = waits.until(ExpectedConditions.elementToBeClickable(location));
        element.click();
    }
}
