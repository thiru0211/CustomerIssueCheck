package allPages;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerGroup extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1,ele2,ele3,ele4,ele5;

	@BeforeMethod
	public void setUp() throws IOException{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("http://192.168.1.36:90/#/auth");
		File file=new File("C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOnee\\Data.properties");
		FileInputStream FIS=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(FIS);	
	}

		@AfterMethod
		public void tearDown() throws IOException, InterruptedException{
			Thread.sleep(3000);
			driver.quit();
}
	
	@Test(priority = 1,retryAnalyzer = ReRunFailedTestCase.class)
	public void CustomerGroupBtnClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath(CusGrpBtn)).click();
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSrchName=PropertyFileReader.propertymap.get("CusSrchName");
		String CusStsEnbl=PropertyFileReader.propertymap.get("CusStsEnbl");
		String CusStsDsbl=PropertyFileReader.propertymap.get("CusStsDsbl");
		driver.findElement(By.xpath(CusSrchBox)).sendKeys(CusSrchName);
		ele1 = driver.findElement(By.name(CusStsDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusStsEnbl);
		Thread.sleep(1000);
		sel.selectByVisibleText(CusStsDsbl);
		Thread.sleep(1000);
		sel.selectByVisibleText(CusStsEnbl);
	}
	
	
	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSelInstlrName=PropertyFileReader.propertymap.get("CusSelInstlrName");
		driver.findElement(By.xpath(CusAddBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(CusAddBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		ele1 = driver.findElement(By.id(CusSelInstlrDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusSelInstlrName);
		driver.findElement(By.name(CusGrpName)).sendKeys(CusGrpName);
		driver.findElement(By.name(CusGrpStsEnbl)).click();
		driver.findElement(By.id(CusGrpClrBtn)).click();
		
	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSelInstlrName=PropertyFileReader.propertymap.get("CusSelInstlrName");
		driver.findElement(By.xpath(CusAddBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(CusAddBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		ele1 = driver.findElement(By.id(CusSelInstlrDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusSelInstlrName);
		driver.findElement(By.name(CusGrpName)).sendKeys(CusGrpName);
		driver.findElement(By.name(CusGrpStsEnbl)).click();
		driver.findElement(By.xpath(CusGrpSavBtn)).click();
		
	}
	
	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		driver.findElement(By.xpath(CusAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusGrpCloseBtn)).click();
		driver.findElement(By.xpath(CusAddBtn)).click();	
	}
	
	
	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		Thread.sleep(2000);
		String CusSrchName=PropertyFileReader.propertymap.get("CusSrchName");
		driver.findElement(By.xpath(CusSrchBox)).sendKeys(CusSrchName);
		driver.findElement(By.xpath(CusGrpEditBtn)).click();
		driver.findElement(By.xpath(CusGrpEditStsDsbl)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(CusGrpEditClrBtn)).click();			
	}
	
	
	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		Thread.sleep(2000);
		String CusSrchName=PropertyFileReader.propertymap.get("CusSrchName");
		driver.findElement(By.xpath(CusSrchBox)).sendKeys(CusSrchName);
		driver.findElement(By.xpath(CusGrpEditBtn)).click();
		driver.findElement(By.xpath(CusGrpEditStsDsbl)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusGrpEditUpdBtn)).click();				
	}
	
}
