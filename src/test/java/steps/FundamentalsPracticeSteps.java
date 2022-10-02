package steps;
import com.alok.aut.pageObjects.FundamentalsPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
public class FundamentalsPracticeSteps extends FundamentalsPO {
    @Given("User open the home page for basic Operations")
    public void userOpenTheHomePage ()  {
        getBaseURL ();
    }
    @And("He should be able to open the page")
    public void heShouldBeAbleToOpenThePage () {
         testBaseURL();
    }
    @When("He enter the test {string}")
    public void heEnterTheTest (String textMsg) {
        SendKey(textMsg);
    }
    @Then("He should be able to enter the correct text")
    public void heShouldBeAbleToEnterTheCorrectText () {
        testSendKey ();
    }
    @When("He Checked radio button")
    public void heCheckedRadioButton () {
        checkedRadioButton();
    }
    @Then("Checked radio should be enable")
    public void checkedRadioShouldBeEnable () {
        testCheckedRadioButton ();
    }
    @Given("User search the test area in home page")
    public void userSearchTheTestAreaInHomePage () {
        getInputTextArea ();
    }
    @Given("User search radio button in home Page")
    public void userSerachRedioButtonInHomePage () {
        getRadioButton ();
    }
    @Given("User search date picker")
    public void userSearchDatePicker () {
        getDatePicker();
    }
    @When("He click the date picker and select the date")
    public void heClickTheDatePickerAndSelectTheDate () {
        selectDate ();
    }
    @Then("He should be able to select the date")
    public void heShouldBeAbleToSelectTheDate () {
        testSelectedDate ();
    }
}
