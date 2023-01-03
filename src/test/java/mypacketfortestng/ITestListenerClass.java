package mypacketfortestng;

import org.testng.*;
import org.testng.annotations.Test;

public class ITestListenerClass implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("-==Test started==-");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("-==Test PASSED==-\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("-==Test FAILED==-\n");    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("-==Test finished==-\n");
    }
}
