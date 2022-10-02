package Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;
public class GetScreenShot {
	WebDriver driver;
	String name;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	public GetScreenShot () {
		this.driver= BaseUtil.driver;
	}
	public void capture(String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\report\\" + screenShotName + sdf.format(new Timestamp(System.currentTimeMillis())) + ".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBase64Screenshot(WebDriver driver)  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest =
				System.getProperty("user.dir") + "/test-output/" + 1 + ".png";
		System.out.println ("@#@#@@#@#"+dest);
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte [] fileContent = new byte[0];
		try {
			fileContent = FileUtils.readFileToByteArray (source);
		} catch (IOException e) {
			throw new RuntimeException (e);
		}
		String Base64StringOfScreenshot ="data:image/png;base64,"+ Base64.getEncoder ().encodeToString (fileContent);
		return dest;
	}
	
}