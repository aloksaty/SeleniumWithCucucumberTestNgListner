package com.alok.aut.pageObjects;
import com.alok.aut.factory.DriverManager;
import com.alok.aut.project.Util.LoadObject;
import com.alok.aut.project.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/***
 *
 *
 *
 * User: alok
 * Date: 02/10/22
 *
 */
public class FundamentalsPO {
    public String inputTextValue;
    WebDriver driver;
    WebElement inputText;
    WebElement checkedRadio;
    WebElement datePicker;
    public FundamentalsPO () {
        driver = DriverManager.getDriver ();
    }
    public void getBaseURL () {
        driver.manage ().timeouts ().pageLoadTimeout (Duration.ofMinutes (1));
        driver.get (
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    public void testBaseURL () {
        System.out.println (driver.getTitle ());
    }
    public void getInputTextArea(){
        inputText = driver.findElement (By.xpath (LoadObject.inputText));

    }
    public void SendKey (String textValue) {
        this.inputTextValue=textValue;
        inputText.sendKeys (textValue);
    }
    public void testSendKey(){
        Assert.assertEquals (inputText.getAttribute ("value"), inputTextValue);
        inputText.clear ();
        Assert.assertEquals (inputText.getAttribute ("value"), "");
    }
    public void getRadioButton(){
        checkedRadio = driver
                .findElement(By.xpath(LoadObject.CheckedRadio));
    }
    public void checkedRadioButton(){

        Assert.assertTrue (checkedRadio.getAttribute("id").equals ("my-radio-1"));
    }
    public void testCheckedRadioButton(){

        Assert.assertTrue (checkedRadio.isEnabled ());
    }
    public void selectDate() {
        // Get the current date from the system clock
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentDay = today.getDayOfMonth();

        // Click on the date picker to open the calendar
        datePicker.click ();
        // Click on the current month by searching by text
        WebElement monthElement = driver.findElement(By.xpath(
                String.format("//th[contains(text(),'%d')]", currentYear)));
        monthElement.click();

        // Click on the left arrow using relative locators
        WebElement arrowLeft = driver.findElement(By.xpath ("//th[text()='2022']/preceding-sibling::th[@class='prev' " +
                "]"));
        arrowLeft.click();

        // Click on the current month of that year
        WebElement monthPastYear = driver.findElement (By.xpath ("//span[@class='month focused']"));
        monthPastYear.click();

        // Click on the present day in that month
        WebElement dayElement = driver.findElement(By.xpath(String.format(
                "//td[@class='day' and contains(text(),'%d')]", currentDay)));
        dayElement.click();

        // Get the final date on the input text

    }
    public void testSelectedDate () {
        LocalDate today = LocalDate.now();
        String oneYearBack = datePicker.getAttribute("value");
        Log.debug("Final date in date picker: {}"+ oneYearBack);

        // Assert that the expected date is equal to the one selected in the
        // date picker
        LocalDate previousYear = today.minusYears(1);
        DateTimeFormatter dateFormat = DateTimeFormatter
                .ofPattern("MM/dd/yyyy");
        String expectedDate = previousYear.format(dateFormat);

        Assert.assertTrue (oneYearBack.equals (expectedDate));
    }
    public void getDatePicker () {

        datePicker = driver.findElement(By.name("my-date"));
    }
}
