package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Automations;
import io.qameta.allure.*;

import static utils.Automations.sleep;

public class AboutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // --- Web Elements Locations ------- //
    private final By loc_slider_handle = By.cssSelector(".twentytwenty-handle");

    /**
     * Constructor to initialize the AboutPage class.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public AboutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Automations.setDriver(driver); // Ensure Automations is initialized with the driver
    }

    /**
     * Method to open the About page.
     * Navigates to the About page URL.
     */
    @Step("Open About page")
    public void open() {
        driver.get("https://bluevector.ai/about/");
    }

    /**
     * Method to highlight, hover over, click, and drag the slider.
     * Uses Automations class methods to perform the actions on the slider handle.
     */
    @Step("Drag the slider on About page")
    public void dragSlider() {
        WebElement sliderHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(loc_slider_handle));

        // Highlight the slider handle
        Automations.highlight(loc_slider_handle);
        sleep(2);
        attachScreenshot("Slider Handle Highlighted");

        // Hover over the slider handle
        Automations.hoverOverElement(loc_slider_handle);

        // Click and drag the slider handle to the left
        Automations.clickAndHoldAndDrag(loc_slider_handle, -182, 0); // Moving the slider from 272px to 90px (272 - 90 = 182)
        sleep(2);
        attachScreenshot("Slider Handle Dragged");
    }

    /**
     * Attach a screenshot to the Allure report.
     *
     * @param name The name of the attachment.
     * @return The screenshot bytes.
     */
    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
