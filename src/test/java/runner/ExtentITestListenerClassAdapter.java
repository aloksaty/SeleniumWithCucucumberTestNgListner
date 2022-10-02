package runner;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.service.ExtentService;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentITestListenerClassAdapter implements ITestListener {

        @Override
        public synchronized void onStart(ITestContext context) {
            ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
            System.out.println ("*!*@*#*#*#*#*#* RElative path"+ExtentService.getScreenshotReportRelatvePath ());
        }

        @Override
        public synchronized void onFinish(ITestContext context) {
            ExtentService.getInstance().flush();
        }

        @Override
        public synchronized void onTestStart(ITestResult result) {

        }

        @Override
        public synchronized void onTestSuccess(ITestResult result) {

        }

        @Override
        public synchronized void onTestFailure(ITestResult result) {
            System.out.println ("*****"+result.getParameters ()[0]);
            System.out.println ("*****######"+result.getParameters ()[1]);
            System.out.println ("*!*!*!*!*!*"+ExtentService.getScreenshotFolderName ());
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter ("test-output/SparkReports");
            extentSparkReporter.getReport ();
        }

        @Override
        public synchronized void onTestSkipped(ITestResult result) {
        }

        @Override
        public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        }

    }