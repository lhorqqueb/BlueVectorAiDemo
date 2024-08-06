package tests;

import base.UITestBase;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.*;
import static utils.Automations.*;
import static utils.DriverUtil.*;

import java.io.ByteArrayInputStream;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
public class UISmokeTest extends UITestBase {

    @Test(description = "Verify application is accessible")
    public void verifyAppIsAccessible() {
        HomePage homePage = new HomePage(getDriver());
        openHomePage(homePage);
        verifyLogoOnHomePage(homePage);
    }

    @Test(description = "Verify Contact Us page is accessible")
    public void verifyContactUsIsAccessible() {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        openHomePage(homePage);
        navigateToContactUsPage(homePage);
        fillContactUsForm(contactUsPage);
    }

    @Test(description = "Verify About page is accessible")
    public void verifyAboutPageIsAccessible() {
        HomePage homePage = new HomePage(getDriver());
        AboutPage aboutPage = new AboutPage(getDriver());
        openHomePage(homePage);
        navigateToAboutPage(homePage);
        interactWithSliderOnAboutPage(aboutPage);
    }

    @Test(description = "Verify Healthcare page is accessible")
    public void verifyHealthcarePage() {
        HomePage homePage = new HomePage(getDriver());
        HealthcarePage healthcarePage = new HealthcarePage(getDriver());
        openHomePage(homePage);
        navigateToHealthcarePage(homePage);
        interactWithHealthcarePageElements(healthcarePage);
    }

    @Test(description = "Verify SnapApp page is accessible")
    public void verifySnapAppPage() {
        HomePage homePage = new HomePage(getDriver());
        // Implement steps for SnapApp page verification
    }

    @Test(description = "Verify Government page is accessible")
    public void verifyGovernmentPage() {
        HomePage homePage = new HomePage(getDriver());
        // Implement steps for Government page verification
    }

    @Step("Open Home Page")
    private void openHomePage(HomePage homePage) {
        Allure.step("Opening the home page");
        homePage.open();
        sleep(2);
        attachScreenshot("Home Page Opened");
    }

    @Step("Verify Logo on Home Page")
    private void verifyLogoOnHomePage(HomePage homePage) {
        Allure.step("Verifying and highlighting the logo on the home page");
        homePage.verifyLogo();
        attachScreenshot("Home Page Logo Verified");
        sleep(2);
    }

    @Step("Navigate to Contact Us Page")
    private void navigateToContactUsPage(HomePage homePage) {
        Allure.step("Navigating to the Contact Us page");
        homePage.clickContactUs();
        sleep(2);
        attachScreenshot("Navigated to Contact Us Page");
    }

    @Step("Fill Contact Us Form")
    private void fillContactUsForm(ContactUsPage contactUsPage) {
        Allure.step("Filling the Contact Us form with random data");
        contactUsPage.fillContactForm();
        attachScreenshot("Contact Us Form Filled");
        sleep(2);
        // contactUsPage.clickSubmit();
        // sleep(2);
    }

    @Step("Navigate to About Page")
    private void navigateToAboutPage(HomePage homePage) {
        Allure.step("Navigating to the About page");
        homePage.clickAbout();
        sleep(2);
        attachScreenshot("Navigated to About Page");
    }

    @Step("Interact with Slider on About Page")
    private void interactWithSliderOnAboutPage(AboutPage aboutPage) {
        Allure.step("Interacting with the slider on the About page");
        aboutPage.dragSlider();
        attachScreenshot("Slider on About Page Interacted");
        sleep(2);
        // closeBrowser();
    }

    @Step("Navigate to Healthcare Page")
    private void navigateToHealthcarePage(HomePage homePage) {
        Allure.step("Navigating to the Healthcare page");
        homePage.clickHealthcare();
        sleep(2);
        attachScreenshot("Navigated to Healthcare Page");
    }

    @Step("Interact with Healthcare Page Elements")
    private void interactWithHealthcarePageElements(HealthcarePage healthcarePage) {
        Allure.step("Verifying logo text on Healthcare page");
        healthcarePage.verifyLogoText();
        sleep(2);
        Allure.step("Highlighting Infographic button on Healthcare page");
        healthcarePage.highlightInfographicButton();
        sleep(2);
        Allure.step("Highlighting all case studies on Healthcare page");
        healthcarePage.highlightAllCaseStudies();
        attachScreenshot("Healthcare Page Case Studies Highlighted");
        sleep(2);
        Allure.step("Clicking Consult button on Healthcare page");
        healthcarePage.clickConsultButton();
        attachScreenshot("Healthcare Page Consult Button Clicked");
        sleep(2);
        closeBrowser();
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        return screenshot;
    }
}
