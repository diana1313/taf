import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/cucumber/scenarios",
        glue = {"steps"},
        tags = {"not @Ignore"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "pretty"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}

