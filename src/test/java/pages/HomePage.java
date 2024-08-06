package pages;

import org.openqa.selenium.*;
import utils.Automations;
import io.qameta.allure.*;

import static utils.Automations.sleep;

public class HomePage {

    private WebDriver driver;
    private final String url = "https://bluevector.ai";

    // -------------- Web Elements Locations -------------------- //

    // --- Header --- //
    private final By loc_home_logo = By.cssSelector("img.wp-image-4252");
    private final By loc_snapapp_button = By.cssSelector("a[href='https://bluevector.ai/snapapp/']");
    private final By loc_healthcare_button = By.cssSelector("a[href='https://bluevector.ai/healthcare/']");
    private final By loc_government_button = By.cssSelector("a[href='https://bluevector.ai/government/']");
    private final By loc_about_button = By.cssSelector("a[href='https://bluevector.ai/capabilities/']");

    // --- Body --- //
    private final By loc_contact_us_button = By.cssSelector(".elementor-widget-button .elementor-button-text");

    /**
     * Constructor to initialize the HomePage class.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        Automations.setDriver(driver); // Ensure Automations is initialized with the driver
    }

    /**
     * Method to open the homepage.
     * Navigates to the homepage URL and maximizes the browser window.
     */
    @Step("Open Home page")
    public void open() {
        driver.get(url);
        driver.manage().window().maximize();
        attachScreenshot("Opened Home Page");
    }

    /**
     * Method to check if the logo is visible and highlight it.
     * Highlights the home logo if it is displayed.
     */
    @Step("Verify and highlight Home logo")
    public void verifyLogo() {
        WebElement logo = driver.findElement(loc_home_logo);
        if (logo.isDisplayed()) {
            Automations.highlight(loc_home_logo);
            attachScreenshot("Home Logo Highlighted");
        }
    }

    /**
     * Method to click the Contact Us button.
     * Highlights the button, waits for 2 seconds, and then clicks it twice.
     */
    @Step("Click Contact Us button")
    public void clickContactUs() {
        Automations.highlight(loc_contact_us_button);
        sleep(2);
        WebElement contactUsButton = driver.findElement(loc_contact_us_button);
        sleep(2);
        contactUsButton.click();
        contactUsButton.click();
        attachScreenshot("Contact Us Button Clicked");
    }

    /**
     * Method to click the SnapApp button.
     * Highlights the button, waits for 2 seconds, and then clicks it twice.
     */
    @Step("Click SnapApp button")
    public void clickSnapApp() {
        Automations.highlight(loc_snapapp_button);
        sleep(2);
        WebElement snapAppButton = driver.findElement(loc_snapapp_button);
        sleep(2);
        snapAppButton.click();
        snapAppButton.click();
        attachScreenshot("SnapApp Button Clicked");
    }

    /**
     * Method to click the Healthcare button.
     * Highlights the button, waits for 2 seconds, and then clicks it twice.
     */
    @Step("Click Healthcare button")
    public void clickHealthcare() {
        Automations.highlight(loc_healthcare_button);
        sleep(2);
        WebElement healthcareButton = driver.findElement(loc_healthcare_button);
        sleep(2);
        healthcareButton.click();
        healthcareButton.click();
        attachScreenshot("Healthcare Button Clicked");
    }

    /**
     * Method to click the Government button.
     * Highlights the button, waits for 2 seconds, and then clicks it twice.
     */
    @Step("Click Government button")
    public void clickGovernment() {
        Automations.highlight(loc_government_button);
        sleep(2);
        WebElement governmentButton = driver.findElement(loc_government_button);
        sleep(2);
        governmentButton.click();
        governmentButton.click();
        attachScreenshot("Government Button Clicked");
    }

    /**
     * Method to click the About button.
     * Highlights the button, waits for 2 seconds, and then clicks it twice.
     */
    @Step("Click About button")
    public void clickAbout() {
        Automations.highlight(loc_about_button);
        sleep(2);
        WebElement aboutButton = driver.findElement(loc_about_button);
        sleep(2);
        aboutButton.click();
        aboutButton.click();
        attachScreenshot("About Button Clicked");
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
