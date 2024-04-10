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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

	//	@AfterMethod
	//	public void tearDown() throws IOException, InterruptedException{
	//		Thread.sleep(3000);
	//		driver.quit();
	//	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void LoginBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
	}

	@Test(priority=1,retryAnalyzer = ReRunFailedTestCase.class)
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

	@Test(priority=2)
	public void TC06() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
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

	@Test(priority=3)
	public void TC10() throws InterruptedException{
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

	@Test(priority=4)
	public void TC03() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//customer list button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
		Thread.sleep(2000);
		//Customer edit button click
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span")).click();
		Thread.sleep(2000);
		//monthly payment amount check
		ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div[2]/span"));
		String mnthlyPymtAmt = ele2.getText();
		System.out.println("Monthly payment value is shown as : " + mnthlyPymtAmt);
	}

	@Test(priority=5)
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

	@Test(priority=6)
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

	@Test(priority=7)
	public void TC19() throws InterruptedException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		//ACH Form button click
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[2]/a/span[2]")).click();
		//ACH excel button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/button")).click();
	}


	@Test(priority=7)
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

	@Test(priority=8)
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

	@Test(priority=9)
	public void TC40() throws InterruptedException, AWTException{
		LoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/span/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/a/span[2]")).click();
		//Installer dropdown locator
		ele1=	driver.findElement(By.name("installer"));
		Select sel1=new Select(ele1);
		sel1.selectByIndex(1);
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

	@Test(priority=4)
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

	@Test
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
		sel1.selectByVisibleText("Test");

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

}
