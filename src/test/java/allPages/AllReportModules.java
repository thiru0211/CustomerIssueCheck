package allPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import allPages.ReRunFailedTestCase;

public class AllReportModules extends Locators{
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

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void OSReportBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath(OSReportBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void TapeReportBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath(TapeReprtBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ACHTransactionBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath(ACHTransBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void InvoiceLog() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath(InvoiceLogBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ActivityReport() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath(ActRepBtn)).click();
	}

	@Test(priority = 1,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		OSReportBtn();
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");

		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException {
		OSReportBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OSReportExpBtn)).click();
	}

	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OSAddNotes)).click();
		Thread.sleep(3000);
		ele2=driver.findElement(By.xpath("//div[text()='Save']"));
		ele2.click();
	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		String OSAddNtTxt=PropertyFileReader.propertymap.get("OSAddNtTxt");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OSAddNotes)).click();
		ele2=driver.findElement(By.xpath(OSAddNtTxtBox));
		ele2.sendKeys(OSAddNtTxt);
		ele2.clear();
	}

	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OSAddNotes)).click();
		driver.findElement(By.xpath(OSAddNtClsBtn)).click();
	}

	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		String OSAddNtTxt=PropertyFileReader.propertymap.get("OSAddNtTxt");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OSAddNotes)).click();
		driver.findElement(By.xpath(OSAddNtTxtBox)).sendKeys(OSAddNtTxt);
		ele2=driver.findElement(By.xpath(OSAddNtSavBtn));
		ele2.click();
	}

	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		driver.findElement(By.xpath(OSAddNtViewBtn)).click();
	}

	@Test(priority = 8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(OSAddNtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(OSAddRcdPymt)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OSAddRcdPySubBtn)).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@style='color: red;']"));
		// Iterate over the list of elements
		for (WebElement ele2 : elements) {
			// Get the text content of the div
			String textContent = ele2.getText();
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Text Content: " + textContent);
			if(!textContent.isEmpty()) {
				System.out.println("Mandatory field is shown");
			}
			else {
				System.out.println("Mandatory field is not shown");
			}
		}
	}

	@Test(priority = 9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		TC08();
		String OSAddManDueMnth=PropertyFileReader.propertymap.get("OSAddManDueMnth");
		String OSAddRcdPyTraDte=PropertyFileReader.propertymap.get("OSAddRcdPyTraDte");
		String OSAddRcdPyTraDes=PropertyFileReader.propertymap.get("OSAddRcdPyTraDes");
		String OSAddRcdPyAmt=PropertyFileReader.propertymap.get("OSAddRcdPyAmt");
		String OSAddRcdPayMode=PropertyFileReader.propertymap.get("OSAddRcdPayMode");
		String OSAddRcdPyBankName=PropertyFileReader.propertymap.get("OSAddRcdPyBankName");
		String OSAddRcdPyType=PropertyFileReader.propertymap.get("OSAddRcdPyType");

		driver.findElement(By.name(OSAddManDueMnt)).sendKeys(OSAddManDueMnth);
		driver.findElement(By.name(OSAddRcdPyTranDate)).sendKeys(OSAddRcdPyTraDte);
		driver.findElement(By.name(OSAddRcdPyTranDes)).sendKeys(OSAddRcdPyTraDes);
		driver.findElement(By.name(OSAddRcdPyAmnt)).sendKeys(OSAddRcdPyAmt);

		ele1=driver.findElement(By.id(OSAddRcdPyMode));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(OSAddRcdPayMode);

		ele2=driver.findElement(By.name(OSAddRcdPyBnkName));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(OSAddRcdPyBankName);

		ele3=driver.findElement(By.id(OSAddRcdPyTyp));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(OSAddRcdPyType);

		driver.findElement(By.xpath(OSAddRcdPyCLrBtn)).click();
	}

	@Test(priority = 10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		TC08();
		driver.findElement(By.xpath(OSAddRcdPyClsBtn)).click();
	}

	@Test(priority = 11,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		TC08();
		String OSAddManDueMnth=PropertyFileReader.propertymap.get("OSAddManDueMnth");
		String OSAddRcdPyTraDte=PropertyFileReader.propertymap.get("OSAddRcdPyTraDte");
		String OSAddRcdPyTraDes=PropertyFileReader.propertymap.get("OSAddRcdPyTraDes");
		String OSAddRcdPyAmt=PropertyFileReader.propertymap.get("OSAddRcdPyAmt");
		String OSAddRcdPayMode=PropertyFileReader.propertymap.get("OSAddRcdPayMode");
		String OSAddRcdPyBankName=PropertyFileReader.propertymap.get("OSAddRcdPyBankName");
		String OSAddRcdPyType=PropertyFileReader.propertymap.get("OSAddRcdPyType");

		driver.findElement(By.name(OSAddManDueMnt)).sendKeys(OSAddManDueMnth);
		driver.findElement(By.name(OSAddRcdPyTranDate)).sendKeys(OSAddRcdPyTraDte);
		driver.findElement(By.name(OSAddRcdPyTranDes)).sendKeys(OSAddRcdPyTraDes);
		driver.findElement(By.name(OSAddRcdPyAmnt)).sendKeys(OSAddRcdPyAmt);

		ele1=driver.findElement(By.id(OSAddRcdPyMode));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(OSAddRcdPayMode);

		ele2=driver.findElement(By.name(OSAddRcdPyBnkName));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(OSAddRcdPyBankName);

		ele3=driver.findElement(By.id(OSAddRcdPyTyp));
		Select sel3=new Select(ele3);
		sel3.selectByVisibleText(OSAddRcdPyType);

		driver.findElement(By.xpath(OSAddRcdPySubBtn)).click();
	}

	@Test(priority = 12,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(OSAddNtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(OSAddManPymnt)).click();
		driver.findElement(By.xpath(OSAddManSavBtn)).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@style='color: red;']"));
		// Iterate over the list of elements
		for (WebElement ele2 : elements) {
			// Get the text content of the div
			String textContent = ele2.getText();
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Text Content: " + textContent);

			if(!textContent.isEmpty()) {
				System.out.println("Mandatory field is shown");
			}
			else {
				System.out.println("Mandatory field is not shown");
			}
		}
	}

	@Test(priority = 13,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		TC12();
		driver.findElement(By.xpath(OSAddManClsBtn)).click();
	}

	@Test(priority = 14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		TC12();
		String OSAddManDueMnth=PropertyFileReader.propertymap.get("OSAddManDueMnth");
		driver.findElement(By.name(OSAddManDueMnt)).sendKeys(OSAddManDueMnth);
	}

	@Test(priority = 15,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		TC12();
		String OSAddMonPayAmnt=PropertyFileReader.propertymap.get("OSAddMonPayAmnt");
		driver.findElement(By.name(OSAddMonPayAmt)).sendKeys(OSAddMonPayAmnt);
	}

	@Test(priority = 16,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException {
		TC12();
		String OSAddManSchDat=PropertyFileReader.propertymap.get("OSAddManSchDat");
		driver.findElement(By.name(OSAddManSchDate)).sendKeys(OSAddManSchDat);
	}

	@Test(priority = 17,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException {
		TC12();
		String OSAddManDueMnth=PropertyFileReader.propertymap.get("OSAddManDueMnth");
		String OSAddMonPayAmnt=PropertyFileReader.propertymap.get("OSAddMonPayAmnt");
		String OSAddMonPayResn=PropertyFileReader.propertymap.get("OSAddMonPayResn");
		String OSAddManSchDat=PropertyFileReader.propertymap.get("OSAddManSchDat");
		driver.findElement(By.name(OSAddManDueMnt)).sendKeys(OSAddManDueMnth);
		driver.findElement(By.name(OSAddManPayBtn)).click();
		driver.findElement(By.name(OSAddMonPayAmt)).sendKeys(OSAddMonPayAmnt);
		driver.findElement(By.name(OSAddMonPayRsn)).sendKeys(OSAddMonPayResn);
		driver.findElement(By.name(OSAddManSchDate)).sendKeys(OSAddManSchDat);
		Thread.sleep(5000);
		driver.findElement(By.xpath(OSAddManSavBtn)).click();
	}

	@Test(priority = 18,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException {
		OSReportBtn();
		String OSReportCusName=PropertyFileReader.propertymap.get("OSReportCusName");
		String OSRepBankName=PropertyFileReader.propertymap.get("OSRepBankName");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(OSBankName));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(OSRepBankName);
		driver.findElement(By.xpath(OSCusName)).sendKeys(OSReportCusName);
		driver.findElement(By.xpath(OSEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(OSAddNtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(OSACtBckBtn)).click();
	}

	@Test(priority = 19,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException {
		TapeReportBtn();
		String TapeRptInsDD=PropertyFileReader.propertymap.get("TapeRptInsDD");
		ele1=driver.findElement(By.xpath(TapeRepInstlrDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(TapeRptInsDD);
		driver.findElement(By.id(TapeRepRunRep)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(TapeRepDwldBtn)).click();
	}

	@Test(priority = 20,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException {
		ACHTransactionBtn();
		String ACHTransDD=PropertyFileReader.propertymap.get("ACHTransDD");
		String ACHTransFrmDate=PropertyFileReader.propertymap.get("ACHTransFrmDate");
		ele1=driver.findElement(By.xpath(ACHTransInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHTransDD);
		ele2=driver.findElement(By.xpath(ACHTransFrmDte));
		ele2.sendKeys(ACHTransFrmDate);
	}

	@Test(priority = 21,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException {
		ACHTransactionBtn();
		String ACHTransDD=PropertyFileReader.propertymap.get("ACHTransDD");
		String ACHTransFrmDate=PropertyFileReader.propertymap.get("ACHTransFrmDate");
		ele1=driver.findElement(By.xpath(ACHTransInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHTransDD);
		ele2=driver.findElement(By.xpath(ACHTransFrmDte));
		ele2.sendKeys(ACHTransFrmDate);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(ACHTransActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(ACHTransFileLog)).click();
	}

	@Test(priority = 22,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException {
		ACHTransactionBtn();
		String ACHTransDD=PropertyFileReader.propertymap.get("ACHTransDD");
		String ACHTransFrmDate=PropertyFileReader.propertymap.get("ACHTransFrmDate");
		ele1=driver.findElement(By.xpath(ACHTransInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHTransDD);
		ele2=driver.findElement(By.xpath(ACHTransFrmDte));
		ele2.sendKeys(ACHTransFrmDate);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(ACHTransActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(ACHTransExcelExp)).click();
	}

	@Test(priority =23,retryAnalyzer = ReRunFailedTestCase.class )
	public void TC24() throws InterruptedException {
		ACHTransactionBtn();
		String ACHTransDD=PropertyFileReader.propertymap.get("ACHTransDD");
		String ACHTransFrmDate=PropertyFileReader.propertymap.get("ACHTransFrmDate");
		ele1=driver.findElement(By.xpath(ACHTransInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHTransDD);
		ele2=driver.findElement(By.xpath(ACHTransFrmDte));
		ele2.sendKeys(ACHTransFrmDate);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(ACHTransActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(ACHTransBckBtn)).click();
	}

	@Test(priority = 24,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException {
		ACHTransactionBtn();
		String ACHTransDD=PropertyFileReader.propertymap.get("ACHTransDD");
		String ACHTransFrmDate=PropertyFileReader.propertymap.get("ACHTransFrmDate");
		String ACHTranCusName=PropertyFileReader.propertymap.get("ACHTranCusName");
		ele1=driver.findElement(By.xpath(ACHTransInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ACHTransDD);
		ele2=driver.findElement(By.xpath(ACHTransFrmDte));
		ele2.sendKeys(ACHTransFrmDate);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(ACHTransActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(ACHCusSrch)).sendKeys(ACHTranCusName);
		driver.findElement(By.xpath(ACHTransCusEditBtn)).click();
		driver.findElement(By.id(ACHTransCusEditBCkBtn)).click();
	}

	@Test(priority = 25,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException {
		InvoiceLog();//1
		String InvLogBnkDD=PropertyFileReader.propertymap.get("InvLogBnkDD");
		String InvLogCusName=PropertyFileReader.propertymap.get("InvLogCusName");
		String InvPayTyp=PropertyFileReader.propertymap.get("InvPayTyp");

		ele1=driver.findElement(By.xpath(InvLogBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(InvLogBnkDD);

		ele2=driver.findElement(By.xpath(InvLogPyType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(InvPayTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogCusNam)).sendKeys(InvLogCusName);
	}

	@Test(priority = 26,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException {
		TC26();//2
		String InvLogFrmDat=PropertyFileReader.propertymap.get("InvLogFrmDat");
		driver.findElement(By.xpath(InvLogFrmDate)).sendKeys(InvLogFrmDat);
	}

	@Test(priority = 27,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException {
		InvoiceLog();//3
		driver.findElement(By.xpath(InvLogExprtBtn)).click();
	}

	@Test(priority = 28,retryAnalyzer = ReRunFailedTestCase.class, enabled=false, description = "URL loading time is very high")
	public void TC29() throws InterruptedException {
		TC26();//4
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		ele1=driver.findElement(By.id(InvLogPymtUrl));
		String text = ele1.getText();
		driver.get(text);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.name(InvLogPayURLRob)).click();
		driver.findElement(By.name(InvLogPayURLAgre)).click();
		driver.findElement(By.name(InvLogPayURLPay)).click();
	}

	@Test(priority = 29,retryAnalyzer = ReRunFailedTestCase.class, enabled=false)
	public void TC30() throws InterruptedException {
		TC26();//5
		String ILPayURLName=PropertyFileReader.propertymap.get("ILPayURLName");
		String ILPayURLAcc=PropertyFileReader.propertymap.get("ILPayURLAcc");
		String ILPayURLRout=PropertyFileReader.propertymap.get("ILPayURLRout");
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		ele1=driver.findElement(By.id(InvLogPymtUrl));
		String text = ele1.getText();
		driver.get(text);
		Thread.sleep(5000);
		driver.findElement(By.name(InvLogPayURLName)).sendKeys(ILPayURLName);
		driver.findElement(By.name(InvLogPayURLAcc)).sendKeys(ILPayURLAcc);
		driver.findElement(By.name(InvLogPayURLRout)).sendKeys(ILPayURLRout);
		driver.findElement(By.name(InvLogPayURLPay)).click();
		driver.findElement(By.name(InvLogPayURLPay)).click();
		driver.findElement(By.name(InvLogPayURLPay)).click();
	}

	@Test(priority = 30,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException {
		TC26();	//6
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogRsndInv)).click();
		driver.findElement(By.id(InvLogRsndYes)).click();
	}

	@Test(priority = 31,retryAnalyzer = ReRunFailedTestCase.class, description = "after finish TC29 then it can implement")
	public void TC32() throws InterruptedException {
		TC26();	//7
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogRsndInv)).click();
		driver.findElement(By.id(InvLogRsndYes)).click();
	}

	@Test(priority = 32,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException {
		TC26();	//8
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogRsndInv)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogRsndNo)).click();
	}

	@Test(priority = 33,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException {
		TC26();	//9
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogDwldInv)).click();
	}

	@Test(priority = 34,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC35() throws InterruptedException {
		InvoiceLog();//10
		String InvLogBnkDD=PropertyFileReader.propertymap.get("InvLogBnkDD");
		String InvLogPaidCusName=PropertyFileReader.propertymap.get("InvLogPaidCusName");
		String InvPayTyp=PropertyFileReader.propertymap.get("InvPayTyp");

		ele1=driver.findElement(By.xpath(InvLogBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(InvLogBnkDD);

		ele2=driver.findElement(By.xpath(InvLogPyType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(InvPayTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogCusNam)).sendKeys(InvLogPaidCusName);
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogDwldRecp)).click();
	}

	@Test(priority = 35,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC36() throws InterruptedException {
		InvoiceLog();//11
		String InvLogBnkDD=PropertyFileReader.propertymap.get("InvLogBnkDD");
		String InvLogPaidCusName=PropertyFileReader.propertymap.get("InvLogPaidCusName");
		String InvPayTyp=PropertyFileReader.propertymap.get("InvPayTyp");

		ele1=driver.findElement(By.xpath(InvLogBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(InvLogBnkDD);

		ele2=driver.findElement(By.xpath(InvLogPyType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(InvPayTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogCusNam)).sendKeys(InvLogPaidCusName);
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogDwldAll)).click();
	}

	@Test(priority = 36,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC37() throws InterruptedException {
		InvoiceLog();//12
		String InvLogBnkDD=PropertyFileReader.propertymap.get("InvLogBnkDD");
		String InvLogPendCusName1=PropertyFileReader.propertymap.get("InvLogPendCusName1");
		String InvPayTyp=PropertyFileReader.propertymap.get("InvPayTyp");
		String InvLogVoidRemrk=PropertyFileReader.propertymap.get("InvLogVoidRemrk");

		ele1=driver.findElement(By.xpath(InvLogBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(InvLogBnkDD);

		ele2=driver.findElement(By.xpath(InvLogPyType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(InvPayTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogCusNam)).sendKeys(InvLogPendCusName1);
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogVoidInv)).click();
		driver.findElement(By.name(InvLogVoidRmrk)).sendKeys(InvLogVoidRemrk);
		Thread.sleep(2000);
		driver.findElement(By.id(InvLogVoidYes)).click();
	}

	@Test(priority = 37,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC38() throws InterruptedException {
		InvoiceLog();//13
		String InvLogBnkDD=PropertyFileReader.propertymap.get("InvLogBnkDD");
		String InvLogPendCusName1=PropertyFileReader.propertymap.get("InvLogPendCusName1");
		String InvPayTyp=PropertyFileReader.propertymap.get("InvPayTyp");

		ele1=driver.findElement(By.xpath(InvLogBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(InvLogBnkDD);

		ele2=driver.findElement(By.xpath(InvLogPyType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(InvPayTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogCusNam)).sendKeys(InvLogPendCusName1);
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogVoidInv)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogVoidNo)).click();
	}

	@Test(priority = 38,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC39() throws InterruptedException {
		InvoiceLog();//14
		String InvLogBnkDD=PropertyFileReader.propertymap.get("InvLogBnkDD");
		String InvLogPendCusName1=PropertyFileReader.propertymap.get("InvLogPendCusName1");
		String InvPayTyp=PropertyFileReader.propertymap.get("InvPayTyp");

		ele1=driver.findElement(By.xpath(InvLogBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(InvLogBnkDD);

		ele2=driver.findElement(By.xpath(InvLogPyType));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(InvPayTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvLogCusNam)).sendKeys(InvLogPendCusName1);
		driver.findElement(By.xpath(InvLogCusEdtBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(InvLogCusEdtActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvLogCusEdtActBckBtn)).click();
	}
}


