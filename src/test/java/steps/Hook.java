package steps;
import Base.BaseUtil;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.TestRunner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
/**
 * Created by Karthik on 31/01/2019.
 */

public class Hook extends BaseUtil{
 String screenshotdir = System.getProperty("user.dir") + "/test-output/";
    private BaseUtil base;

      public Hook(BaseUtil base) {
          this.base = base;
      }

     /* @Before
      public void InitializeTest(Scenario scenario) {
          //base.scenarioDef = base.test.createNode(scenario.getName());
          WebDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          //chromeOptions.addArguments("--headless");
          TestRunner.tlDriver.get () = new ChromeDriver(chromeOptions);
      }


      @After
      public void TearDownTest(Scenario scenario) {

          TestRunner.tlDriver.get ().quit ();
          System.out.println ("Finish the test Exec");
      }
  */
    public String getBase64Screenshot(WebDriver driver) throws IOException {

        String Base64StringofScreenshot="";
        File src = ((TakesScreenshot) TestRunner.tlDriver.get ()).getScreenshotAs(OutputType.FILE);
        // for saving screenshots in local - this is optional
        Date oDate = new Date();
        SimpleDateFormat oSDF = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = oSDF.format(oDate);
        File dest= new File(screenshotdir + "Screenshot_" + sDate + ".png");
        FileUtils.copyFile(src,dest);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
        return dest.getPath ();
    }
    /*@BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Before every step " + scenario.getId());
    }*/

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Before every step " + stepTestStep.getId());
        if (scenario.isFailed ()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            System.out.println (screenshotName);
            System.out.println (TestRunner.tlDriver.get ().getCurrentUrl ());
            byte[] sourcePath = ((TakesScreenshot) TestRunner.tlDriver.get ()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

}
