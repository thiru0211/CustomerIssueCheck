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
import java.util.List;
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

public class InstallerSetup extends Locators  {
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
	public void InstallerBtnClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath(InstallerBtn)).click();
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/span[2]/div/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("All");
	}

	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void EnterAllDetails() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstlrName=PropertyFileReader.propertymap.get("InstlrName");
		String CntryDD=PropertyFileReader.propertymap.get("CntryDD");
		String StateDD=PropertyFileReader.propertymap.get("StateDD");
		String Add1=PropertyFileReader.propertymap.get("Add1");
		String Add2=PropertyFileReader.propertymap.get("Add2");
		String InstlrCity=PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode=PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone=PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail=PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite=PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy=PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName=PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl=PropertyFileReader.propertymap.get("CRMUrl");
		ele1=driver.findElement(By.xpath(InstAddBtn));
		ele1.click();
		driver.findElement(By.name(InstName)).sendKeys(InstlrName);
		ele4=driver.findElement(By.xpath(InstStatusEnbl));
		ele4.click();
		ele2=driver.findElement(By.name(InstCntryDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		ele3=driver.findElement(By.name(InstStateDD));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
	}


	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(3000);
		ele1=driver.findElement(By.xpath(InstAddBtn));
		ele1.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(InstSaveBtn)).click();
		ele2=driver.findElement(By.xpath(InstAlrtMsg));
		if(ele2.isDisplayed()) {
			System.out.println("Mandatory alert message is shown");
		}
		else {
			System.out.println("Mandatory alert message is not shown");
		}
	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		EnterAllDetails();
		driver.findElement(By.id(InstClrBtn)).click();
	}

	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		EnterAllDetails();
		driver.findElement(By.xpath(InstSaveBtn)).click();
	}

	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstlrName=PropertyFileReader.propertymap.get("InstlrName");
		String CntryDD=PropertyFileReader.propertymap.get("CntryDD");
		String StateDD=PropertyFileReader.propertymap.get("StateDD");
		String Add1=PropertyFileReader.propertymap.get("Add1");
		String Add2=PropertyFileReader.propertymap.get("Add2");
		String InstlrCity=PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode=PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone=PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail=PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite=PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy=PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName=PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl=PropertyFileReader.propertymap.get("CRMUrl");
		ele1=driver.findElement(By.xpath(InstAddBtn));
		ele1.click();
		driver.findElement(By.name(InstName)).sendKeys(InstlrName);
		driver.findElement(By.xpath(InstStatusDSbl)).click();
		ele2=driver.findElement(By.name(InstCntryDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		ele3=driver.findElement(By.name(InstStateDD));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.xpath(InstSaveBtn)).click();
	}

	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		InstallerBtnClick();
		driver.findElement(By.xpath(InstAddBtn)).click();
		driver.findElement(By.xpath(InstBackBtn)).click();
	}
	@Test(priority = 8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		driver.findElement(By.xpath(InstBackBtn)).click();
	}

	@Test(priority = 9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String ModifiedInstName=PropertyFileReader.propertymap.get("ModifiedInstName");
		String CntryDD=PropertyFileReader.propertymap.get("CntryDD");
		String StateDD=PropertyFileReader.propertymap.get("StateDD");
		String Add1=PropertyFileReader.propertymap.get("Add1");
		String Add2=PropertyFileReader.propertymap.get("Add2");
		String InstlrCity=PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode=PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone=PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail=PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite=PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy=PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName=PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl=PropertyFileReader.propertymap.get("CRMUrl");
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		driver.findElement(By.name(InstName)).sendKeys(ModifiedInstName);
		ele4=driver.findElement(By.xpath(InstStatusEnbl));
		ele4.click();
		ele2=driver.findElement(By.name(InstCntryDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		ele3=driver.findElement(By.name(InstStateDD));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.id(InstResetBtn)).click();
	}

	@Test(priority = 10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String ModifiedInstName=PropertyFileReader.propertymap.get("ModifiedInstName");
		String CntryDD=PropertyFileReader.propertymap.get("CntryDD");
		String StateDD=PropertyFileReader.propertymap.get("StateDD");
		String Add1=PropertyFileReader.propertymap.get("Add1");
		String Add2=PropertyFileReader.propertymap.get("Add2");
		String InstlrCity=PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode=PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone=PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail=PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite=PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy=PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName=PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl=PropertyFileReader.propertymap.get("CRMUrl");
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		driver.findElement(By.name(InstName)).sendKeys(ModifiedInstName);
		ele4=driver.findElement(By.xpath(InstStatusDSbl));
		ele4.click();
		ele2=driver.findElement(By.name(InstCntryDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		ele3=driver.findElement(By.name(InstStateDD));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.xpath(InstUpdateBtn)).click();
	}

	@Test(priority = 11,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String ModifiedInstName=PropertyFileReader.propertymap.get("ModifiedInstName");
		String CntryDD=PropertyFileReader.propertymap.get("CntryDD");
		String StateDD=PropertyFileReader.propertymap.get("StateDD");
		String Add1=PropertyFileReader.propertymap.get("Add1");
		String Add2=PropertyFileReader.propertymap.get("Add2");
		String InstlrCity=PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode=PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone=PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail=PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite=PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy=PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName=PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl=PropertyFileReader.propertymap.get("CRMUrl");
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		driver.findElement(By.name(InstName)).sendKeys(ModifiedInstName);
		ele4=driver.findElement(By.xpath(InstStatusEnbl));
		ele4.click();
		ele2=driver.findElement(By.name(InstCntryDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		ele3=driver.findElement(By.name(InstStateDD));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.xpath(InstUpdateBtn)).click();
	}

	@Test(priority = 12,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException, AWTException {
		TC10();
	}


	@Test(priority = 13,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDetails)).click();
		driver.findElement(By.xpath(InvstClseBtn)).click();
	}

	@Test(priority = 14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String TranDate=PropertyFileReader.propertymap.get("TranDate");
		String TranAmount=PropertyFileReader.propertymap.get("TranAmount");
		String TranBankName=PropertyFileReader.propertymap.get("TranBankName");
		String TranAccNum=PropertyFileReader.propertymap.get("TranAccNum");
		String Remarks=PropertyFileReader.propertymap.get("Remarks");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDetails)).click();
		driver.findElement(By.name(InvstTraDate)).sendKeys(TranDate);
		driver.findElement(By.name(InvstAmount)).sendKeys(TranAmount);
		driver.findElement(By.name(InvstBankname)).sendKeys(TranBankName);
		driver.findElement(By.name(InvstAccnum)).sendKeys(TranAccNum);
		driver.findElement(By.name(InvstRemarks)).sendKeys(Remarks);
		driver.findElement(By.xpath(InvstDocAttach)).click();
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
		driver.findElement(By.xpath(InvstClrBtn)).click();
	}

	@Test(priority = 15,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String TranDate=PropertyFileReader.propertymap.get("TranDate");
		String TranAmount=PropertyFileReader.propertymap.get("TranAmount");
		String TranBankName=PropertyFileReader.propertymap.get("TranBankName");
		String TranAccNum=PropertyFileReader.propertymap.get("TranAccNum");
		String Remarks=PropertyFileReader.propertymap.get("Remarks");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDetails)).click();
		driver.findElement(By.name(InvstTraDate)).sendKeys(TranDate);
		driver.findElement(By.name(InvstAmount)).sendKeys(TranAmount);
		driver.findElement(By.name(InvstBankname)).sendKeys(TranBankName);
		driver.findElement(By.name(InvstAccnum)).sendKeys(TranAccNum);
		driver.findElement(By.name(InvstRemarks)).sendKeys(Remarks);
		driver.findElement(By.xpath(InvstDocAttach)).click();
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
		driver.findElement(By.xpath(InvstSaveBtn)).click();
	}

	@Test(priority = 16,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvstDetails)).click();
		driver.findElement(By.xpath(InvstDocAttach)).click();
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
//		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[6]/div/div/div/h6"));
//		String text = element2.getText();
//		System.out.println(text);		
	}

	@Test(priority = 17,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstBackBtn)).click();
	}

	@Test(priority = 18,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String StatusEnbl=PropertyFileReader.propertymap.get("StatusEnbl");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		ele2 = driver.findElement(By.name(InstStatusDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(StatusEnbl);
	}

	@Test(priority = 19,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String StatusDSbl=PropertyFileReader.propertymap.get("StatusDSbl");
		ele2 = driver.findElement(By.name(InstStatusDD));
		Select sel=new Select(ele2);
		sel.selectByVisibleText(StatusDSbl);
	}

	@Test(priority = 20,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstCloseBtn)).click();
	}

	@Test(priority = 21,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstClrBtn)).click();
	}

	@Test(priority = 22,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		String TranDate=PropertyFileReader.propertymap.get("TranDate");
		String TranAmount=PropertyFileReader.propertymap.get("TranAmount");
		String TranBankName=PropertyFileReader.propertymap.get("TranBankName");
		String TranAccNum=PropertyFileReader.propertymap.get("TranAccNum");
		String Remarks=PropertyFileReader.propertymap.get("Remarks");
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstClrBtn)).click();
		driver.findElement(By.name(InvstTraDate)).sendKeys(TranDate);
		driver.findElement(By.name(InvstAmount)).sendKeys(TranAmount);
		driver.findElement(By.name(InvstBankname)).sendKeys(TranBankName);
		driver.findElement(By.name(InvstAccnum)).sendKeys(TranAccNum);
		driver.findElement(By.name(InvstRemarks)).sendKeys(Remarks);
		driver.findElement(By.xpath(InvstSaveBtn)).click();
	}

	@Test(priority = 23,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDocAttach)).click();
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
//		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[6]/div/div/div/h6"));
//		String text = element2.getText();
//		System.out.println(text);		
	}

	@Test(priority = 24,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName=PropertyFileReader.propertymap.get("InstSearchName");
		ele1=driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstBankSetupBtn)).click();
		String checkBoxXpath = "//*[@id=\"kt_content_container\"]/div[2]/div/div[1]/table/thead/tr/th[5]/input";
		WebElement checkBox = driver.findElement(By.xpath(checkBoxXpath));
		checkBox.click();		
	}

}
