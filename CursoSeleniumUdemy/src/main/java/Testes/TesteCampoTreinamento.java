package Testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("teste");
		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeTextArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\n terceira linha\nUktia linha");
		Assert.assertEquals("teste\n\n terceira linha\nUktia linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void testeCheckBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void testeComboBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		WebElement element= driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// combo.selectByIndex(2);	seleciona pela posição
		// combo.selectByValue("superior");   seleciona pelo atributo value das posições
		 combo.selectByVisibleText("Mestrado"); //seleciona pelo valor visível no combo
		
		 //combo.getFirstSelectedOption() retorna a opção selecionada
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
		
		driver.quit();
	}
	
	@Test
	public void testeVerificaValoresComboBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		WebElement element= driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions(); // retona uma lista com todas as opções do combo
		
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option : options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		
		Assert.assertTrue(encontrou);
		
		driver.quit();
	}
	
	@Test
	public void testeComboBoxMultivalorado() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		WebElement element= driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		
		 combo.selectByVisibleText("Natação"); //seleciona pelo valor visível no combo
		 combo.selectByVisibleText("Corrida");
		 combo.selectByVisibleText("O que eh esporte?");
		 
		 List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		 Assert.assertEquals(3, allSelectedOptions.size());
		 
		 combo.deselectByVisibleText("Corrida");
		 allSelectedOptions = combo.getAllSelectedOptions();
		 Assert.assertEquals(2, allSelectedOptions.size());
		 
		 driver.quit();
	}
	
	@Test
	public void testeBotao() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
	
		driver.quit();
	}
	
	@Test
	@Ignore
	public void deveInteragirComLinks() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.fail(); // quando o teste não está terminado ou insere a anotação @Ignore
		driver.quit();
	}
	
	@Test
	public void encontrandoTextosNaPagina() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// System.getProperty("user.dir") retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/CampoTreinamento/componentes.html");
		
		//driver.findElement(By.className("")
		driver.quit();
	}
	
}
