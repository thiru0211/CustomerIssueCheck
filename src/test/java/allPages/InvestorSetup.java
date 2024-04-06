package allPages;

import static org.testng.Assert.fail;

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

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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

public class InvestorSetup extends Locators {

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
	public void InvestorBtnClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath(InvestorBtn)).click();
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvstrDD=PropertyFileReader.propertymap.get("InvstrDD");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		Thread.sleep(3000);
		ele1 = driver.findElement(By.name(InvstrStatusDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(InvstrDD);
	}

	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		InvestorBtnClick();
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrSaveBtn)).click();
		Thread.sleep(3000);
		ele1=driver.findElement(By.xpath(InvstrWarningMsg));
		if(ele1.isDisplayed()) {
			System.out.println("Warning message is shown");
		}
	}


	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvestCntry=PropertyFileReader.propertymap.get("InvestCntry");
		String InvestState=PropertyFileReader.propertymap.get("InvestState");
		String InvestAdd1=PropertyFileReader.propertymap.get("InvestAdd1");
		String InvestAdd2=PropertyFileReader.propertymap.get("InvestAdd2");
		String InvestCity=PropertyFileReader.propertymap.get("InvestCity");
		String InvestZipcode=PropertyFileReader.propertymap.get("InvestZipcode");
		String InvestPhone=PropertyFileReader.propertymap.get("InvestPhone");
		String InvestEmail=PropertyFileReader.propertymap.get("InvestEmail");
		String InvestWeb=PropertyFileReader.propertymap.get("InvestWeb");
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		driver.findElement(By.name(InvstrName)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEnblBtn)).click();

		ele1=driver.findElement(By.name(InvstrCntry));
		Select country=new Select(ele1);
		country.selectByVisibleText(InvestCntry);

		ele2 = driver.findElement(By.name(InvstrState));
		Select state=new Select(ele2);
		state.selectByVisibleText(InvestState);

		driver.findElement(By.name(InvstrAdd1)).sendKeys(InvestAdd1);
		driver.findElement(By.name(InvstrAdd2)).sendKeys(InvestAdd2);
		driver.findElement(By.name(InvstrCity)).sendKeys(InvestCity);
		driver.findElement(By.name(InvstrZipCode)).sendKeys(InvestZipcode);
		driver.findElement(By.name(InvstrPhone)).sendKeys(InvestPhone);
		driver.findElement(By.name(InvstrEmail)).sendKeys(InvestEmail);
		driver.findElement(By.name(InvstrWebsite)).sendKeys(InvestWeb);
		driver.findElement(By.id(InvstrClrBtn)).click();
	}


	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		InvestorBtnClick();
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		driver.findElement(By.xpath(InvstrBackBtn)).click();
		driver.findElement(By.xpath(InvstrAddBtn)).click();
	}



	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvestCntry=PropertyFileReader.propertymap.get("InvestCntry");
		String InvestState=PropertyFileReader.propertymap.get("InvestState");
		String InvestAdd1=PropertyFileReader.propertymap.get("InvestAdd1");
		String InvestAdd2=PropertyFileReader.propertymap.get("InvestAdd2");
		String InvestCity=PropertyFileReader.propertymap.get("InvestCity");
		String InvestZipcode=PropertyFileReader.propertymap.get("InvestZipcode");
		String InvestPhone=PropertyFileReader.propertymap.get("InvestPhone");
		String InvestEmail=PropertyFileReader.propertymap.get("InvestEmail");
		String InvestWeb=PropertyFileReader.propertymap.get("InvestWeb");
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		driver.findElement(By.name(InvstrName)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEnblBtn)).click();

		ele1=driver.findElement(By.name(InvstrCntry));
		Select country=new Select(ele1);
		country.selectByVisibleText(InvestCntry);

		ele2 = driver.findElement(By.name(InvstrState));
		Select state=new Select(ele2);
		state.selectByVisibleText(InvestState);

		driver.findElement(By.name(InvstrAdd1)).sendKeys(InvestAdd1);
		driver.findElement(By.name(InvstrAdd2)).sendKeys(InvestAdd2);
		driver.findElement(By.name(InvstrCity)).sendKeys(InvestCity);
		driver.findElement(By.name(InvstrZipCode)).sendKeys(InvestZipcode);
		driver.findElement(By.name(InvstrPhone)).sendKeys(InvestPhone);
		driver.findElement(By.name(InvstrEmail)).sendKeys(InvestEmail);
		driver.findElement(By.name(InvstrWebsite)).sendKeys(InvestWeb);
		driver.findElement(By.xpath(InvstrSaveBtn)).click();
	}

	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvestCity=PropertyFileReader.propertymap.get("InvestCity");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(InvstrCity));

		while (!ele1.getAttribute("value").isEmpty()) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(InvestCity);
		driver.findElement(By.xpath(InvstrSaveBtn)).click();	
	}

	@Test(priority = 8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		Thread.sleep(2000);	
		driver.findElement(By.id(InvstrClrBtn)).click();	
	}


	@Test(priority = 9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath(InvstrBackBtn)).click();
	}

	@Test(priority = 10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvestTranDate=PropertyFileReader.propertymap.get("InvestTranDate");
		String InvestAmt=PropertyFileReader.propertymap.get("InvestAmt");
		String InvestBankName=PropertyFileReader.propertymap.get("InvestBankName");
		String InvestAccNum=PropertyFileReader.propertymap.get("InvestAccNum");
		String InvestRmrk=PropertyFileReader.propertymap.get("InvestRmrk");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvstrAddTans)).click();
		driver.findElement(By.name(InvstrTranDate)).sendKeys(InvestTranDate);
		driver.findElement(By.name(InvstrTranAmt)).sendKeys(InvestAmt);
		driver.findElement(By.name(InvstrTranBank)).sendKeys(InvestBankName);
		driver.findElement(By.name(InvstrTranAccNum)).sendKeys(InvestAccNum);
		driver.findElement(By.name(InvstrTranRemarks)).sendKeys(InvestRmrk);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrAttachBtn)).click();
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
		driver.findElement(By.xpath(InvstrTranSavBtn)).click();
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/button"));
		if(element3.isDisplayed()) {
			System.out.println("Test Failed because File uploaded sucessfully but page shows need to upload toast");
		}
		else {
			WebElement element2 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div[6]/div[2]/div/div/div/h6"));
			String text = element2.getText();
			System.out.println(text);		
		}
	}

	@Test(priority = 11,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvestTranDate=PropertyFileReader.propertymap.get("InvestTranDate");
		String InvestAmt=PropertyFileReader.propertymap.get("InvestAmt");
		String InvestBankName=PropertyFileReader.propertymap.get("InvestBankName");
		String InvestAccNum=PropertyFileReader.propertymap.get("InvestAccNum");
		String InvestRmrk=PropertyFileReader.propertymap.get("InvestRmrk");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvstrAddTans)).click();
		driver.findElement(By.name(InvstrTranDate)).sendKeys(InvestTranDate);
		driver.findElement(By.name(InvstrTranAmt)).sendKeys(InvestAmt);
		driver.findElement(By.name(InvstrTranBank)).sendKeys(InvestBankName);
		driver.findElement(By.name(InvstrTranAccNum)).sendKeys(InvestAccNum);
		driver.findElement(By.name(InvstrTranRemarks)).sendKeys(InvestRmrk);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrAttachBtn)).click();
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
		driver.findElement(By.xpath(InvstrTranClrBtn)).click();
	}

	@Test(priority = 12,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		driver.findElement(By.xpath(InvstrBackBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddTans)).click();
		driver.findElement(By.xpath(InvstrTranBckBtn)).click();		
	}

	@Test(priority = 13,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		String expectedUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[5]/div/div/div/div[3]/div/div")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if(!(currentUrl==expectedUrl)) {
			System.out.println("Page shows Customer details");
		}
	}

	@Test(priority = 14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvstrTranExcelBtn)).click();
	}

	@Test(priority = 15,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvstrActBckBtn)).click();
	}


	@Test(priority = 16,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		String InvestInslrDD=PropertyFileReader.propertymap.get("InvestInslrDD");
		String InvestCusNam1=PropertyFileReader.propertymap.get("InvestCusNam1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddCusBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath(InvstrSelInstlrDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(InvestInslrDD);
		driver.findElement(By.xpath(InvstrCusName)).sendKeys(InvestCusNam1);
		driver.findElement(By.xpath(InvstrCusChckBox)).click();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrCusSavBtn)).click();
	}


	@Test(priority = 17,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName=PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddCusBtn)).click();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element2.click();
		driver.findElement(By.xpath(InvstrActBckBtn)).click();
	}

	@Test(priority = 18,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/div/button")).click();
	}


	@Test(priority = 19,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestEmailId=PropertyFileReader.propertymap.get("InvestEmailId");
		String InvestPasswrd=PropertyFileReader.propertymap.get("InvestPasswrd");
		driver.findElement(By.xpath(SettingSymbol)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SignOutBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(Email)).sendKeys(InvestEmailId);
		driver.findElement(By.name(Password)).sendKeys(InvestPasswrd);
		driver.findElement(By.id(LoginBtn)).click();
	}

	@Test(priority = 20,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		String InvestTranDate=PropertyFileReader.propertymap.get("InvestTranDate");
		String InvestAmt=PropertyFileReader.propertymap.get("InvestAmt");
		String InvestBankName=PropertyFileReader.propertymap.get("InvestBankName");
		String InvestAccNum=PropertyFileReader.propertymap.get("InvestAccNum");
		String InvestRmrk=PropertyFileReader.propertymap.get("InvestRmrk");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		driver.findElement(By.xpath(InvstrTranEditbtn)).click();
		driver.findElement(By.name(InvstrTranDate)).sendKeys(InvestTranDate);
		driver.findElement(By.name(InvstrTranAmt)).sendKeys(InvestAmt);
		driver.findElement(By.name(InvstrTranBank)).sendKeys(InvestBankName);
		driver.findElement(By.name(InvstrTranAccNum)).sendKeys(InvestAccNum);
		driver.findElement(By.name(InvstrTranRemarks)).sendKeys(InvestRmrk);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrTranUpdBtn)).click();		
	}


	@Test(priority = 21,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		driver.findElement(By.xpath(InvstrTranEditbtn)).click();
		driver.findElement(By.xpath(InvstrTranEditBckBtn)).click();		
	}


	@Test(priority = 22,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		driver.findElement(By.xpath(InvstrDwldBtn)).click();		
	}	

	@Test(enabled = true,retryAnalyzer = ReRunFailedTestCase.class, description = "update button is not working",priority = 23)
	public void TC23() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		String InvestCusName=PropertyFileReader.propertymap.get("InvestCusName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrCusEditBtn)).click();
		driver.findElement(By.xpath(InvstrCusSrch)).sendKeys(InvestCusName);
		driver.findElement(By.xpath(InvstrCusSelBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		ele1=driver.findElement(By.xpath(InvstrCusUpdBtn));		
		try {
		    // Click the button
		    ele1.click();
		  } catch (Exception e) {
		    // Handle the exception and fail the test
		    fail("Button click failed with exception: " + e.getMessage());
		  }
	}


	@Test(priority = 24,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		String InvestInslrDD=PropertyFileReader.propertymap.get("InvestInslrDD");
		String InvestCusID1=PropertyFileReader.propertymap.get("InvestCusID1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddCusBtn)).click();
		driver.findElement(By.xpath(InvstrSelInstlrDD)).sendKeys(InvestInslrDD);
		driver.findElement(By.xpath(InvstrCusName)).sendKeys(InvestCusID1);
		driver.findElement(By.xpath(InvstrCusChckBox)).click();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element2.click();
		driver.findElement(By.xpath(InvstrCusSavBtn)).click();		
	}


	@Test(priority = 25,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddDocBtn)).click();
		driver.findElement(By.xpath(InvstrFileSaveBtn)).click();
		ele1=driver.findElement(By.xpath(InvstrFileToast));
		if(ele1.isDisplayed()) {
			System.out.println("Need to enter File name and it is mandatory");
		}


	}
	
	@Test(priority = 26,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		driver.findElement(By.xpath(InvstrViewBtn)).click();
		driver.findElement(By.xpath(InvstrDocUpdBtn)).click();		
	}

	@Test(priority = 27,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		driver.findElement(By.xpath(InvstrViewBtn)).click();
		driver.findElement(By.xpath(InvstrDocBckBtn)).click();		
	}

	@Test(priority = 28,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrDocDwldBtn)).click();		
	}

	@Test(priority = 29,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		String InvestFileName=PropertyFileReader.propertymap.get("InvestFileName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddDocBtn)).click();		
		driver.findElement(By.name(InvstrFileName)).sendKeys(InvestFileName);
		driver.findElement(By.xpath(InvstrFileUpldBtn)).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Desktop\\New XLSX Worksheet.xlsx";
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
		WebElement element3 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[3]/div[2]/div[1]/div/div/h6"));

		if(element3.isDisplayed()) {
			System.out.println("File uploaded sucessfully");
		}
		else {
			System.out.println("File not uploaded");
		}

		driver.findElement(By.name(InvstrShowDashBrdYes)).click();		
		driver.findElement(By.xpath(InvstrShowToInvstrNo)).click();	
		driver.findElement(By.xpath(InvstrFileAddSaveBtn)).click();		
	}

	@Test(priority = 30,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		driver.findElement(By.xpath(InvstrNewFeedViewIcon)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrNewFeedUpdBtn)).click();
	}
	
	@Test(priority = 31,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddFeedBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrAddFeedSaveBtn)).click();	
	}
	
	@Test(priority = 32,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC32() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		driver.findElement(By.xpath(InvstrNewFeedViewIcon)).click();
		driver.findElement(By.xpath(InvstrFeedClsBtn)).click();		
	}
	
	@Test(priority = 33,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		String InvestTitle=PropertyFileReader.propertymap.get("InvestTitle");
		String InvestNewsFeed=PropertyFileReader.propertymap.get("InvestNewsFeed");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddFeedBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(InvstrAddFeedTitBtn)).sendKeys(InvestTitle);
		driver.findElement(By.name(InvstrAddNewsFeedBtn)).sendKeys(InvestNewsFeed);
		driver.findElement(By.name(InvstrDashBrdYes)).click();
		driver.findElement(By.xpath(InvstrAddShwYes)).click();		
		driver.findElement(By.xpath(InvstrNewFeedSaveBtn)).click();	
	}
	
	
	@Test(priority = 34,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1=PropertyFileReader.propertymap.get("InvestName1");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrRepBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrSubBtn)).click();
	}
	
}