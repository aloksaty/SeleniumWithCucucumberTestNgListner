package steps;
import com.alok.aut.pageObjects.EmployeePO;
import com.alok.aut.pageObjects.FundamentalsPO;
import com.alok.aut.pageObjects.RecordApiPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
public class FundamentalsPracticeSteps  {
     FundamentalsPO fundamentalsPO = new FundamentalsPO ();
     RecordApiPO recordApiPO = new RecordApiPO ();
     EmployeePO employeePO = new EmployeePO ();
    @Given("User open the home page for basic Operations")
    public void userOpenTheHomePage ()  {
        fundamentalsPO.getBaseURL ();
    }
    @And("He should be able to open the page")
    public void heShouldBeAbleToOpenThePage () {
        fundamentalsPO.testBaseURL();

    }
    @When("He enter the test {string}")
    public void heEnterTheTest (String textMsg) {
        fundamentalsPO.SendKey(textMsg);
    }
    @Then("He should be able to enter the correct text")
    public void heShouldBeAbleToEnterTheCorrectText () {
        fundamentalsPO.testSendKey ();
    }
    @When("He Checked radio button")
    public void heCheckedRadioButton () {
        fundamentalsPO.checkedRadioButton();
    }
    @Then("Checked radio should be enable")
    public void checkedRadioShouldBeEnable () {
        fundamentalsPO. testCheckedRadioButton ();
    }
    @Given("User search the test area in home page")
    public void userSearchTheTestAreaInHomePage () {
        fundamentalsPO.getInputTextArea ();
        recordApiPO.readRecord();

    }
    @Given("User search radio button in home Page")
    public void userSerachRedioButtonInHomePage () {
        fundamentalsPO.getRadioButton ();
        employeePO.readEmployeeRecords ();
    }
    @Given("User search date picker")
    public void userSearchDatePicker () {
        fundamentalsPO.getDatePicker();
    }
    @When("He click the date picker and select the date")
    public void heClickTheDatePickerAndSelectTheDate () {
        fundamentalsPO. selectDate ();
    }
    @Then("He should be able to select the date")
    public void heShouldBeAbleToSelectTheDate () {
        fundamentalsPO. testSelectedDate ();
    }
}
