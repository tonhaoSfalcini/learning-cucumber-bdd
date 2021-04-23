package br.com.tonhao.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.com.tonhao.steps",
		tags = "@funcionais",
		plugin = {"pretty", "html:target/report.html", "json:target/report.json"}, 
		monochrome = true, 
		snippets = SnippetType.UNDERSCORE, 
		dryRun = false,
		publish = true)
public class RunnerFuncionalTest {

	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "/home/tonhao/developer/selenium-drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		System.out.println("Logar antes de tudo");
		driver.findElement(By.id("email")).sendKeys("tonhaosfalcini@gmail.com");
		driver.findElement(By.id("senha")).sendKeys("123456");
		System.out.println("Resetar o bd");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
		System.out.println("fechar o navegador");
	}
	
	
}
