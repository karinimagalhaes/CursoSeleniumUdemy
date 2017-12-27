package Testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestAlert {
	
	@Test
	public void deveInteragirComAlertSimples() {  //Alert simples possui somente o bot�o de confirma��o
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		Alert alert  = driver.switchTo().alert();  // altera o foco para o alert
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();		// clica no bot�o ok
		
		driver.quit();
	}
	
	@Test
	public void alertConfirme() {  //Alert simples possui somente o bot�o de confirma��o
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alert  = driver.switchTo().alert();  // altera o foco para o alert
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();		// clica no bot�o ok
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void alertNegado() {  //Alert simples possui somente o bot�o de confirma��o
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alert  = driver.switchTo().alert();  // altera o foco para o alert
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();		// clica no bot�o ok
		Assert.assertEquals("Negado", alert.getText());
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComPrompt() {  //Prompt � quando o sistema pede alguma informa��o para o usu�rio
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alert  = driver.switchTo().alert();  // altera o foco para o alert
		Assert.assertEquals("Digite um n�mero", alert.getText());
		alert.sendKeys("12");    // Escreve no pronpk
		alert.accept();		// clica no bot�o ok
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		
		driver.quit();
	}
}
