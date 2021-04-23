package br.com.tonhao.steps;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ContasSteps {

	static {
		System.setProperty("webdriver.chrome.driver", "/home/tonhao/developer/selenium-drivers/chromedriver");
	}
	private WebDriver driver;

	@Dado("que estou acessando a aplicação")
	public void que_estou_acessando_a_aplicação() {
		driver.get("https://seubarriga.wcaquino.me/");
	}

	@Quando("informo o usuário {string}")
	public void informo_o_usuário(String string) {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	@Quando("a senha {string}")
	public void a_senha(String string) {
		driver.findElement(By.id("senha")).sendKeys(string);
	}
	
	@Quando("seleciono entrar")
	public void seleciono_entrar() {
		driver.findElement(By.tagName("button")).click();
	}
	
	@Então("visualizo a página inicial")
	public void visualizo_a_página_inicial() {
		String msgDiv = driver.findElement(By.xpath("//div[@class='alert alert-success']"))
		.getText();
		Assert.assertEquals("Bem vindo, ANTONIO EVALAZIO SFALCINI NETO!", msgDiv);
	}

	@Quando("seleciono Contas")
	public void seleciono_contas() {
		driver.findElement(By.linkText("Contas")).click();
	}
	@Quando("seleciono Adicionar")
	public void seleciono_adicionar() {
		driver.findElement(By.linkText("Adicionar")).click();
	}
	@Quando("informo a conta {string}")
	public void informo_a_conta(String string) {
		driver.findElement(By.id("nome")).sendKeys(string);
	}
	@Quando("seleciono Salvar")
	public void seleciono_salvar() {
		driver.findElement(By.tagName("button")).click();
	}
	@Então("a conta é inserida com sucesso")
	public void a_conta_é_inserida_com_sucesso() {
		String msgDiv = driver.findElement(By.xpath("//div[@class='alert alert-success']"))
				.getText();
		Assert.assertEquals("Conta adicionada com sucesso!", msgDiv);
	}

	@Então("sou notificado que o nome da conta é obrigatório")
	public void sou_notificado_que_o_nome_da_conta_é_obrigatório() {
		String msgDiv = driver.findElement(By.xpath("//div[@class='alert alert-danger']"))
				.getText();
		Assert.assertEquals("Informe o nome da conta", msgDiv);
	}
	
	@Então("sou notificado que já existe uma conta com esse nome")
	public void sou_notificado_que_já_existe_uma_conta_com_esse_nome() {
		String msgDiv = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Já existe uma conta com esse nome!", msgDiv);
	}
	
	@Então("recebo a mensagem {string}")
	public void recebo_a_mensagem(String string) {
		String msgDiv = driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
		
		Assert.assertEquals(string, msgDiv);
	}
	
	@Before(order = 0)
	public void before() {
		System.out.println(">> primeiro before");
	}
	
	@Before(order = 10, value = "@funcionais")
	public void abrir_navegador() {
		System.out.println(">> abrindo driver");
		driver = new ChromeDriver();
	}
	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) throws IOException {
		System.out.println(">> pegando captura de tela.");
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		LocalDateTime ldt = LocalDateTime.now();
		String instant = ldt.format(DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss"));
		FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getName()+":"+cenario.getLine()+"_"+instant+".jpg"));
	}
	
	
	@After(order = 0, value = "@funcionais")
	public void fechar_navegador() {
		System.out.println(">> fechando navegador.");
		driver.quit();
	}
	
	@Dado("que desejo adicionar uma conta")
	public void que_desejo_adicionar_uma_conta() {
		abrir_navegador();
		que_estou_acessando_a_aplicação();
		informo_o_usuário("tonhaosfalcini@gmail.com");
		a_senha("123456");
		seleciono_entrar();
		seleciono_contas();
		seleciono_adicionar();
	}
	
	@Quando("adiciono a conta {string}")
	public void adiciono_a_conta(String string) {
		informo_a_conta(string);
		seleciono_salvar();
	}
}

