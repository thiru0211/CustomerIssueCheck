package allPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerList extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1,ele2,ele3,ele4,ele5,ele6;

	@BeforeTest
	public void setUp() throws IOException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
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

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CustomerListClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CustomerBtn)).click();
		driver.findElement(By.xpath(CusListBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ACHFormClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CustomerBtn)).click();
		driver.findElement(By.xpath(ACHFormBtn)).click();
	}


	@Test(priority = 1,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1=driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
	}

	@Test(priority = 2)
	public void TC02() throws InterruptedException {
		CustomerListClick();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CusListAddBtn)).click();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath(CusAddActBtn));
		Actions act1=new Actions(driver);
		act1.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CusListActSavBtn)).click();		
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CusAddDetailsFull() throws InterruptedException {
		CustomerListClick();
		PropertyFileReader.propertyRead();
		String CustmrId=PropertyFileReader.propertymap.get("CustmrId");
		String CustmrName=PropertyFileReader.propertymap.get("CustmrName");
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		String CustPTODate=PropertyFileReader.propertymap.get("CustPTODate");
		String CustCrdScre=PropertyFileReader.propertymap.get("CustCrdScre");
		String CustPrjSts=PropertyFileReader.propertymap.get("CustPrjSts");
		String CustMonPay=PropertyFileReader.propertymap.get("CustMonPay");
		String CustTotYrs=PropertyFileReader.propertymap.get("CustTotYrs");
		String CustEscal=PropertyFileReader.propertymap.get("CustEscal");
		String CustTotConAmt=PropertyFileReader.propertymap.get("CustTotConAmt");
		String CustPhone=PropertyFileReader.propertymap.get("CustPhone");
		String CustEmail=PropertyFileReader.propertymap.get("CustEmail");
		String CustCntryDD=PropertyFileReader.propertymap.get("CustCntryDD");
		String CustStDD=PropertyFileReader.propertymap.get("CustStDD");
		String CustAdd1=PropertyFileReader.propertymap.get("CustAdd1");
		String CustAdd2=PropertyFileReader.propertymap.get("CustAdd2");
		String CustCity=PropertyFileReader.propertymap.get("CustCity");
		String CustZipCde=PropertyFileReader.propertymap.get("CustZipCde");
		String CustFinancing=PropertyFileReader.propertymap.get("CustFinancing");
		String CustProjCost=PropertyFileReader.propertymap.get("CustProjCost");
		String CustSysCost=PropertyFileReader.propertymap.get("CustSysCost");
		String CustSysSize=PropertyFileReader.propertymap.get("CustSysSize");
		String CustProd=PropertyFileReader.propertymap.get("CustProd");
		String CustPipLn=PropertyFileReader.propertymap.get("CustPipLn");
		String CustLeadPipLn=PropertyFileReader.propertymap.get("CustLeadPipLn");
		String CustPanels=PropertyFileReader.propertymap.get("CustPanels");
		String CustBatt=PropertyFileReader.propertymap.get("CustBatt");
		String CustWattPerPan=PropertyFileReader.propertymap.get("CustWattPerPan");
		String CustInvBrnd=PropertyFileReader.propertymap.get("CustInvBrnd");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		driver.findElement(By.name(CustID)).sendKeys(CustmrId);
		driver.findElement(By.name(CustName)).sendKeys(CustmrName);

		ele1=driver.findElement(By.name(CusInstDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);

		ele2=driver.findElement(By.name(CusPort));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(CustPort);

		driver.findElement(By.name(CusPTODate)).sendKeys(CustPTODate);
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.xpath(CusTypLTF)).click();
		driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone);
		driver.findElement(By.name(CusEmail)).sendKeys(CustEmail);

		ele3=driver.findElement(By.name(CusCntryDD));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(CustCntryDD);

		ele4=driver.findElement(By.id(CusStDD));
		Select sel4=new Select(ele4);
		sel4.selectByVisibleText(CustStDD);

		driver.findElement(By.name(CusAdd1)).sendKeys(CustAdd1);
		driver.findElement(By.name(CusAdd2)).sendKeys(CustAdd2);
		driver.findElement(By.name(CusCity)).sendKeys(CustCity);
		driver.findElement(By.name(CusZipCde)).sendKeys(CustZipCde);
		driver.findElement(By.name(CusFinancing)).sendKeys(CustFinancing);
		driver.findElement(By.name(CusProjCost)).sendKeys(CustProjCost);
		driver.findElement(By.name(CusSysCost)).sendKeys(CustSysCost);
		driver.findElement(By.name(CusSysSize)).sendKeys(CustSysSize);
		driver.findElement(By.name(CusProd)).sendKeys(CustProd);
		driver.findElement(By.name(CusPipLn)).sendKeys(CustPipLn);
		driver.findElement(By.name(CusLeadPipLn)).sendKeys(CustLeadPipLn);
		driver.findElement(By.name(CusPanels)).sendKeys(CustPanels);
		driver.findElement(By.name(CusBatt)).sendKeys(CustBatt);
		driver.findElement(By.name(CusWattPerPan)).sendKeys(CustWattPerPan);
		driver.findElement(By.name(CusInvBrnd)).sendKeys(CustInvBrnd);
	}

	@Test(priority=3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		CusAddDetailsFull();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusAddClrBtn)).click();
	}


	@Test(priority=4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		CusAddDetailsFull();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		
	}

	@Test(priority=5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException {
		CustomerListClick();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath(CusAddActBtn));
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CussAddActBackBtn)).click();		
	}


	@Test(priority=6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException {
		CustomerListClick();
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		ele3 = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div"));
		if(ele3.isDisplayed()) {
			System.out.println("Mandatory message is showing");
		}
		else {
			System.out.println("Message is not showing");
		}
	}

	@Test(priority=7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException {
		CustomerListClick();
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustAddPortName=PropertyFileReader.propertymap.get("CustAddPortName");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CusPortAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(CusAddPortName)).sendKeys(CustAddPortName);
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath(CusAddPortClrBtn));
		act.click().build().perform();
		ele2.click();
	}

	@Test(priority=8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException {
		CustomerListClick();
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustAddPortName=PropertyFileReader.propertymap.get("CustAddPortName");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CusPortAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(CusAddPortName)).sendKeys(CustAddPortName);
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath(CusAddPortSavBtn));
		ele2.click();		
	}

	@Test(priority=9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		CustomerListClick();
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustAddPortName=PropertyFileReader.propertymap.get("CustAddPortName");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CusPortAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(CusAddPortName)).sendKeys(CustAddPortName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusAddPortClsBtn)).click();
	}

	@Test(priority=10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		CustomerListClick();
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		String ModifCustPort=PropertyFileReader.propertymap.get("ModifCustPort");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		Thread.sleep(3000);
		ele2=driver.findElement(By.name(CusPort));
		Select sel1=new Select(ele2);
		sel1.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CusAddPortEditBtn)).click();
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(CusAddPortName));
		ele3.sendKeys("\b"+"a");
		driver.findElement(By.xpath(CusAddPortSavBtn)).click();
	}
	@Test(priority=11,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		CustomerListClick();
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		Thread.sleep(3000);
		ele2=driver.findElement(By.name(CusPort));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText(CustPort);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CusAddPortEditBtn)).click();
		driver.findElement(By.xpath(CusAddPortClsBtn)).click();		
	}

	@Test(priority=12,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException {
		CusAddDetailsFull();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
	}

	@Test(priority=13,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		CustomerListClick();
		PropertyFileReader.propertyRead();
		String CustmrId=PropertyFileReader.propertymap.get("CustmrId");
		String CustmrName=PropertyFileReader.propertymap.get("CustmrName");
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		String CustPTODate=PropertyFileReader.propertymap.get("CustPTODate");
		String CustCrdScre=PropertyFileReader.propertymap.get("CustCrdScre");
		String CustPrjSts=PropertyFileReader.propertymap.get("CustPrjSts");
		String CustTotConAmt=PropertyFileReader.propertymap.get("CustTotConAmt");
		String CustPhone=PropertyFileReader.propertymap.get("CustPhone");
		String CustEmail=PropertyFileReader.propertymap.get("CustEmail");
		String CustCntryDD=PropertyFileReader.propertymap.get("CustCntryDD");
		String CustStDD=PropertyFileReader.propertymap.get("CustStDD");
		String CustAdd1=PropertyFileReader.propertymap.get("CustAdd1");
		String CustAdd2=PropertyFileReader.propertymap.get("CustAdd2");
		String CustCity=PropertyFileReader.propertymap.get("CustCity");
		String CustZipCde=PropertyFileReader.propertymap.get("CustZipCde");
		String CustFinancing=PropertyFileReader.propertymap.get("CustFinancing");
		String CustProjCost=PropertyFileReader.propertymap.get("CustProjCost");
		String CustSysCost=PropertyFileReader.propertymap.get("CustSysCost");
		String CustSysSize=PropertyFileReader.propertymap.get("CustSysSize");
		String CustProd=PropertyFileReader.propertymap.get("CustProd");
		String CustPipLn=PropertyFileReader.propertymap.get("CustPipLn");
		String CustLeadPipLn=PropertyFileReader.propertymap.get("CustLeadPipLn");
		String CustPanels=PropertyFileReader.propertymap.get("CustPanels");
		String CustBatt=PropertyFileReader.propertymap.get("CustBatt");
		String CustWattPerPan=PropertyFileReader.propertymap.get("CustWattPerPan");
		String CustInvBrnd=PropertyFileReader.propertymap.get("CustInvBrnd");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		driver.findElement(By.name(CustID)).sendKeys(CustmrId);
		driver.findElement(By.name(CustName)).sendKeys(CustmrName);

		ele1=driver.findElement(By.name(CusInstDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);

		ele2=driver.findElement(By.name(CusPort));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(CustPort);

		driver.findElement(By.name(CusPTODate)).sendKeys(CustPTODate);
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.xpath(CusTypPre)).click();
		//driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		//driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		//driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone);
		driver.findElement(By.name(CusEmail)).sendKeys(CustEmail);

		ele3=driver.findElement(By.name(CusCntryDD));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(CustCntryDD);

		ele4=driver.findElement(By.id(CusStDD));
		Select sel4=new Select(ele4);
		sel4.selectByVisibleText(CustStDD);

		driver.findElement(By.name(CusAdd1)).sendKeys(CustAdd1);
		driver.findElement(By.name(CusAdd2)).sendKeys(CustAdd2);
		driver.findElement(By.name(CusCity)).sendKeys(CustCity);
		driver.findElement(By.name(CusZipCde)).sendKeys(CustZipCde);
		driver.findElement(By.name(CusFinancing)).sendKeys(CustFinancing);
		driver.findElement(By.name(CusProjCost)).sendKeys(CustProjCost);
		driver.findElement(By.name(CusSysCost)).sendKeys(CustSysCost);
		driver.findElement(By.name(CusSysSize)).sendKeys(CustSysSize);
		driver.findElement(By.name(CusProd)).sendKeys(CustProd);
		driver.findElement(By.name(CusPipLn)).sendKeys(CustPipLn);
		driver.findElement(By.name(CusLeadPipLn)).sendKeys(CustLeadPipLn);
		driver.findElement(By.name(CusPanels)).sendKeys(CustPanels);
		driver.findElement(By.name(CusBatt)).sendKeys(CustBatt);
		driver.findElement(By.name(CusWattPerPan)).sendKeys(CustWattPerPan);
		driver.findElement(By.name(CusInvBrnd)).sendKeys(CustInvBrnd);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		Thread.sleep(1000);
		ele5=driver.findElement(By.xpath("(//div[text()='Duplicate ID, Given Id already exists'])"));
		if(ele5.isDisplayed()) {
			ele6=driver.findElement(By.name(CustID));
			ele6.sendKeys(CustmrId + "1");
			Thread.sleep(3000);
			driver.findElement(By.xpath(CusAddSavBtn)).click();
		}
		else {
			System.out.println("No duplicate message is shown");
		}
	}

	@Test(priority=14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		CustomerListClick();
		PropertyFileReader.propertyRead();
		String CustmrId=PropertyFileReader.propertymap.get("CustmrId");
		String CustmrName=PropertyFileReader.propertymap.get("CustmrName");
		String CustInstDD=PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		String CustPTODate=PropertyFileReader.propertymap.get("CustPTODate");
		String CustCrdScre=PropertyFileReader.propertymap.get("CustCrdScre");
		String CustPrjSts=PropertyFileReader.propertymap.get("CustPrjSts");
		String CustMonPay=PropertyFileReader.propertymap.get("CustMonPay");
		String CustTotYrs=PropertyFileReader.propertymap.get("CustTotYrs");
		String CustEscal=PropertyFileReader.propertymap.get("CustEscal");
		String CustTotConAmt=PropertyFileReader.propertymap.get("CustTotConAmt");
		String CustPhone=PropertyFileReader.propertymap.get("CustPhone");
		String CustEmail=PropertyFileReader.propertymap.get("CustEmail");
		String CustCntryDD=PropertyFileReader.propertymap.get("CustCntryDD");
		String CustStDD=PropertyFileReader.propertymap.get("CustStDD");
		String CustAdd1=PropertyFileReader.propertymap.get("CustAdd1");
		String CustAdd2=PropertyFileReader.propertymap.get("CustAdd2");
		String CustCity=PropertyFileReader.propertymap.get("CustCity");
		String CustZipCde=PropertyFileReader.propertymap.get("CustZipCde");
		String CustFinancing=PropertyFileReader.propertymap.get("CustFinancing");
		String CustProjCost=PropertyFileReader.propertymap.get("CustProjCost");
		String CustSysCost=PropertyFileReader.propertymap.get("CustSysCost");
		String CustSysSize=PropertyFileReader.propertymap.get("CustSysSize");
		String CustProd=PropertyFileReader.propertymap.get("CustProd");
		String CustPipLn=PropertyFileReader.propertymap.get("CustPipLn");
		String CustLeadPipLn=PropertyFileReader.propertymap.get("CustLeadPipLn");
		String CustPanels=PropertyFileReader.propertymap.get("CustPanels");
		String CustBatt=PropertyFileReader.propertymap.get("CustBatt");
		String CustWattPerPan=PropertyFileReader.propertymap.get("CustWattPerPan");
		String CustInvBrnd=PropertyFileReader.propertymap.get("CustInvBrnd");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		driver.findElement(By.name(CustID)).sendKeys(CustmrId);
		driver.findElement(By.name(CustName)).sendKeys(CustmrName);

		ele1=driver.findElement(By.name(CusInstDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);

		ele2=driver.findElement(By.name(CusPort));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(CustPort);

		driver.findElement(By.name(CusPTODate)).sendKeys(CustPTODate);
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.name(CusTypMP)).click();
		driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone);
		driver.findElement(By.name(CusEmail)).sendKeys(CustEmail);

		ele3=driver.findElement(By.name(CusCntryDD));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(CustCntryDD);

		ele4=driver.findElement(By.id(CusStDD));
		Select sel4=new Select(ele4);
		sel4.selectByVisibleText(CustStDD);

		driver.findElement(By.name(CusAdd1)).sendKeys(CustAdd1);
		driver.findElement(By.name(CusAdd2)).sendKeys(CustAdd2);
		driver.findElement(By.name(CusCity)).sendKeys(CustCity);
		driver.findElement(By.name(CusZipCde)).sendKeys(CustZipCde);
		driver.findElement(By.name(CusFinancing)).sendKeys(CustFinancing);
		driver.findElement(By.name(CusProjCost)).sendKeys(CustProjCost);
		driver.findElement(By.name(CusSysCost)).sendKeys(CustSysCost);
		driver.findElement(By.name(CusSysSize)).sendKeys(CustSysSize);
		driver.findElement(By.name(CusProd)).sendKeys(CustProd);
		driver.findElement(By.name(CusPipLn)).sendKeys(CustPipLn);
		driver.findElement(By.name(CusLeadPipLn)).sendKeys(CustLeadPipLn);
		driver.findElement(By.name(CusPanels)).sendKeys(CustPanels);
		driver.findElement(By.name(CusBatt)).sendKeys(CustBatt);
		driver.findElement(By.name(CusWattPerPan)).sendKeys(CustWattPerPan);
		driver.findElement(By.name(CusInvBrnd)).sendKeys(CustInvBrnd);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		Thread.sleep(1000);
		ele5=driver.findElement(By.xpath("(//div[text()='Duplicate ID, Given Id already exists'])"));
		if(ele5.isDisplayed()) {
			ele6=driver.findElement(By.name(CustID));
			ele6.sendKeys(CustmrId + "1");
			Thread.sleep(3000);
			driver.findElement(By.xpath(CusAddSavBtn)).click();
		}
		else {
			System.out.println("No duplicate message is shown");
		}
	}

	@Test(priority=15,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		CustomerListClick();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath(CusAddActBtn));
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CusActBckbtn)).click();		
	}

	@Test(priority=16,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		driver.findElement(By.xpath(CusAddNotesBtn)).click();
		driver.findElement(By.xpath(CusNotesSavBtn)).click();		
	}

	@Test(priority=18,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//	driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		driver.findElement(By.xpath(CusAddNotesBtn)).click();
		driver.findElement(By.xpath(CusNotesClsBtn)).click();	
	}

	@Test(priority=19,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		String CusNotes=PropertyFileReader.propertymap.get("CusNotes");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//	driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		driver.findElement(By.xpath(CusAddNotesBtn)).click();
		ele1=driver.findElement(By.xpath(CusNotesBtn));
		ele1.click();
		ele1.sendKeys(CusNotes);
		driver.findElement(By.xpath(CusNotesSavBtn)).click();
	}

	@Test(priority=20,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditClrBtn)).click();
	}

	@Test(priority=21,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		String CustCity=PropertyFileReader.propertymap.get("CustCity");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);

		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ele2 = driver.findElement(By.name(CusCity));
		js.executeScript("arguments[0].scrollIntoView(true);", ele2);
		Thread.sleep(2000);
		String InitialName = ele2.getAttribute("value");
		System.out.println(InitialName);
		for(int i=0;i<InitialName.length();i++) {
			ele2.sendKeys("\b"); // "/b" means give backspace to the text box
		}

		ele2.sendKeys(CustCity);
		driver.findElement(By.xpath(CusEditUpdBtn)).click();
	}

	@Test(priority=22,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		driver.findElement(By.xpath(CusEditBckBtn)).click();		
	}

	@Test(priority=23,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath(CusEditInstAddBtn)).click();
		driver.findElement(By.xpath(CusEditPortSavBtn)).click();	
	}

	@Test(priority=24,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath(CusEditInstAddBtn)).click();
		driver.findElement(By.name(CusEditPortName)).sendKeys(CustPort);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortClrBtn)).click();	
	}

	@Test(priority=25,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException {
		TC24();
		String CustPort=PropertyFileReader.propertymap.get("CustPort");
		driver.findElement(By.name(CusEditPortName)).sendKeys(CustPort);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortSavBtn)).click();	
	}

	@Test(priority=26,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException {
		TC24();
		driver.findElement(By.xpath(CusEditPortClseBtn)).click();
	}

	@Test(priority=27,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath(CusEditPortEditBtn)).click();
		driver.findElement(By.xpath(CusEditPortSavBtn)).click();	
	}

	@Test(priority=28,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath(CusEditPortEditBtn)).click();
		driver.findElement(By.xpath(CusEditPortClseBtn)).click();	
	}

	@Test(priority=29,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditLTFBtn)).click();
		Thread.sleep(2000);
		WebElement ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		Actions act1=new Actions(driver);
		Thread.sleep(2000);
		act1.click().build().perform();
		Thread.sleep(2000);
		ele2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditUpdBtn2)).click();
	}

	@Test(priority=30,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/span[1]/input")).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(CusEditUpdBtn2)).click();
	}

	@Test(priority=31,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/span[2]/input")).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(CusEditUpdBtn2)).click();
	}

	@Test(priority=32,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC32() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/span[2]/input")).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		driver.findElement(By.xpath(CusEditBckBtn2)).click();
	}

	@Test(priority=71,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By.name(CustName)).sendKeys(CusListName+"a");
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(CusEditActBtn1));
		Actions act1=new Actions(driver);
		act1.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CusEditUpdBtn1)).click();

	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CusEditActBtn() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		Thread.sleep(2000);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();		
	}



	@Test (priority=33,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditPaySchBtn)).click();
		driver.findElement(By.xpath(CusEditPayUpdBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActPayBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele2.click();
		driver.findElement(By.xpath(CusEditActPayBckBtn)).click();		
	}

	@Test(priority=34,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC35() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditActPayMergeBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActPayBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele2.click();
		driver.findElement(By.xpath(CusEditActMergeBckBtn)).click();
	}

	@Test(priority=35,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC36() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditActPayMergeBtn)).click();
		driver.findElement(By.xpath(CusEditMrgeAgreBtn)).click();
		driver.findElement(By.xpath(CusEditMrgeBtn)).click();
		ele1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div/span"));
		if(ele1.isDisplayed()) {
			System.out.println("Select customer tab show alert toast");
		}
		else {
			System.out.println("Select customer tab doesnot show alert message");
		}
	}

	@Test(priority=36,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC37() throws InterruptedException {
		CusEditActBtn();
		String CustChoseToMerge=PropertyFileReader.propertymap.get("CustChoseToMerge");
		driver.findElement(By.xpath(CusEditActPayMergeBtn)).click();
		ele1=driver.findElement(By.xpath(CusEditChoseMrgDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustChoseToMerge);
		driver.findElement(By.xpath(CusEditMrgeAgreBtn)).click();
		driver.findElement(By.xpath(CusEditMrgeBtn)).click();
	}


	@Test(priority=37,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC38() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditViewRcdPaymtsBtn)).click();
		driver.findElement(By.xpath(CusEditRcdPymntPrntbtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditRcdPymtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele1.click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/a[7]/div/div/span")).click();
	}

	@Test(priority=38,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC39() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditMntlyPymnBtn)).click();
		driver.findElement(By.xpath(CusEditMntlyPymnSavBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div"));
		if(ele1.isDisplayed()) {
			System.out.println("Page shows alert message");
		}
		else {
			System.out.println("Page doesnot show alert message");
		}
	}


	@Test(priority=39,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC40() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditMntlyPymnBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditMnthlyPymnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele1.click();
		driver.findElement(By.xpath(CusEditMnthlyPymnBckBtn)).click();
	}

	@Test(priority=40,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC41() throws InterruptedException {
		CusEditActBtn();
		String CustMonltyAmt=PropertyFileReader.propertymap.get("CustMonltyAmt");
		String CustMntlPayReason=PropertyFileReader.propertymap.get("CustMntlPayReason");
		driver.findElement(By.xpath(CusEditMntlyPymnBtn)).click();
		driver.findElement(By.name(CusEditMntlyPayTab)).sendKeys(CustMonltyAmt);
		//		Scanner scanner = new Scanner(System.in);
		//		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		//		System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		//		String EffectiveDromDate= scanner.nextLine();
		driver.findElement(By.xpath(CusEditMntlyEffFrom)).sendKeys("Feb/2023");
		driver.findElement(By.name(CusEditMntlyRsonTab)).sendKeys(CustMntlPayReason);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditMntlyPymnSavBtn)).click();
	}

	@Test(priority=41,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC42() throws InterruptedException {
		CusEditActBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditCRMMonitBtn)).click();
		driver.findElement(By.xpath(CusEditCRMUpdBtn)).click();
		Thread.sleep(2000);
		//name in CRM error toast check
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/form/div/div[3]/div[2]/div[2]/div"));
		//production escalation error toast check
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/form/div/div[3]/div[3]/div[2]/div"));
		if(ele1.isDisplayed())
		{
			System.out.println("Error toast appears in Name in CRM field");
			if(ele2.isDisplayed()) {
				System.out.println("Error toast appears in Production escalation field");
			}
			else {
				System.out.println("No error is appears in the page");
			}
		}	
	}

	@Test(priority=42,retryAnalyzer = ReRunFailedTestCase.class, description = "This function is not working properly in the webpage")
	public void TC43() throws InterruptedException {
		CusEditActBtn();
		String CustCRMDD=PropertyFileReader.propertymap.get("CustCRMDD");
		String CustEditCRMNameDD=PropertyFileReader.propertymap.get("CustEditCRMNameDD");
		String CustEditProdEsc=PropertyFileReader.propertymap.get("CustEditProdEsc");
		String CustEditFrstYrProd=PropertyFileReader.propertymap.get("CustEditFrstYrProd");
		driver.findElement(By.xpath(CusEditCRMMonitBtn)).click();


		ele1=driver.findElement(By.id(CusEditCRMDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CustCRMDD);


		ele2=driver.findElement(By.id(CusEditCRMNameDD));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText(CustEditCRMNameDD);

		driver.findElement(By.name(CusEditProdEsc)).sendKeys(CustEditProdEsc);
		driver.findElement(By.name(CusEditFrstYrProd)).sendKeys(CustEditFrstYrProd);

		driver.findElement(By.xpath(CusEditCRMUpdBtn)).click();
	}

	@Test(priority=43,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC44() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditCRMMonitBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditCRMActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele1.click();
		driver.findElement(By.xpath(CusEditCrmBckBtn)).click();
	}

	@Test(priority=44,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC45() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditDocStup)).click();
		driver.findElement(By.xpath(CusEditDocChckBox)).click();
		driver.findElement(By.xpath(CusEditDocStupSveBtn)).click();
		//mandatory toast check
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/div"));
		if(ele1.isDisplayed()) {
			System.out.println("Attach document alert toast is shown");
		}
		else {
			System.out.println("Alert toast is not shown");
		}
	}

	@Test(priority=45,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC46() throws InterruptedException, AWTException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditDocStup)).click();
		driver.findElement(By.xpath(CusEditDocUpldBtn)).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Desktop\\Screenshot 2024-03-06 105214.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditDocChckBox)).click();
		driver.findElement(By.xpath(CusEditDocStupSveBtn)).click();
	}

	@Test(priority=46,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC47() throws InterruptedException, AWTException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditDocStup)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditDocActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele1.click();
		driver.findElement(By.xpath(CusEditDocBckBtn)).click();
	}

	@Test(priority=47,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC48() throws InterruptedException, AWTException {
		CusEditActBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditDocEscProg)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("selectedDate")).sendKeys("01-01-2023");
		driver.findElement(By.xpath("(//button[text()='Calculate'])")).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(CusEditEscAgreBtn));
		driver.findElement(By.xpath(CusEditEscRobtBtn)).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
		driver.findElement(By.xpath(CusEditEscUpdBtn)).click();
	}

	@Test(priority=48,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC49() throws InterruptedException, AWTException {
		CustomerListClick();
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditBackBtn)).click();
	}

	@Test(priority=49,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC50() throws InterruptedException, AWTException {
		CustomerListClick();
		Thread.sleep(2000);
		String CusBankNameDD=PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName=PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("LA SOLAR");
		Thread.sleep(2000);
		//driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(CusEditViewBtn));
		//		JavascriptExecutor js=(JavascriptExecutor)driver;
		//		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditViewClseBtn)).click();		
	}


	@Test(priority=50,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC51() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD=PropertyFileReader.propertymap.get("ACHBankDD");
		ele1=	driver.findElement(By.xpath(ACHBankNameDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHBankDD);
		ele2=driver.findElement(By.xpath(ACHBnkSrch));
		ele2.click();
		boolean enabledCheck = ele2.isEnabled();
		if(enabledCheck) {
			System.out.println("Search Box is clicked");
		}
		else {
			System.out.println("Search Box is not clicked");
		}
	}


	@Test(priority=51,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC52() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD=PropertyFileReader.propertymap.get("ACHBankDD");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		//driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditManEtry)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		ele4=driver.findElement(By.xpath(ACHEditRobChckBox));
		ele4.click();
		driver.findElement(By.xpath(ACHCheckBox1)).click();
		driver.findElement(By.xpath(ACHCheckBox2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn1)).click();
		Thread.sleep(2000);
		ele5=driver.findElement(By.xpath(ACHEditMandChck));
		if(ele5.isDisplayed()) {
			System.out.println("Mandatory popup is shown");
		}
		else {
			System.out.println("Mandatory popup is not shown");
		}
	}

	@Test(priority=52,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC53() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditManEtry)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditBckBtn)).click();
	}

	@Test(priority=53,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC54() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHNameOnAcc=PropertyFileReader.propertymap.get("ACHNameOnAcc");
		String ACHBnkName=PropertyFileReader.propertymap.get("ACHBnkName");
		String ACHAccNumb=PropertyFileReader.propertymap.get("ACHAccNumb");
		String ACHAccRoutNumb=PropertyFileReader.propertymap.get("ACHAccRoutNumb");
		String ACHBankLoc=PropertyFileReader.propertymap.get("ACHBankLoc");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		driver.findElement(By.xpath(ACHEditManEtry)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(4000);
		driver.findElement(By.name(ACHNamOnAcc)).sendKeys(ACHNameOnAcc);
		driver.findElement(By.name(ACHBnkNam)).sendKeys(ACHBnkName);
		driver.findElement(By.name(ACHAccNum)).sendKeys(ACHAccNumb);
		driver.findElement(By.name(ACHAccRoutNum)).sendKeys(ACHAccRoutNumb);
		driver.findElement(By.name(ACHBnkLoc)).sendKeys(ACHBankLoc);
		driver.findElement(By.xpath(ACHEditRobChckBox)).click();
		driver.findElement(By.xpath(ACHCheckBox1)).click();
		driver.findElement(By.xpath(ACHCheckBox2)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn1)).click();
	}

	@Test(priority=54,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC55() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		driver.findElement(By.xpath(ACHEditClsBtn)).click();
	}

	@Test(priority=55,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC56() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		driver.findElement(By.xpath(ACHSndBtn)).click();
	}


	@Test(priority=58,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC57() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(4000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActSndToSls)).click();
	}

	@Test(priority=57,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC58() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActCngPayDte)).click();
		driver.findElement(By.xpath(ACHActCngPayDteBtn)).click();
		ele5=driver.findElement(By.xpath(ACHActCngPayMandChk));
		Thread.sleep(2000);
		if(ele5.isDisplayed()) {
			System.out.println("Mandatory Field alert toast appears");
		}
		else {
			System.out.println("Mandatory Field alert toast is not appeared");
		}
		ele5.click();
	}

	@Test(priority=58,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC59() throws InterruptedException {
		TC58();
		String ACHPayDate=PropertyFileReader.propertymap.get("ACHPayDate");
		//mandatory ok button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/button")).click();
		//		Scanner scanner = new Scanner(System.in);
		//		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		//		System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		//		String EffectiveFromDate= scanner.nextLine();
		driver.findElement(By.xpath(ACHCngPayDteEffFrm)).sendKeys("Feb/2023");
		ele1=driver.findElement(By.xpath(ACHCngpayDate));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHPayDate);
		driver.findElement(By.xpath(ACHActCngPayDteBtn)).click();
	}

	@Test(priority=59,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC60() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch1=PropertyFileReader.propertymap.get("ACHSrch1");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHPayStsActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHSkipPay)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(ACHSkipPayAgreBtn)).click();
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();
		Thread.sleep(2000);
		ele5=driver.findElement(By.xpath(ACHSkipPymntMandMsg));
		if(ele5.isDisplayed()) {
			System.out.println("Mandatory message is showing ");
		}
		else {
			System.out.println("Mandatory message is not showing ");
		}
	}

	@Test(priority=60,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC61() throws InterruptedException {
		TC60();
		String ACHSkpPyReason=PropertyFileReader.propertymap.get("ACHSkpPyReason");
		//		Scanner scanner = new Scanner(System.in);
		//		System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		//		String StartMntDate= scanner.next();
		//		System.out.println("Please enter in the format like Mar/2024");
		//		String EndMntDate= scanner.next();
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/button")).click();
		driver.findElement(By.xpath(ACHSkpPyStrtMnth)).sendKeys("Feb/2023");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSkpPyEndMnth)).sendKeys("Apr/2023");
		driver.findElement(By.name(ACHSkpPyRsn)).sendKeys(ACHSkpPyReason);
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();
	}

	@Test(priority=61,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC62() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch=PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority=62,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC63() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHSndToCusReq=PropertyFileReader.propertymap.get("ACHSndToCusReq");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		//request box
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/textarea"));
		ele4.clear();
		ele4.sendKeys(ACHSndToCusReq);
		//send button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[8]/div/button")).click();
	}

	@Test(priority=63,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC64() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch1=PropertyFileReader.propertymap.get("ACHSrch1");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		//xpath for action button 
		ele4 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActBckBtn)).click();
	}

	@Test(priority=64,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC65() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		driver.findElement(By.xpath(ACHSndToSlsSndBtn)).click();
	}

	@Test(priority=65,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC66() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority=66,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC67() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHPayDate=PropertyFileReader.propertymap.get("ACHPayDate");
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActCngPayDte)).click();
		//		Scanner scanner = new Scanner(System.in);
		//		System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		//		String EffectiveFrom= scanner.next();
		driver.findElement(By.xpath(ACHCngPayDteEffFrm)).sendKeys("Feb/2023");
		ele5=driver.findElement(By.xpath(ACHCngpayDate));
		Select sel=new Select(ele5);
		sel.selectByVisibleText(ACHPayDate);
		driver.findElement(By.xpath(ACHCngpayDateBtn)).click();
	}

	@Test(priority=67,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC68() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1=PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHPayDate=PropertyFileReader.propertymap.get("ACHPayDate");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCusSkpPyBtn)).click();
		driver.findElement(By.name(ACHSkipPayAgreBtn)).click();
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();
		Thread.sleep(2000);
		ele5=driver.findElement(By.xpath(ACHSndToCusSkpPyMan));
		if(ele5.isDisplayed()) {
			System.out.println("Mandatory message is shown");
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/button")).click();
	}

	@Test(priority=68,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC69() throws InterruptedException {
		TC68();
		String ACHSkpPyRson=PropertyFileReader.propertymap.get("ACHSkpPyRson");
		//		Scanner scanner = new Scanner(System.in);
		//		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		//		System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		//		String StartMonth= scanner.nextLine();
		driver.findElement(By.name(ACHSndToCusSkpPySrtMnt)).sendKeys("Feb/2023");
		Thread.sleep(3000);
		//		Scanner scanner1 = new Scanner(System.in);
		//		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		//		System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		//		String EndMonth= scanner1.nextLine();
		driver.findElement(By.name(ACHSndToCusSkpPyEndMnt)).sendKeys("Feb/2023");
		driver.findElement(By.name(ACHSkpPyRsn)).sendKeys(ACHSkpPyRson);
	}

	@Test(priority=69,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC70() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD=PropertyFileReader.propertymap.get("ACHBankDD");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority=70,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC71() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD=PropertyFileReader.propertymap.get("ACHBankDD");
		String ACHSrch2=PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType=PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus=PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHToMailId=PropertyFileReader.propertymap.get("ACHToMailId");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD);
		ele2=driver.findElement(By.name(ACHType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(ACHAccType);
		ele3=driver.findElement(By.name(ACHStatus));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4=driver.findElement(By.xpath(ACHSndToCusToMailId));
		ele4.clear();
		ele4.sendKeys(ACHToMailId);
		driver.findElement(By.xpath(ACHSndToSlsSndBtn)).click();
	}
}


