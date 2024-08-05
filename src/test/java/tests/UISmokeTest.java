package tests;

import base.UITestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import static utils.Automations.*;
import static utils.DriverUtil.closeBrowser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
public class UISmokeTest extends UITestBase {

    /**
     * Test to verify if the application is accessible.
     * Opens the home page, verifies the logo, and highlights it.
     */
    @Test
    @Step("Verify application is accessible")
    public void verifyAppIsAccessible() {
        HomePage homePage = new HomePage(getDriver());

        // Test Steps
        homePage.open();
        sleep(2);
        homePage.verifyLogo();
        sleep(2);
        attachScreenshot("verifyAppIsAccessible");
    }

    /**
     * Test to verify if the Contact Us page is accessible.
     * Opens the home page, navigates to the Contact Us page, and fills the contact form.
     */
    @Test
    @Step("Verify Contact Us page is accessible")
    public void verifyContactUsIsAccessible() {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        // Test Steps
        homePage.open();
        sleep(2);
        homePage.clickContactUs();
        sleep(2);
        contactUsPage.fillContactForm();
        sleep(2);
        attachScreenshot("verifyContactUsIsAccessible");
        // contactUsPage.clickSubmit();
        // sleep(2);
    }

    /**
     * Test to verify if the About page is accessible.
     * Opens the home page, navigates to the About page, and interacts with the slider.
     */
    @Test
    @Step("Verify About page is accessible")
    public void verifyAboutPageIsAccessible() {
        HomePage homePage = new HomePage(getDriver());
        AboutPage aboutPage = new AboutPage(getDriver());

        // Test Steps
        homePage.open();
        // sleep(2);
        homePage.clickAbout();
        // sleep(2);
        aboutPage.dragSlider();
        sleep(2);
        attachScreenshot("verifyAboutPageIsAccessible");
        // closeBrowser();
    }

    /**
     * Test to verify if the Healthcare page is accessible.
     * Opens the home page, navigates to the Healthcare page, and interacts with various elements.
     */
    @Test
    @Step("Verify Healthcare page is accessible")
    public void verifyHealthcarePage() {
        HomePage homePage = new HomePage(getDriver());
        HealthcarePage healthcarePage = new HealthcarePage(getDriver());

        // Test Steps
        homePage.open();
        sleep(2);
        homePage.clickHealthcare();
        sleep(2);
        healthcarePage.verifyLogoText();
        sleep(2);
        healthcarePage.highlightInfographicButton();
        sleep(2);
        healthcarePage.highlightAllCaseStudies();
        sleep(2);
        attachScreenshot("highlightAllCaseStudies");
        healthcarePage.clickConsultButton();
        sleep(2);
        attachScreenshot("verifyHealthcarePage");
        closeBrowser();
    }

    /**
     * Test placeholder for verifying the SnapApp page.
     * (Currently not implemented)
     */
    @Test
    @Step("Verify SnapApp page is accessible")
    public void verifySnapAppPage() {
        HomePage homePage = new HomePage(getDriver());
        // Test steps to be implemented
    }

    /**
     * Test placeholder for verifying the Government page.
     * (Currently not implemented)
     */
    @Test
    @Step("Verify Government page is accessible")
    public void verifyGovernmentPage() {
        HomePage homePage = new HomePage(getDriver());
        // Test steps to be implemented
    }

    /**
     * Attach a screenshot to the Allure report.
     *
     * @param name The name of the attachment.
     * @return The screenshot bytes.
     */
    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
