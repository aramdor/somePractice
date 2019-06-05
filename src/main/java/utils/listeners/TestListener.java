package utils.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ApplicationManager;
import utils.Attachments;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
                Attachments.getScreenshot(ApplicationManager.getDriverStatic(), "Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Attachments.getScreenshot(ApplicationManager.getDriverStatic(), "Failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Attachments.getScreenshot(ApplicationManager.getDriverStatic(), "Failure");
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
