package myRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/ProductsPageVerification.feature"},
        glue="stepDefinitions",
        dryRun=false,
        tags="@all",
        plugin={"pretty", "html:test-output/report.html"}
)
public class TestRunner {
}
