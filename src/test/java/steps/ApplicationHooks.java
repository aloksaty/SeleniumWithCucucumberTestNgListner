package steps;
public class ApplicationHooks {
/*
	private DriverFactory driverFactory;
	private WebDriver driver;
	//private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		//configReader = new ConfigReader();
		//prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		//String browserName = prop.getProperty("browser");
		System.out.println ("Hook is running ");
		String browserName= "chrome";
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}*/

}
