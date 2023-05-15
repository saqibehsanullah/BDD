package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UnionBankEMICalculatorStepDefinition {
    WebDriver driver;
    @Given("I launch the application.")
    public void i_launch_the_application() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote -allow-origins=x");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.unionbankofindia.co.in/english/loan-emi-calculator.aspx");
        driver.manage().window().maximize();
    }
    @And("I enter Amount as {string},rate as {string} and tenure as {string}")
    public void i_enter_amount_as_rate_as_and_tenure_as(String amount, String rate, String tenure) {
        // Write code here that turns the phrase above into concrete actions
        // Enter Loan Amount
        driver.findElement(By.id("loanamount")).sendKeys(amount);

        // Enter Interest rate

        driver.findElement(By.name("rate")).sendKeys(rate);
        // Enter tenure
        driver.findElement(By.name("pmonths")).sendKeys(tenure);


    }
    @Then("I click on calculate Button")
    public void i_click_on_calculate_button() {
        // Write code here that turns the phrase above into concrete actions

        //Click on calculate button
        driver.findElement(By.name("Button1")).click();
    }
    @Then("I verify the EMI is {string}")
    public void i_verify_the_emi_is(String expectedEMI) {
        // Write code here that turns the phrase above into concrete actions
        //verify - if Emi matching,print Pass else Fail
        String output = driver.findElement(By.id("EMI")).getAttribute("value");
        System.out.println(output);
        if(output.equals(expectedEMI)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }
    @And("Close the application")
    public void close_the_application() {
        // Write code here that turns the phrase above into concrete actions
        driver.close();
    }

}
