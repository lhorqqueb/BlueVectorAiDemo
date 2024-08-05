package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverUtil;
import base.UIActions;

public class UITestBase {

    /**
     * Sets up the test environment before any test methods are executed.
     * Opens a Chrome browser and initializes the UIActions with the WebDriver instance.
     */
    @BeforeClass
    public void setUp() {
        DriverUtil.openBrowser("chrome");
        UIActions.setDriver(DriverUtil.getDriver()); // Ensure UIActions is initialized with the driver
    }

    /**
     * Cleans up the test environment after all test methods have been executed.
     * Quits the WebDriver instance, closing all associated windows.
     */
    @AfterClass
    public void tearDown() {
        DriverUtil.quitDriver();
    }

    /**
     * Provides the WebDriver instance to be used in the test methods.
     *
     * @return The WebDriver instance.
     */
    public WebDriver getDriver() {
        return DriverUtil.getDriver();
    }
}
