package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\harrish.vijay\\eclipse-workspace\\demo-project\\src\\test\\feature\\amazonfeatures\\amazon.feature"},
        glue = {"amazon"},
        monochrome = true
)


public class AmazonTestRunner {

}
