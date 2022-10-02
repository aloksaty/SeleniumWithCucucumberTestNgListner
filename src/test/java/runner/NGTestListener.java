package runner;
import Base.ExtentReportUtil;
import Base.GetScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Base.BaseUtil.scenarioDef;
/**
 * Created by Karthik on 21/09/2019.
 */
public class NGTestListener implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onTestStart (ITestResult iTestResult) {

        System.out.println ("********Test Start From TestNg Listeners ################");

    }
    @Override
    public void onTestSuccess (ITestResult iTestResult) {
        System.out.println ("############Test Pass From TestNg Listeners ################");
    }
    @Override
    public void onTestFailure (ITestResult iTestResult) {
        iTestResult.setStatus (2);
        System.out.println ("**************** Taking screenshot in TestNg Listeners*****");
    }
    @Override
    public void onTestSkipped (ITestResult iTestResult) {
        System.out.println ("On test skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage (ITestResult iTestResult) {
        System.out.println ("On test percentage");
    }
    @Override
    public void onStart (ITestContext iTestContext) {
        System.out.println ("^^^^^^ Test Context ^^^^^^^^");


    }
    @Override
    public void onFinish (ITestContext iTestContext) {
        System.out.println ("On finish");
    }
}
