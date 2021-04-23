package br.com.tonhao.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.com.tonhao.steps",
		tags = "@unitarios",
		plugin = {"pretty", "html:target/report.html", "json:target/report.json"}, 
		monochrome = true, 
		snippets = SnippetType.UNDERSCORE, 
		dryRun = false,
		publish = true)
public class RunnerTest {

	
}
