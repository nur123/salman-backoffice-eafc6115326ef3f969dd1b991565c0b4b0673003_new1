package utils;

import baseTest.BaseTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.SlackUtils;

import static utils.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {
    public static String imageName;

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName());
        String titleTestPass = "PASSED : ";
        String preTest = "TEST RESULT for " + iTestContext.getName();
        String titleTestFail = "FAILED : ";
        int resultPass = iTestContext.getPassedTests().size();
        int resultFailed = iTestContext.getFailedTests().size();
        System.out.print("Passed Test: ");
        System.out.println(resultPass);
        System.out.print("Failed Test: ");
        System.out.println(resultFailed);
        try {
            SlackUtils.slackTestResult("test", preTest, titleTestPass,titleTestFail, resultPass,resultFailed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test is succeed.");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for Test Case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

        String successMessage = "PASSED";
        String titleTest = getTestMethodName(iTestResult);
        String preTest = iTestResult.getInstanceName();
        try {
            SlackUtils.slackPassed("test", preTest, titleTest, successMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test is failed.");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for Test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        String errorMessage = iTestResult.getThrowable().toString()+" "+"(FAILED TEST) ";
        String titleTest = getTestMethodName(iTestResult);
        String preTest = iTestResult.getInstanceName();
        System.out.print("Error Message: ");
        System.out.println(errorMessage);
        System.out.print("Title Test: ");
        System.out.println(titleTest);
        System.out.print("PreTest: ");
        System.out.println(preTest);
        try {
            SlackUtils.slackFailed("test", preTest, titleTest, errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Mobile.test is skipped.");
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}