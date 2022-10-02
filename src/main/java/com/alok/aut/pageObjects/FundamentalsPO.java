package com.alok.aut.pageObjects;
import com.alok.aut.factory.DriverManager;
import com.alok.aut.project.Util.LoadObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/***
 *
 *
 *
 * User: alok
 * Date: 02/10/22
 *
 */
public class Fundamentals {
    public static final String HELLO_WORLD = "Hello World!";
    WebDriver driver;
    WebElement inputText;
    public Fundamentals(){
        driver= DriverManager.getDriver ();
        inputText=driver.findElement(By.xpath (LoadObject.inputText));
    }
    public void testSendKey(){
        String text = HELLO_WORLD;
        String textValue = text;
        inputText.sendKeys(textValue);
        Assert.assertEquals(inputText.getAttribute("value"),textValue);

        inputText.clear();
        Assert.assertEquals(inputText.getAttribute("value"),"");
    }
}
