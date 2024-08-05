package utils;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestDetector class implements ITestListener to monitor test execution events
 * and generate Allure reports.
 *
 * @Author Louis H.
 * @Date 07/29/2024
 */
public class TestDetector implements ITestListener {

    /**
     * Called when the test context is started.
     *
     * @param context The test context.
     */
    @Override
    public void onStart(ITestContext context) {
        // You can add code here if needed when the test context starts.
    }

    /**
     * Called when the test context is finished.
     *
     * @param context The test context.
     */
    @Override
    public void onFinish(ITestContext context) {
        // You can add code here if needed when the test context finishes.
    }

    /**
     * Called when an individual test case starts.
     *
     * @param testCase The test case result.
     */
    @Override
    public void onTestStart(ITestResult testCase) {
        String name = testCase.getName();
        Allure.step("Starting test: " + name);
    }

    /**
     * Called when an individual test case passes.
     *
     * @param result The test case result.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("Test passed: " + result.getName());
    }

    /**
     * Called when an individual test case fails.
     *
     * @param result The test case result.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Allure.step("Test failed: " + result.getName());
        Allure.addAttachment("Failure reason", result.getThrowable().toString());
    }

    /**
     * Called when an individual test case is skipped.
     *
     * @param result The test case result.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("Test skipped: " + result.getName());
    }
}
