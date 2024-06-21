package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions(
					//features= {".//Features/"}
					features= {".//Features/TombolaLogin.feature"},
					//features= {".//Features/Login.feature",".//Features/xyz.feature"},
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html"},
					dryRun=false
					
				)
public class TestRunner {

}
