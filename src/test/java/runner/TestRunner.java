package runner;
import Base.BaseUtil;
import com.alok.aut.factory.DriverManager;
import com.alok.aut.factory.TargetFactory;
import com.alok.aut.project.Util.Config;
import com.alok.aut.project.Util.LoadObject;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
/**
 * Created by Karthik on 21/09/2019.
 */

@CucumberOptions(features = {"src/test/resources/features/FundamentalsPractice.feature"} ,
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    @Override
    //@DataProvider
    @DataProvider (parallel = true) //-- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    @BeforeSuite
    public void suitSetup(){
        new Config ().readProperties ();
        new LoadObject ().readProperties ();
    }
    @BeforeMethod
    @Parameters({"browser"})
    public void testSetup(String browser){

        TargetFactory targetFactory = new TargetFactory ();
        tlDriver.set (targetFactory.createInstance (browser));
        DriverManager.setDriver (tlDriver.get ());
        BaseUtil.driver=tlDriver.get ();

    }
    @AfterMethod
    public void tearDown( ){
         //tlDriver.get ().quit ();
        DriverManager.getDriver ().quit ();

    }

}
