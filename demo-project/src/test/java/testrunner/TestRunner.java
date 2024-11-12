package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        //add the feature file
        features = {"C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\src\\test\\feature\\login.feature"},
        glue = {"stepdefinitions"},//add package of the step definitions package
        monochrome = true //builtin formatter
)


public class TestRunner {
}
