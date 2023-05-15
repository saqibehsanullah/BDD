package runnerModule;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(tags = "@Regression", features = {"src/test/java/features/"}, glue = {"stepDefinitions"},
        plugin = {})
public class Runner extends AbstractTestNGCucumberTests {

}