package Testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrame {
	@Test
	public void deveInteragirComPrompt() {  //Prompt é quando o sistema pede alguma informação para o usuário
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.switchTo().frame("frame1");	// envia o foco para o frame
		driver.findElement(By.id("frameButton")).click();
		
		driver.switchTo().defaultContent(); // volta o foco para a tela
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComJanelaComTitulo() {  
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.getWindowHandle();	// retorna a janela com foco
		driver.getWindowHandles();	// retorna todas as janelas gerenciadas pelo driver
		
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]); // pega o popup sem título
		// realiza a açõa
		
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]); // volta para a janela principal
		
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComJanelaSemTitulo() {  
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.switchTo().window("Popup");	// envia o foco para o popup
		// realiza a açõa
		
		driver.close();  // fecha a janela popup
		
		driver.switchTo().window(""); // volta para a janela principal
		
		driver.switchTo().defaultContent(); // volta o foco para a tela
		
		driver.quit();
	}

}
