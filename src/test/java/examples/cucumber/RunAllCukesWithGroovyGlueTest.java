package examples.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
features={"src/test/resources/cucumber"}, 
tags={"~@ignore"}, 
glue={"src/test/groovy/examples"},
format={ "json:target/results.json",
        "html:target/cucumber",
        "junit:target/cucumber/junit.xml"})
//@Cucumber.Options(format = {"json-pretty:target/cucumber-json-report.json"})
public class RunAllCukesWithGroovyGlueTest {
}

// tags={"@sometag"}, 
/* Results in NPE for some reason : 
 * 'Cannot get property 'fullName' on null object' 
 * at cucumber.examples.datadriven.UserDetailsRepoStub.find(LoginGroovyStepdefs.groovy:33) */