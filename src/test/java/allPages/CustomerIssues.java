package allPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerIssues extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1,ele2,ele3,ele4,ele5,ele6;

	@BeforeMethod
	public void setUp() throws IOException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
	//	option.addArguments("--headless=new");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize(); 
	//	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
	//	driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
		driver.get("http://192.168.1.36:90/#/auth");
		//driver.get("http://54.193.42.127:81/auth");
		File file=new File("C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOnee\\Data.properties");
		FileInputStream FIS=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(FIS);	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
	}

	@AfterMethod
	public void tearDown() throws IOException, InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}


	public static String generateRandomEmail() {
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder email = new StringBuilder();
		Random random = new Random();

		// Generate random username (8 characters)
		for (int i = 0; i < 8; i++) {
			email.append(characters.charAt(random.nextInt(characters.length())));
		}

		// Add "@" symbol
		email.append("@yopmail.com");
		return email.toString();
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 1)
	public void LoginBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
	}
	

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 2)
	public void TC02() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/select"));
		Select sel=new Select(ele1);
		ele2=sel.getFirstSelectedOption();
		String status = ele2.getText();
		System.out.println("Status of the dropdown is :" + status);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =3 )
	public void TC06() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form Click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Edit customer click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/div[1]/a/div/div")).click();
		//select customer portfolio
		ele2=driver.findElement(By.id("portfolio"));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(1);
		// portfolio edit button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[4]/div[4]/span")).click();
		//portfolio name
		ele3=driver.findElement(By.name("addPortfolio"));
		String text = ele3.getAttribute("value");
		System.out.println("Name from portfolio tab is : " + text);
		boolean displayed = ele3.isDisplayed();
		System.out.println(displayed);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =4 )
	public void TC10() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//Installer dropdown locator
		ele3=driver.findElement(By.name("installer"));
		Select sel2=new Select(ele3);
		sel2.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//ACH status dropdown locator
		ele1=	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//send to customer button
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//click change pay date
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/div/div[3]/a/div/div")).click();
		//check effective from date
		ele2=driver.findElement(By.name("effectivefrom"));
		String EffFromField = ele2.getAttribute("value");
		if(EffFromField.isEmpty()) {
			System.out.println("The field is empty.");
		}
		else {
			System.out.println("The field has a value: " + EffFromField);
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 5)
	public void TC03() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//monthly payment amount check
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div[2]/span"));
		String mnthlyPymtAmt = ele2.getText();
		System.out.println("Monthly payment value is shown as : " + mnthlyPymtAmt);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 6)
	public void TC17() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//ACH status dropdown locator
		ele1=	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//send to customer button
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//skip payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/div/div[4]/a/div/div")).click();
		ele2=driver.findElement(By.name("confirm"));
		boolean selected = ele2.isSelected();
		if (selected) {
			System.out.println("The checkbox is selected.");
		} else {
			System.out.println("The checkbox is not selected.");
		}		
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =7 )
	public void TC18() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =8 )
	public void TC19() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//ACH excel button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/button")).click();
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 9)
	public void TC23() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//No details found check
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/label"));
		String text = ele1.getText();
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("No Customer details is present. So page shows : " + text);
		}

		else {
			System.out.println("Customer details are shown without any issues");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 10)
	public void TC27() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Create Invoice button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[5]/a/span[2]")).click();
		//No details found check
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/p"));
		String text = ele1.getText();
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("No Customer details is present. So page shows : " + text);
		}

		else {
			System.out.println("Customer details are shown without any issues");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =11 )
	public void TC40() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//Customers Button
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		Thread.sleep(3000);
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Document setup click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/a[3]/div/div/div")).click();
		//file upload button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/label/div/h6")).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Desktop\\New XLSX Worksheet";
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
		//Click agree button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[4]/div/input")).click();
		Thread.sleep(2000);
		//click save button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[5]/button")).click();
		Thread.sleep(7000);
		//click document delete button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div/table/tbody/tr[1]/td[7]/i")).click();
		Thread.sleep(3000);
		//delete message toast
		ele2=driver.findElement(By.xpath("//div[text()='Deleted Successfully']"));
		String text = ele2.getText();
		if(ele2.isDisplayed()) {
			System.out.println("\033[1mDeleted toast appears like : \033[0m" + text);
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 12)
	public void TC45() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//Status dropdown locator
		ele1=	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("All");
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr[1]/td[10]/a/span/span")).click();
		//monthly payment amount check
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[1]/div/div[2]/div[2]/div/span"));
		String mnthlyPymtAmt = ele2.getText();
		System.out.println("\033[1m Monthly payment value is shown as : \033[0m" + mnthlyPymtAmt);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 13)
	public void TC01() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String CustmrId=PropertyFileReader.propertymap.get("CustmrId");
		String CustmrName=PropertyFileReader.propertymap.get("CustmrName");
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
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
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
		sel1.selectByIndex(1);

		ele2=driver.findElement(By.name(CusPort));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(1);

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
		driver.findElement(By.xpath(CusAddSavBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 14)
	public void TC04() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//Customers Button
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Upload
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[3]/a/span[2]")).click();
		//Installer button
		ele1 = driver.findElement(By.xpath("//*[@id=\"installer\"]"));
		Select sel=new Select(ele1);
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/label/div/h6")).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Desktop\\New XLSX Worksheet";
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
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[3]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[1]/div/div[3]/button")).click();
		Thread.sleep(2000);
		//		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/div/div/div/span/span"));
		//		String text = ele2.getText();
		//		System.out.println(text);
		//		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/table/tbody/tr[1]/td[3]/a"));
		//		String text2 = ele3.getText();
		//		System.out.println(text2);
		//		Thread.sleep(2000);
		//		if(text.contains(text2)) {
		//			System.out.println("File is uploaded");	
		//		}
		//		else {
		//			System.out.println("File is not uploaded");
		//		}
		//		ele4=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[1]/div/div[3]/button"));
		//		ele4.click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =15 )
	public void DateCheck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//Customers Button
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(0);
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a/span")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/div[1]/a/div/div")).click();
		ele3=driver.findElement(By.name("ptodate"));
		ele3.sendKeys("11-04-2024");
		String text = ele3.getText();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		ele4=driver.findElement(By.name("ptodate"));
		String text1 = ele4.getText();
		Thread.sleep(2000);
		if(text==text1) {
			System.out.println("Dates are shown same");
		}
		else {
			System.out.println("Both dates are not same");
		}
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 16)
	public void SwapOutChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//Customers Button
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(0);
		//Customer edit button
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[2]/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Customer Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Swap out button check
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/a[4]/div/div/div")).click();
		Thread.sleep(2000);
		//Swap yes button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/input")).click();
		//Agree button check
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div/div[4]/div[2]/div/input")).click();
		//Save button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div/div[5]/div[2]/button")).click();
		//Error toast check
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div/div[3]/div[2]/div[2]"));
		if(ele3.isDisplayed()) {
			System.out.println("Error message is displayed");
			String text = ele3.getText();
			System.out.println(text);
		}
		else {
			System.out.println("Error message is not displayed");
		}
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =17 )
	public void EscProgChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//Customers Button
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(0);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(0);
		//Customer edit button
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[2]/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Customer Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Escalation Program button check
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/a[5]/div/div/div")).click();
		//Date check
		driver.findElement(By.id("selectedDate")).sendKeys("11-04-2024");
		//Calculate button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[5]/button")).click();
		//Element is opened or not
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/a"));
		if(ele3.isDisplayed()) {
			System.out.println("Calculate button is working");
		}
		else {
			System.out.println("Calculate button is not working");
		}
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 18)
	public void CGIDrpDwnChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//ACH status dropdown locator
		ele1=	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(0);
		//Customer Edit button
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		ele3=driver.findElement(By.id("depositaccount"));
		String text = ele3.getAttribute("value");
		System.out.println(text);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =19 )
	public void StopPyMnt() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//Installer Dropdown
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status dropdown
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("Released");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//Create Invoice Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a/span"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div")).click();
		//stop payment calendar
		driver.findElement(By.name("stopsfrom")).sendKeys("Apr/2024");
		//Reason button
		driver.findElement(By.name("Reason")).sendKeys("Test");
		//Agree button
		driver.findElement(By.name("confirm")).click();
		//Stop Payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div/div[4]/button")).click();
		//		//Act back button
		//		Thread.sleep(2000);
		//		WebElement element1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/a"));
		//		Actions act1=new Actions(driver);
		//		act1.click().build().perform();
		//		element1.click();
		//		//Back button check
		//		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/div/a/div/div/div")).click();

		//Start payment
		//		ele3=driver.findElement(By.name("effectivefrom"));
		//		ele3.sendKeys("Apr/2024");
		//		String text = ele3.getText();
		//		//Reason button
		//		driver.findElement(By.name("Reason")).sendKeys("Test");
		//		//Agree button
		//		driver.findElement(By.name("confirm")).click();
		//		//Start payment button
		//		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div[4]/button")).click();
		//		//Text check
		//		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[4]/div/table/tbody/tr[1]/td[2]"));
		//		String text2 = ele4.getText();
		//		Thread.sleep(2000);
		//		if(text==text2) {
		//			System.out.println("Both dates are same");
		//		}
		//		else {
		//			System.out.println("Dates are diffrent");
		//		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 20)
	public void EditInstlrIssue() throws InterruptedException{
		LoginBtn();
		String PortfolioName=PropertyFileReader.propertymap.get("PortfolioName");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//customer action button
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Edit customer
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/div[1]/a/div/div")).click();
		//Add portfolio button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[4]/div[3]")).click();
		//enter new portfolio name
		ele2=driver.findElement(By.name("addPortfolio"));
		ele2.sendKeys(PortfolioName);
		Thread.sleep(2000);
		String text = ele2.getAttribute("value");
		System.out.println(text);
		Thread.sleep(2000);
		//save button
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/button[2]")).click();
		//customer porfolio button dropdown
		ele3=driver.findElement(By.id("portfolio"));
		String text1 = ele3.getAttribute("value");
		Thread.sleep(2000);
		if(text==text1) {
			System.out.println("\033[1m Both names are same \033[0m");

		}
		else {
			System.out.println("\033[1m Both names are diffrent \033[0m");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 21)
	public void NewUsrTimIsue() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ViewUserBtn)).click();
		String Userrole=PropertyFileReader.propertymap.get("Userrole");
		String VisibleTextIU=PropertyFileReader.propertymap.get("VisibleTextIU");		
		String PhoneNo=PropertyFileReader.propertymap.get("PhoneNo");
		String address1=PropertyFileReader.propertymap.get("address1");
		String address2=PropertyFileReader.propertymap.get("address2");
		String city=PropertyFileReader.propertymap.get("city");
		String zipCode=PropertyFileReader.propertymap.get("zipCode");
		Thread.sleep(2000);
		driver.findElement(By.xpath(AddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(FirstName)).sendKeys("Test121");
		driver.findElement(By.name(LastName)).sendKeys("T1");
		ele3=driver.findElement(By.name(EmailField));
		String email =generateRandomEmail();
		ele3.sendKeys(email);
		driver.findElement(By.name(UserRole)).sendKeys(Userrole);
		ele1= driver.findElement(By.name("status"));
		Select select=new Select(ele1);
		select.selectByVisibleText(VisibleTextIU);
		Thread.sleep(2000);
		driver.findElement(By.name(PhoneNum)).sendKeys(PhoneNo);
		driver.findElement(By.name(Address1)).sendKeys(address1);
		driver.findElement(By.name(Address2)).sendKeys(address2);
		driver.findElement(By.name(City)).sendKeys(city);
		driver.findElement(By.name(ZipCode)).sendKeys(zipCode);
		driver.findElement(By.xpath(SaveBtn)).click();
		Thread.sleep(2000);
		LocalDateTime startTime = LocalDateTime.now();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Saved Successfully']")));
		LocalDateTime endTime = LocalDateTime.now();
		double between = ChronoUnit.MILLIS.between(startTime, endTime);
		System.out.println("Time takes to create a user is : " + between/1000 + "sec");
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 22)
	public void EmailNotifChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(ViewUserBtn)).click();
		ele1=driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys("thirumaran@yopmail.com");
		driver.findElement(By.xpath(ViewUserBtn)).click();
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();	
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[4]/a")).click();
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/div[3]/div[2]/div/div[1]/div[1]/div/span"));
		if(ele2.isDisplayed()) {
			System.out.println("Page displayed all details without any issues");
		}
		else {
			System.out.println("Page doesnot show any details");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 23)
	public void UserIDCheck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(ViewUserBtn)).click();
		ele1=driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(EmailId);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[3]/div"));
		String text = ele2.getText();
		System.out.println(text);
		System.out.println(EmailId);
		Thread.sleep(3000);
		if(text.equals(EmailId)) {
			System.out.println("Username shows same");
		}
		else {
			System.out.println("Username shows diffrent");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 24)
	public void LastModifiedChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(ViewUserBtn)).click();
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/span[2]/div/select"));
		Select sel=new Select(ele2);
		sel.selectByVisibleText("ALL");
		ele1=driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys("thirumaran1995@outlook.com");
		//edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[8]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Access rights button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[3]/a/span")).click();
		Thread.sleep(4000);
		//get the text in botton last modified by
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/div[4]/p/span"));
		String text = ele3.getText();
		System.out.println(text);
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 25)
	public void DisableChck1() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(BankSetupBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[1]/div[2]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AddAccntBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div[2]/div[2]/div/span/label"));
		Thread.sleep(2000);
		String Acttext = ele1.getText();
		System.out.println(Acttext);
		Thread.sleep(2000);
		String ExpText="Disable";
		Thread.sleep(2000);
		if(ExpText.equals(Acttext)) {
			System.out.println("Spelling is correct");
		}
		else {
			System.out.println("Spelling is not correct");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 26)
	public void DisableChck2() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(BankSetupBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[1]/div[2]/div/button")).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[5]/div[2]/div/span/label"));
		Thread.sleep(2000);
		String Acttext = ele1.getText();
		System.out.println(Acttext);
		Thread.sleep(2000);
		String ExpText="Disable";
		Thread.sleep(2000);
		if(ExpText.equals(Acttext)) {
			System.out.println("Spelling is correct");
		}
		else {
			System.out.println("Spelling is not correct");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 27)
	public void InvstClrBtnChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath(InstallerBtn)).click();
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys("Tester");
		driver.findElement(By.xpath(InstEditBtn)).click();
		//invs edit button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/table/tbody/tr/td[9]/span/a/span")).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[6]/div/div/div/span"));
		String text = ele1.getText();
		System.out.println(text);
		//Clear button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[7]/button[1]")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 28)
	public void APIStupClrBtn() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[6]/div/div[4]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/button")).click();
		ele1=driver.findElement(By.id("dropdownValue"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
		ele2=driver.findElement(By.id("crmdropdownValue"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("Tester");
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div/div[4]/div[2]/div/label/div/h6")).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Pictures\\Screenshots\\Image.png";
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
		//Clear button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div/div[5]/button[1]")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 29)
	public void APIStupSavBtn() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[6]/div/div[4]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/button")).click();
		ele1=driver.findElement(By.id("dropdownValue"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
		ele2=driver.findElement(By.id("crmdropdownValue"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("Testing");
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div/div[4]/div[2]/div/label/div/h6")).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Pictures\\Screenshots\\Image.png";
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
		//Save button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div/div[5]/button[2]")).click();
		Thread.sleep(2000);
		//saved pop up message
		ele3=driver.findElement(By.xpath("//div[text()='Saved Successfully']"));
		if(ele3.isDisplayed()) {
			System.out.println("Save function is working without any issues");
		}
		else {
			System.out.println("Save function is not working");
		}
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 30)
	public void ACHUpldPopUpChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(4000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Upload
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[3]/a/span[2]")).click();
		//Installer DD
		ele1=driver.findElement(By.id("installer"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/label/div/h6")).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Desktop\\New XLSX Worksheet";
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
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[1]/div/div[3]/button"));
		if(ele2.isDisplayed()) {
			System.out.println("Alert pop up is shown");
		}
		else {
			System.out.println("Alert pop up is not shown");
		}
		ele2.click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 31)
	public void CrtInvNoDataChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(4000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Create Invoice
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[5]/a/span[2]")).click();
		//When no data is created
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/p"));
		if(ele1.isDisplayed()) {
			System.out.println("Header is not displayed when no datas is added");
		}
		else {
			System.out.println("Header is if Found");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 32)
	public void CrtInvDueMonth() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(4000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Create Invoice
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[5]/a/span[2]")).click();
		//select installer
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//edit button
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[9]/div/div/a/span")).click();
		//Add line items click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div/a")).click();
		//manual entry click
		driver.findElement(By.name("no")).click();
		//Due date check
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/div/div/input"));
		ele1.sendKeys("Apr/2024");
		String attribute = ele1.getAttribute("value");
		System.out.println(attribute);
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 33)
	public void PayOffChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(4000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer List Click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer Dropdown
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Customer edit button
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Customer Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Edit customer
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/div[1]/a/div/div")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		//Payoff Yes button click
		driver.findElement(By.name("payYes")).click();
		Thread.sleep(2000);
		//Details check
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[39]/div[2]/label"));
		String TransDate = ele2.getText();
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[40]/div[2]/label"));
		String Amount = ele3.getText();
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[41]/div[2]/label"));
		String Remarks = ele4.getText();
		System.out.println("All text are : " + TransDate +", "+ Amount+", "+ Remarks);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 34)
	public void EscProgCaptchaChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(4000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer List Click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer Dropdown
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testing");
		//Customer edit button
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Customer Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Escalation Program click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/a[5]/div/div/div")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 35)
	public void StartPyChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		//Customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//Installer Dropdown
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status dropdown
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("All");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//Create Invoice Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a/span"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Stop Invoice Payment click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div")).click();
		//Stop payment page check
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[1]/h3"));
		String StopPyPage = ele3.getText();
		System.out.println(StopPyPage);
		//stops from date
		driver.findElement(By.name("stopsfrom")).sendKeys("Apr/2024");
		//Reson enter
		driver.findElement(By.name("Reason")).sendKeys("Test");
		//Confirm button click
		driver.findElement(By.name("confirm")).click();
		//Stop payment click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div/div[4]/button")).click();
		//Start payment page check
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[1]/h3"));
		String StartPyPage = ele4.getText();
		System.out.println(StartPyPage);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 36)
	public void EdtPyCusNameChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		//Customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//Installer Dropdown
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status dropdown
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("All");
		Thread.sleep(2000);
		//customer name find
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr[1]/td[2]/a"));
		String ExpText = ele3.getText();
		System.out.println(ExpText);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//Create Invoice Action button
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a/span"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Edit Payment click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[1]/a/div/div")).click();
		//customer name check
		ele4=driver.findElement(By.name("customername"));
		String ActText=	ele4.getAttribute("value");
		System.out.println(ActText);
		Thread.sleep(2000);
		if(ExpText.equals(ActText)) {
			System.out.println("Username is shows without any issues and it is same");
		}
		else {
			System.out.println("Username is not shown or diffrent");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 37)
	public void DsblUsrChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath(InstallerBtn)).click();
		driver.findElement(By.xpath("//input[@class='form-control form-control-solid w-250px ps-14 fs-7']")).sendKeys("Testing");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[8]/div/div/a/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[5]/div/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[5]/div/div/div/div[1]/div/div")).click();
		driver.findElement(By.name("no")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[6]/div/div[3]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input")).sendKeys("Testing");
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/span[2]/div/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("ALL");
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div/table/tbody/tr[1]/td[3]/a"));
		Thread.sleep(2000);
		if(ele2.isDisplayed()) {
			System.out.println("Disabled name is shown with details");
		}
		else {
			System.out.println("Disabled name details are not shown");
		}
		//again change disabled to enabled
		Thread.sleep(4000);
		driver.findElement(By.xpath(InstallerBtn)).click();
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/span[2]/div/select"));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText("DISABLED");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='form-control form-control-solid w-250px ps-14 fs-7']")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[8]/div/div/a/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[5]/div/div/a"));
		Actions act1=new Actions(driver);
		act1.click().build().perform();
		element1.click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[5]/div/div/div/div[1]/div/div")).click();
		driver.findElement(By.name("yes")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[3]/button[2]")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 38)
	public void CusPortEditChck() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CustomerBtn)).click();
		driver.findElement(By.xpath(CusListBtn)).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Edit customer click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/div/div[1]/a/div/div")).click();
		//Customer portfolio name check
		ele2=driver.findElement(By.id("portfolio"));
		Select sel2=new Select(ele2);
		ele3 = sel2.getFirstSelectedOption();
		if(ele3!=null) {
			String text = ele3.getText();
			System.out.println("Dropdown shows like : " +  text);
		}
		else {
			System.out.println("Customer Portfolio name is displayed without any issues");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =39 )
	public void ACHMailTimeChckS2Cus() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CustomerBtn)).click();
		driver.findElement(By.xpath(ACHFormBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByIndex(1);
		//driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[4]/input")).sendKeys("Test");
		//click edit icon
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//click send  to customer
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[1]/input")).click();
		//click update button
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		Instant startTime = Instant.now();

		//click send button
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[8]/div/button"));
		ele3.click();
		//Find the duration of confirmation message display on the screen
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Email Sent Successfully']")));
		Instant endTime = Instant.now();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Time taken for confirmation message: " + duration.getSeconds() + " seconds");
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 40)
	public void ACHMailTimeChckS2Sale() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CustomerBtn)).click();
		driver.findElement(By.xpath(ACHFormBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByIndex(1);
		//driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[4]/input")).sendKeys("Test");
		//click edit icon
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//click send  to sale
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[2]/input")).click();
		//click update button
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		Instant startTime = Instant.now();

		//click send button
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_account_deactivate_account_submit\"]"));
		ele3.click();
		//Find the duration of confirmation message display on the screen
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Email Sent Successfully']")));
		Instant endTime = Instant.now();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Time taken for confirmation message: " + duration.getSeconds() + " seconds");
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 41)
	public void QuckUpldChck() throws InterruptedException, AWTException{
		LoginBtn();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		Thread.sleep(3000);
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(ViewUserBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input")).sendKeys(EmailId);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[2]/div/div/a"));
		String text = ele3.getText();

		Thread.sleep(3000);
		driver.findElement(By.xpath(CustomerBtn)).click();
		driver.findElement(By.xpath(InvoicePayBtn)).click();
		Thread.sleep(3000);
		ele1=driver.findElement(By.xpath(IPBankDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(3000);
		ele2=driver.findElement(By.xpath(IPPySts));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("Released");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//quick book upload button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[4]/a/div/div")).click();
		//attach file button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/label/div/h6")).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\Desktop\\New XLSX Worksheet";
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
		//submit button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/button")).click();
		//user name check in uploaded by column
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[3]/a"));
		String text2 = ele4.getText();
		Thread.sleep(2000);
		if(text.equals(text2)) {
			System.out.println("File uploaded sucessfully");
		}
		else {
			System.out.println("File is not uploaded");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 42)
	public void AddToLstChckPymtChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[6]/a/span[2]")).click();
		//add button
		driver.findElement(By.xpath(CPAddBtn)).click();
		//Select installer
		ele1=driver.findElement(By.xpath(CPAddInstDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Customer name
		driver.findElement(By.xpath(CPAddCustName)).sendKeys("TEST(11)");
		//Search button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/button")).click();
		Thread.sleep(2000);
		//click add due month
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[2]/div[7]/div[3]/div[2]/div/a/a")).click();
		//enter month details
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[2]/div[7]/div[3]/div[2]/div/a/a")).sendKeys("April,2024");
		//Click add to list button
		// nEed to complete
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/button")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority = 43)
	public void FailedStsChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath(ACHTransBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/select"));
		Select sel=new Select(ele1);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Failed");
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[3]/div/label"));
		if(ele3.isDisplayed()) {
			String text = ele3.getText();
			System.out.println("Failed Customer details are not shown and also it shows like : " + text);
		}
		else {
			System.out.println("Failed Customer details are shown");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =44)
	public void ReTrnACHSrchChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReportsBtn)).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[2]/div/div[4]/a/span[2]")).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("Testingg");
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/select"));
		Select sel2=new Select(ele2);
		sel2.selectByIndex(2);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =45)
	public void TotalValueChckInMonitoring() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Overall stats button
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[1]/a/span[2]")).click();
		//total value element
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[1]/div/div[4]/div[3]/label"));
		String text = ele1.getText();
		if(ele1.isDisplayed()) {
			System.out.println("Total value is : " + text);
		}
		else {
			System.out.println("Total vlaue is not displayed");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =46)
	public void ProdStsChckInMonitoring() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Production stats check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[2]/a/span[2]")).click();
		//Investor drop down.
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[2]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("LA SOLAR");
		Thread.sleep(8000);
		//production % dropdown
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("=");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div/div[3]/input")).sendKeys("50000");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div/div[6]/button")).click();
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[3]/div/label"));
		Thread.sleep(2000);
		boolean displayed = ele3.isDisplayed();
		System.out.println(displayed);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =47)
	public void ProdStsExportChckInMonitoring() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Production status check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[2]/a/span[2]")).click();
		//Export button click
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[6]/button"));
		ele1.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ele1));
		System.out.println("Button is clickable!");
		button.click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =48)
	public void CustStsSysProfChckInMonitoring() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Customer status button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[3]/a/span[2]")).click();
		//Installer name 
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[1]/div/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("LA SOLAR");
		//customer name enter
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[2]/div/div/input")).sendKeys("Aaron Kaplowitz(E2Y4JDBt2Pm)");
		//search button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/button")).click();
		Thread.sleep(3000);
		//Customer Profile arrow button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[2]/div/span[2]/i")).click();
		//Temp value check
		ele2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[4]/div[2]/label"));
		boolean displayed1 = ele2.isDisplayed();
		ele3=driver.findElement(By.xpath("//*[@id=\"simple-popover\"]/div[3]/div/div/div[2]/div[5]/div[2]/label"));
		boolean displayed2 = ele3.isDisplayed();
		ele4=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[4]/div[2]/label"));
		boolean displayed3 = ele4.isDisplayed();
		ele5=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[4]/div[2]/label"));
		boolean displayed4 = ele5.isDisplayed();
		ele6=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[4]/div[2]/label"));
		boolean displayed5 = ele6.isDisplayed();
		System.out.println(displayed1);
		System.out.println(displayed2);
		System.out.println(displayed3);
		System.out.println(displayed4);
		System.out.println(displayed5);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =49)
	public void InvertorManChckInMonitoring() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Invertor button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[5]/a/span[2]")).click();
		//search Invertor Name
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[1]/div/input")).sendKeys("Checking Invertor");
		//Edit button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[3]/div/table/tbody/tr/td[7]/span")).click();
		//Title name check
		ele1=driver.findElement(By.name("Title"));
		String textValue1 = ele1.getAttribute("value"); // Getting the current text
		if (textValue1.isEmpty()) {
			System.out.println("Text box is empty.");
		} else {
			System.out.println("Text box contains value: " + textValue1);
		}

		//Model name check
		ele2=driver.findElement(By.name("Model"));
		String textValue2 = ele2.getAttribute("value"); // Getting the current text
		if (textValue2.isEmpty()) {
			System.out.println("Text box is empty.");
		} else {
			System.out.println("Text box contains value: " + textValue2);
		}

		//Title name check
		ele3=driver.findElement(By.name("Ratingac"));
		String textValue3 = ele3.getAttribute("value"); // Getting the current text
		if (textValue3.isEmpty()) {
			System.out.println("Text box is empty.");
		} else {
			System.out.println("Text box contains value: " + textValue3);
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =50)
	public void InvertorUpdtChckInMonitoring() throws InterruptedException, AWTException, TimeoutException{
		InvertorManChckInMonitoring();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div[19]/button[2]")).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//div[text()='Updated Successfully']"));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Update is Successfully done");
		}
		else {
			System.out.println("Update is not Successful");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =51)
	public void PanelAddChckInMonitoring() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Panel button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[6]/a/span[2]")).click();
		//Add button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[1]/div/div/a/a")).click();
		//Title name enter
		driver.findElement(By.name("Title")).sendKeys("Test");
		driver.findElement(By.name("Make")).sendKeys("Test");
		driver.findElement(By.name("Model")).sendKeys("Test");
		driver.findElement(By.name("Collector")).sendKeys("Test");
		driver.findElement(By.name("Height")).sendKeys("Test");
		driver.findElement(By.name("Width")).sendKeys("Test");
		driver.findElement(By.name("WattSTC")).sendKeys("Test");
		driver.findElement(By.name("ModuleEff")).sendKeys("Test");
		driver.findElement(By.name("Noct")).sendKeys("Test");
		driver.findElement(By.name("tempcoeff")).sendKeys("Test");
		driver.findElement(By.name("Bo")).sendKeys("Test");
		driver.findElement(By.name("Degradefirst")).sendKeys("Test");
		driver.findElement(By.name("Degradeannual")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div[27]/button[2]")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =52)
	public void PanelUpdChckInMonitoring() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//monitoring button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/span/span[2]")).click();
		//Panel button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[3]/div/div[6]/a/span[2]")).click();
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[3]/div/table/tbody/tr[1]/td[7]/span")).click();
		//Update button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div[27]/button[2]")).click();
		//getting Successfully message
		ele1=driver.findElement(By.xpath("//div[text()='Updated Successfully']"));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Updated Successfully message is shown");
		}
		else {
			System.out.println("Updated Message is not shown");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "scripts created with help of 54 server",priority =53)
	public void TimShtChck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//Time sheet button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[8]/span/span[2]")).click();
		//My Time sheet button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[8]/div/div[1]/a/span[2]")).click();
		//Export Excel button click
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[1]/div/div[1]/div[4]/button"));
		ele1.click();
		try {
			Thread.sleep(5000); // Wait for 5 seconds (adjust this according to your download speed)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String downloadPath = "C:\\Users\\thirumaran\\Downloads";
		//Filename should change everyday
		String fileName = "TimesheetApr2024_20240422";
		File downloadedFile = new File(downloadPath + File.separator + fileName);
		if (downloadedFile.exists()) {
			System.out.println("File has been downloaded successfully.");
		} else {
			System.out.println("File download failed or hasn't completed yet.");
		}
	}															

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =54)
	public void LineItemChck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Create Invoice Click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[5]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.name("installer"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Payment type select
		ele2=driver.findElement(By.name("type"));
		Select sel1=new Select(ele2);
		sel1.selectByIndex(0);
		//Choose customer 
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[4]/input")).sendKeys("Tester");
		//edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[9]/div/div/a/span")).click();
		//click Add line items
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div/a")).click();
		Thread.sleep(2000);
		//click manual entry button
		driver.findElement(By.name("no")).click();
		//enter Due month 
		driver.findElement(By.name("duemonth")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[3]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[1]/div")).click();
		Thread.sleep(2000);
		//Enter desription
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div/input")).sendKeys("NewTest");
		//Enter amount
		String amount="$3,000.00";
		driver.findElement(By.name("amount")).sendKeys(amount);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[5]/button[2]/span")).click();
		Thread.sleep(10000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[4]/div"));
		String text = ele3.getText();
		System.out.println(text);
		System.out.println(amount);
		Thread.sleep(3000);
		if(text.equals(amount)) {
			System.out.println("Entered amount correctly shown");
		}
		else {
			System.out.println("Diffrent value is shown");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =55)
	public void AttachChck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Check payments click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[6]/a/span[2]")).click();
		//add button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a/div/button")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[1]/div/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Customer name select
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[2]/div/div/input")).sendKeys("TEST(11)");
		//search button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/button")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[2]/label/div/p")).click();
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
		ele2=driver.findElement(By.name("check"));
		ele2.click();
		ele2.sendKeys("123654");
		driver.findElement(By.name("checkdate")).sendKeys("23-04-2024");
		driver.findElement(By.name("amount")).sendKeys("3500");
		driver.findElement(By.name("nameaccount")).sendKeys("NewCustomer");
		driver.findElement(By.name("bankaccountnumber")).sendKeys("0123456789");
		driver.findElement(By.name("bankroutingnumber")).sendKeys("987654321");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[3]/div[3]/div/div/div[1]/div/div/div/input")).click();
		driver.findElement(By.xpath(CPCusEditSavBtn)).click();
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[2]/div[1]/div/div/span/div"));
		boolean displayed = ele3.isDisplayed();
		System.out.println("Attached file displayed is : " + displayed);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =56)
	public void ACH_CC_Clr_Chck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH form click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.name("installer"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.name("type"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("ACH Pending");
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Send to customer click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[1]/input")).click();
		//update button click
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		//Clear the CC Tab
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/div/input"));
		ele3.clear();
		//check tab is empty or not
		Thread.sleep(2000);
		String attribute = ele3.getAttribute("value");
		if(attribute.isEmpty()) {
			System.out.println("CC Text box is cleared");
		}
		else {
			System.out.println("CC Text box is not cleared");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =57)
	public void ACHSendMailPageChck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH form click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.name("installer"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.name("type"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("ACH Pending");
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//Send to customer click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[1]/input")).click();
		//update button click
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(4000);
		//click send button
		ele4=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[8]/div/button"));
		ele4.click();
		Thread.sleep(10000);
		//Check next page is displayed or not
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[2]/div/div[1]/div[1]/div/h2/span"));
		Thread.sleep(2000);
		if(ele3.isDisplayed()) {
			System.out.println("Mail has been sent successfully");
		}
		else {
			System.out.println("Mail is not sent to the customer");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =58)
	public void ACHInvPayCaldrChck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice Pay click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.name("installer"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.name("type"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Released");
		//Search Name
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(3000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		//Click Stop invoice payment
		//Because once stopped then only start the invoice payment is enabled
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div")).click();
		//Stop From
		driver.findElement(By.name("stopsfrom")).sendKeys("May/2024");
		//Reason
		driver.findElement(By.name("Reason")).sendKeys("Test");
		//Agree button click
		driver.findElement(By.name("confirm")).click();
		//Stop Payment
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div/div[4]/button")).click();
		System.out.println("--------------------Payment stopped------------------------");
		//check calendar tab is enabled or not
		ele3=driver.findElement(By.name("effectivefrom"));
		Thread.sleep(2000);
		if(ele3.isEnabled()) {
			System.out.println("Calendar tab is enabled");
		}
		else {
			System.out.println("Calendar tab is not enabled");
		}
		ele3.sendKeys("Apr/2024");
		//Reason
		driver.findElement(By.name("Reason")).sendKeys("Test");
		//Agree button click
		driver.findElement(By.name("confirm")).click();
		//Start Payment
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div[4]/button")).click();
		System.out.println("--------------------Payment started--------------------");
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =59)
	public void ACHUpldSucsChck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Upload click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[3]/a/span[2]")).click();
		Thread.sleep(3000);
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"installer\"]"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Upload file
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/label/div/h6")).click();
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
		//submit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[3]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[1]/div/p")));
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[1]/div/div[1]/p[2]"));
		String SuccessCount = ele2.getText();
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/p[2]"));
		String ErrorCount = ele3.getText();
		Thread.sleep(2000);
		if(!(SuccessCount.equals("1"))) {
			System.out.println("Success Count shows wrong value");
			System.out.println("Success Count shows : " + SuccessCount);
			System.out.println("Error Count shows : " + ErrorCount);
		}
		else {
			System.out.println("Success count shows correct value");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =60)
	public void ACHUpldSndToSal_CC_Chck() throws InterruptedException, AWTException, TimeoutException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form Click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.name("type"));
		Select sel1=new Select(ele2);
		sel1.selectByIndex(0);
		//search button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[4]/input")).sendKeys("Tester");
		//edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//send to sales button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/span[2]/input")).click();
		//update button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button")).click();
		//Clear TO Tab
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[1]/div/input"));
		ele3.clear();
		//check CC Tab
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/div/input"));
		String attribute = ele4.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(2000);
		if(attribute.isEmpty()) {
			System.out.println("CC Tab also cleared once clear TO Tab");
		}
		else {
			System.out.println("CC Tab is not cleared");
		}
	}

	//	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	//	public void CusAddPhNumChck() throws InterruptedException {
	//		CustomerList CL=new CustomerList();
	//		CL.CusAddDetailsFull();
	//		driver.findElement(By.xpath(CusAddSavBtn)).click();
	//	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =61)
	public void CusAddPTOChck() throws InterruptedException {
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//List button Click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
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
		String CustPhone1=PropertyFileReader.propertymap.get("CustPhone1");
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
		Thread.sleep(2000);
		ele1=driver.findElement(By.name(CusInstDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);
		Thread.sleep(2000);
		ele2=driver.findElement(By.name(CusPort));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(CustPort);
		Thread.sleep(2000);
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.xpath(CusTypLTF)).click();
		driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone1);
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
		Thread.sleep(2000);
		ele5=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[1]/div[2]/span"));
		String text = ele5.getText();
		Thread.sleep(2000);
		if(text.equals("-")) {
			System.out.println("PTO Date is not shown and it is correct");
		}
		else {
			System.out.println("PTO Date is shown");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =62)
	public void CrteInvLineItemChck() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Create Invoice
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[5]/a/span[2]")).click();
		Thread.sleep(2000);
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByIndex(0);
		//search name
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div/div[4]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[9]/div/div/a/span")).click();
		//Add line items click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div/a")).click();
		//manual entry click
		driver.findElement(By.name("no")).click();
		//Due date enter
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/div/div/input")).click();
		//April button click
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[3]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[1]/div")).click();
		Thread.sleep(2000);
		//enter description
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div/input")).sendKeys("Test");
		Thread.sleep(2000);
		//Enter amount
		driver.findElement(By.name("amount")).sendKeys("12345");
		//click save button
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[5]/button[2]/span")).click();
		Thread.sleep(10000);
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[2]/td[4]"));
		boolean displayed = ele4.isDisplayed();
		System.out.println("Total value displayed is : " + displayed);
		String text = ele4.getText();
		System.out.println("Total value displayed is : " + text);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =63)
	public void CrteInvPrvwInvChk() throws InterruptedException, AWTException{
		CrteInvLineItemChck();
		Thread.sleep(2000);
		//Preview Invoice click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/a/div/button")).click();
		Thread.sleep(2000);
		//Getting Due month text in Preview Invoice
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[1]/td[2]/div"));
		String text = ele1.getText();
		Thread.sleep(2000);
		String DueMonth="Apr/2024";
		if(DueMonth.equals(text)) {
			System.out.println("Same Due month is shown");
		}
		else {
			System.out.println("Diffrent Due month is shown");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =74)
	public void CrteInvPrvInvNotsChk() throws InterruptedException, AWTException{
		CrteInvLineItemChck();
		Thread.sleep(2000);
		//Notes enter
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/div[3]/textarea")).sendKeys("Test");
		Thread.sleep(2000);
		//Preview Invoice click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/a/div/button")).click();
		//Notes check
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[2]/div/div[2]/div/div[5]/div[2]"));
		String text = ele1.getText();
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Notes is displayed");
			System.out.println("Notes is displayed like :" + text);
		}
		else {
			System.out.println("Notes is not displayed");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =64)
	public void CrteInvPrvInvBckBtnChk() throws InterruptedException, AWTException{
		CrteInvLineItemChck();
		Thread.sleep(2000);
		//Preview Invoice click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/a/div/button")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[2]/div/div[1]/div[2]/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Back button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[2]/div/div[1]/div[2]/div/a/div/div/div")).click();
		//Back button check
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/a/div/button"));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Back button is working perfectly");
		}
		else {
			System.out.println("Back button is not working");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =65, enabled=false,description="Add button is not working")
	public void ChckPayAddBtnChk() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Check payment button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[6]/a/span[2]")).click();
		//Add Button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a/div/button")).click();
		Thread.sleep(2000);
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[1]/div/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Customer name 
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[2]/div/div/input")).sendKeys("TEST(11)");
		//Search button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/button")).click();
		//Add file
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[2]/label/div/p")).click();
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
		ele1=driver.findElement(By.name(CPCusEdiChkNam));
		ele1.click();
		ele1.sendKeys("123abc");
		driver.findElement(By.name(CPCusEdiChkDate)).sendKeys("24-04-2024");
		driver.findElement(By.name(CPCusEdiChkAmt)).sendKeys("2000");
		driver.findElement(By.name(CPCusEdiNamAcc)).sendKeys("NewTest");
		driver.findElement(By.name(CPCusEdiBnkAcc)).sendKeys("01234567891");
		driver.findElement(By.name(CPCusEdiBnkAccRout)).sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[3]/div[3]/div/div/div[1]/div/div/div/input")).click();
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		ele3=driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Save']"));
		boolean displayed = ele3.isEnabled();
		System.out.println(displayed);
		//Check Add button status
		ele2=driver.findElement(By.xpath("//div[text()='Saved Successfully']"));
		Thread.sleep(2000);
		if(ele3.isEnabled())
		{
			ele3.click();
			if(ele2.isDisplayed()) {
				System.out.println("Add button is working");
			}
		}
		else {
			System.out.println("Button is not working");
		}

	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =66)
	public void InvPyDateChk() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Edit payments button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[1]/a/div/div")).click();
		//Check Invoice date is displayed or not
		ele3=driver.findElement(By.xpath("//*[@id=\"paydate\"]"));
		boolean displayed = ele3.isDisplayed();
		System.out.println("Invoice date is displayed : "+ displayed);
		String attribute = ele3.getAttribute("value");
		System.out.println("Displayed Invoice date is : " + attribute);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =67)
	public void InvPyAddChrgChk() throws InterruptedException, AWTException{
		InvPyDateChk();
		Thread.sleep(2000);
		//Scroll into middle of the page 
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[3]/div[2]/label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(4000);
		//Yes button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[6]/div[3]/div[2]/div/input")).click();
		Thread.sleep(2000);
		//Additional charge
		driver.findElement(By.name("additionalcharge")).sendKeys("20");
		//Robot check box click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input")).click();
		//Agree button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input")).click();
		//Update button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button")).click();
		Thread.sleep(5000);
		System.out.println("-------------------------------------------------------");
		System.out.println("Now again click No button");
		System.out.println("-------------------------------------------------------");
		//installer select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele2);
		sel.selectByIndex(2);
		//Status select
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Edit payments button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[1]/a/div/div")).click();
		//Scroll into middle of the page 
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[3]/div[2]/label"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", ele4);
		//No button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[6]/div[3]/div[2]/div/span/input")).click();
		Thread.sleep(2000);
		//Robot check box click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input")).click();
		//Agree button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input")).click();
		//Update button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =68)
	public void InvPyLatFeeChk() throws InterruptedException, AWTException{
		InvPyDateChk();
		Thread.sleep(2000);
		//Scroll into middle of the page 
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[3]/div[2]/label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(4000);
		//Yes button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[7]/div[3]/div[2]/div/input")).click();
		Thread.sleep(2000);
		//Late Fee charge
		driver.findElement(By.name("latefee")).sendKeys("20");
		//Robot check box click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input")).click();
		//Agree button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input")).click();
		//Update button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button")).click();
		Thread.sleep(5000);
		System.out.println("-------------------------------------------------------");
		System.out.println("Now again click No button");
		System.out.println("-------------------------------------------------------");
		//installer select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele2);
		sel.selectByIndex(2);
		//Status select
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Edit payments button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[1]/a/div/div")).click();
		//Scroll into middle of the page 
		ele4=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[3]/div[2]/label"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", ele4);
		//No button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[7]/div[3]/div[2]/div/span/input")).click();
		Thread.sleep(2000);
		//Robot check box click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input")).click();
		//Agree button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input")).click();
		//Update button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button")).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =69)
	public void InvPyDepAccManChk() throws InterruptedException, AWTException{
		InvPyDateChk();
		Thread.sleep(2000);
		//Scroll into bottom of the page 
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[8]/div[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(4000);
		ele2=driver.findElement(By.id("bankValue"));
		Select sel=new Select(ele2);
		sel.selectByVisibleText("Select Account");
		//Robot check box click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input")).click();
		//Agree button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input")).click();
		//Update button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button")).click();
		//Check alert messsage is displayed or not
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/h4"));
		boolean displayed = ele3.isDisplayed();
		System.out.println("\\033[1m Alert Message is diplayed : \\033[0m"+ displayed);
		String text = ele3.getText();
		System.out.println("\\033[1m Alert message shows like : \\033[0m" + text);
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class,enabled=false,priority =70)
	public void InvChngPayDateManChk() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByIndex(2);
		//Status select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Change invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[2]/a/div/div")).click();
		//getting last payment details
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[4]"));
		if( ele3.isEnabled()) {
			System.out.println("\033[1m element is displayed \033[0m");
		}
		else {
			System.out.println("\033[1m element is not displayed \033[0m");
		}
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =73)
	public void InvChngSkpPayManChk() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Change invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[2]/a/div/div")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/a"));
		Actions act1=new Actions(driver);
		act1.click().build().perform();
		element1.click();
		Thread.sleep(2000);
		//Click skip payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/div/div[3]/a/div/div")).click();
		//Start Month 
		driver.findElement(By.name("startmonth")).sendKeys("Feb/2024");
		//End Month
		driver.findElement(By.name("endmonth")).sendKeys("Mar/2024");
		//Reason
		driver.findElement(By.name("reason")).sendKeys("Test");
		//Click agree button
		driver.findElement(By.name("confirm")).click();
		//Skip Payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[5]/button")).click();
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("//div[text()='An error occurred while processing the request']"));
		String text = ele2.getText();
		System.out.println(text);
	}


	@Test(retryAnalyzer = ReRunFailedTestCase.class,priority =71)
	public void InvChngStpPayManChk() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Test");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Stop invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div")).click();
		Thread.sleep(2000);
		//Stop from
		driver.findElement(By.name("stopsfrom")).sendKeys("Jan/2024");
		//Reason text
		driver.findElement(By.name("Reason")).sendKeys("Test");
		//Confirm button click
		driver.findElement(By.name("confirm")).click();
		//Stop payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div/div[4]/button")).click();
		Thread.sleep(2000);
		ele3=driver.findElement(By.xpath("//div[text()='An error occurred while processing the request']"));
		String text = ele3.getText();
		System.out.println(text);

	}

	@Test(priority =72)
	public void InvChngStpPayHedgeChk() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		//customer button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//Invoice pay button check
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[4]/a/span[2]")).click();
		//installer select
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Testingg");
		//Status select
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel1=new Select(ele2);
		sel1.selectByVisibleText("Released");
		//Name search
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Test");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[10]/a/span/span")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		//Stop invoice pay button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div")).click();
		Thread.sleep(2000);
		//Stop from
		String StopDate="May/2024";
		ele4=driver.findElement(By.name("stopsfrom"));
		String text2 = ele4.getText();
		ele4.sendKeys(StopDate);
		//Reason text
		driver.findElement(By.name("Reason")).sendKeys("Test");
		//Confirm button click
		driver.findElement(By.name("confirm")).click();
		//Stop payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div/div[4]/button")).click();
		Thread.sleep(2000);
		//action button click
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/a"));
		Actions act1=new Actions(driver);
		act1.click().build().perform();
		element1.click();
		Thread.sleep(2000);
		//Back button check
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/div/a/div/div/div")).click();
		Thread.sleep(10000);

		//Installer select
		ele5=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select"));
		Select sel3=new Select(ele5);
		sel3.selectByVisibleText("Testing");
		Thread.sleep(2000);
		//Status select
		ele6=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select"));
		Select sel4=new Select(ele6);
		sel4.selectByIndex(3);
		Thread.sleep(2000);
		//Search customer name
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input")).sendKeys("Tester");
		//Edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr[1]/td[10]/a/span/span")).click();
		//Hedge date check
		WebElement ele7=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[3]/div/div/div[2]/div/div[2]/span/span"));
		String text = ele7.getText();
		Thread.sleep(2000);
		if(text.equals(StopDate)) {
			System.out.println("Stop date is same");
		}
		else {
			System.out.println("Stop date is not same");
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Again start the payment");
		Thread.sleep(2000);
		//action button click
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/a"));
		Actions act2=new Actions(driver);
		act2.click().build().perform();
		element2.click();
		Thread.sleep(2000);
		//Start payment button click
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div")).click();
		//Enter Start From 
		driver.findElement(By.name("effectivefrom")).sendKeys("May/2024");
		//Enter reason
		driver.findElement(By.name("Reason")).sendKeys("2024");
		//Click agree button
		driver.findElement(By.name("confirm")).click();
		//click Start payment button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div[4]/button")).click();
	}

}

