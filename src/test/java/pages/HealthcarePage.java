package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Automations;
import base.UIActions;
import io.qameta.allure.*;

public class HealthcarePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // -- Web Elements Locations ----- //
    // -- Header -- //
    private final By loc_text_logo = By.className("qodef-m-title");
    private final By loc_infographic_button = By.xpath("//a[contains(@href, 'infographic.pdf')]");
    private final By loc_consult_button = By.xpath("//a[contains(@href, 'calendar.app.google')]");

    // -- Body -- //
    private final By loc_body_text = By.cssSelector(".elementor-element-c51e10a .elementor-widget-container");
    private final By loc_case_study_document_ai = By.cssSelector(".elementor-element-38fab63b");
    private final By loc_case_study_CCAI = By.cssSelector(".elementor-element-2b14e0a");
    private final By loc_case_study_visual_inspection = By.cssSelector(".elementor-element-3b3b8448");
    private final By loc_case_study_device_connect = By.cssSelector(".elementor-element-696cfea6");
    private final By loc_case_study_sku_optimization = By.cssSelector(".elementor-element-8042efb");
    private final By loc_case_study_translation_ai = By.cssSelector(".elementor-element-9d72f79");
    private final By loc_case_study_forecasting = By.cssSelector(".elementor-element-274e13c");
    private final By loc_case_study_medical_imaging_ai = By.cssSelector(".elementor-element-11efe53");

    /**
     * Constructor to initialize the HealthcarePage class.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public HealthcarePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Automations.setDriver(driver); // Ensure Automations is initialized with the driver
    }

    /**
     * Method to open the Healthcare page.
     * Navigates to the specified URL.
     */
    @Step("Open Healthcare page")
    public void open() {
        driver.get("https://bluevector.ai/healthcare/");
    }

    /**
     * Method to check if the logo text is visible and highlight it.
     * Highlights the logo text if it is displayed.
     */
    @Step("Verify and highlight logo text")
    public void verifyLogoText() {
        WebElement logoText = wait.until(ExpectedConditions.visibilityOfElementLocated(loc_text_logo));
        if (logoText.isDisplayed()) {
            UIActions.highlight(loc_text_logo);
            attachScreenshot("Logo Text Highlighted");
        }
    }

    /**
     * Method to highlight the Infographic button.
     */
    @Step("Highlight Infographic button")
    public void highlightInfographicButton() {
        UIActions.highlight(loc_infographic_button);
        UIActions.sleep(2);
        attachScreenshot("Infographic Button Highlighted");
    }

    /**
     * Method to click the Infographic button.
     * Scrolls to the Infographic button, highlights it, and then clicks it.
     */
    @Step("Click Infographic button")
    public void clickInfographicButton() {
        UIActions.scrollToElement(loc_infographic_button);
        UIActions.highlight(loc_infographic_button);
        UIActions.sleep(2);
        UIActions.click(loc_infographic_button);
        attachScreenshot("Infographic Button Clicked");
    }

    /**
     * Method to click the Consult button.
     * Scrolls to the Consult button, highlights it, and then clicks it.
     */
    @Step("Click Consult button")
    public void clickConsultButton() {
        UIActions.sleep(2);
        UIActions.scrollToElement(loc_consult_button);
        UIActions.highlight(loc_consult_button);
        UIActions.sleep(2);
        UIActions.click(loc_consult_button);
        attachScreenshot("Consult Button Clicked");
    }

    /**
     * Method to highlight the Body Text.
     */
    @Step("Highlight Body Text")
    public void highlightBodyText() {
        UIActions.highlight(loc_body_text);
        UIActions.sleep(2);
        attachScreenshot("Body Text Highlighted");
    }

    // Methods to highlight and click on each case study element
    @Step("Click Case Study Document AI")
    public void clickCaseStudyDocumentAI() {
        UIActions.highlight(loc_case_study_document_ai);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_document_ai);
        attachScreenshot("Case Study Document AI Clicked");
    }

    @Step("Click Case Study CCAI")
    public void clickCaseStudyCCAI() {
        UIActions.highlight(loc_case_study_CCAI);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_CCAI);
        attachScreenshot("Case Study CCAI Clicked");
    }

    @Step("Click Case Study Visual Inspection")
    public void clickCaseStudyVisualInspection() {
        UIActions.highlight(loc_case_study_visual_inspection);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_visual_inspection);
        attachScreenshot("Case Study Visual Inspection Clicked");
    }

    @Step("Click Case Study Device Connect")
    public void clickCaseStudyDeviceConnect() {
        UIActions.highlight(loc_case_study_device_connect);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_device_connect);
        attachScreenshot("Case Study Device Connect Clicked");
    }

    @Step("Click Case Study SKU Optimization")
    public void clickCaseStudySKUOptimization() {
        UIActions.highlight(loc_case_study_sku_optimization);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_sku_optimization);
        attachScreenshot("Case Study SKU Optimization Clicked");
    }

    @Step("Click Case Study Translation AI")
    public void clickCaseStudyTranslationAI() {
        UIActions.highlight(loc_case_study_translation_ai);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_translation_ai);
        attachScreenshot("Case Study Translation AI Clicked");
    }

    @Step("Click Case Study Forecasting")
    public void clickCaseStudyForecasting() {
        UIActions.highlight(loc_case_study_forecasting);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_forecasting);
        attachScreenshot("Case Study Forecasting Clicked");
    }

    @Step("Click Case Study Medical Imaging AI")
    public void clickCaseStudyMedicalImagingAI() {
        UIActions.highlight(loc_case_study_medical_imaging_ai);
        UIActions.sleep(2);
        UIActions.click(loc_case_study_medical_imaging_ai);
        attachScreenshot("Case Study Medical Imaging AI Clicked");
    }

    /**
     * Method to highlight all case study elements and scroll to each element.
     */
    @Step("Highlight all Case Studies")
    public void highlightAllCaseStudies() {
        UIActions.scrollToElement(loc_body_text);
        UIActions.highlight(loc_case_study_document_ai);
        UIActions.sleep(1);
        attachScreenshot("Case Study Document AI Highlighted");
        UIActions.highlight(loc_case_study_CCAI);
        UIActions.sleep(1);
        attachScreenshot("Case Study CCAI Highlighted");
        UIActions.highlight(loc_case_study_visual_inspection);
        UIActions.sleep(1);
        attachScreenshot("Case Study Visual Inspection Highlighted");
        UIActions.highlight(loc_case_study_device_connect);
        UIActions.sleep(1);
        attachScreenshot("Case Study Device Connect Highlighted");
        UIActions.scrollToElement(loc_case_study_document_ai);
        UIActions.highlight(loc_case_study_sku_optimization);
        UIActions.sleep(1);
        attachScreenshot("Case Study SKU Optimization Highlighted");
        UIActions.highlight(loc_case_study_translation_ai);
        UIActions.sleep(1);
        attachScreenshot("Case Study Translation AI Highlighted");
        UIActions.highlight(loc_case_study_forecasting);
        UIActions.sleep(1);
        attachScreenshot("Case Study Forecasting Highlighted");
        UIActions.highlight(loc_case_study_medical_imaging_ai);
        UIActions.sleep(1);
        attachScreenshot("Case Study Medical Imaging AI Highlighted");
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
