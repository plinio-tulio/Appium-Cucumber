package br.com.automacao.runners;

import org.junit.runner.RunWith;

import br.com.automacao.appium.BaseTeste;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/produto.feature",
		glue = "br.com.automacao.steps",
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/reports/report.html"},
		monochrome = true,
	    tags = {"@appium"},
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class ProdutoRunner extends BaseTeste {

}