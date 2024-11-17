package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\harrish.vijay\\eclipse-workspace\\restassured\\src\\test\\resources\\features\\book.feature"},
        glue = {"restapidefinitions"},
        monochrome = true
)


public class TestBook {
}
