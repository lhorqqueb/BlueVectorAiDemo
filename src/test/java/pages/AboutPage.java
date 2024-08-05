package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Automations;

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
    public void open() {
        driver.get("https://bluevector.ai/about/");
    }

    /**
     * Method to highlight, hover over, click, and drag the slider.
     * Uses Automations class methods to perform the actions on the slider handle.
     */
    public void dragSlider() {
        WebElement sliderHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(loc_slider_handle));

        // Highlight the slider handle
        Automations.highlight(loc_slider_handle);
        sleep(2);

        // Hover over the slider handle
        Automations.hoverOverElement(loc_slider_handle);

        // Click and drag the slider handle to the left
        Automations.clickAndHoldAndDrag(loc_slider_handle, -182, 0); // Moving the slider from 272px to 90px (272 - 90 = 182)
        sleep(2);
    }
}
