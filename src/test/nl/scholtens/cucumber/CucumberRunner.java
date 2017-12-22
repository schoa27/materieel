package nl.scholtens.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "html:target/material.html",
                 features = "src/test/resources/features",
                 glue = "nl.scholtens.cucumber.stepfefinitions",
                 snippets = SnippetType.CAMELCASE)
public class CucumberRunner {
}
