package clm_db;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"}, features =
         "src/test/resources/", glue = { "com.clm" })
/*
 * @CucumberOptions(plugin = { "pretty" }, features =
 * "src/test/resources/feature/db.feature", glue = { "com.steps" },
 * tags="@test")
 */
public class RunCucumberTest {
}
