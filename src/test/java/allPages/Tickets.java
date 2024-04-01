package allPages;

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

public class Tickets extends Locators{
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
		driver.get("http://192.168.1.36:81/#/auth");
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

	@Test
	public void TicketsClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(TicketsBtn)).click();
	}

	@Test
	public void TC01() throws InterruptedException {
		TicketsClick();
		String TktInstName=PropertyFileReader.propertymap.get("TktInstName");
		String TktCustName=PropertyFileReader.propertymap.get("TktCustName");

		//		Scanner scanner = new Scanner(System.in);
		//		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		//		System.out.println("Please enter in the format like March, 2023 (or) April, 2023");
		//		String DueDate= scanner.nextLine();
		driver.findElement(By.xpath(TktDueMntCal)).sendKeys("March, 2023");

		ele1=driver.findElement(By.xpath(TktInstDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(TktInstName);
		driver.findElement(By.xpath(TktCusName)).sendKeys(TktCustName);
	}

	@Test
	public void TC02() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktExpBtn)).click();
	}

	@Test
	public void TC03() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnAddCmt)).click();
		driver.findElement(By.xpath(TktViewBtnAddCmtSave)).click();
		ele1=driver.findElement(By.xpath(TktViewBtnAddCmtMan));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
		ele1.click();
	}


	@Test
	public void TC04() throws InterruptedException {
		TC03();
		driver.findElement(By.xpath(TktViewBtnAddCmtCls)).click();
	}

	@Test
	public void TC05() throws InterruptedException {
		TC03();
		String TktViewBtnAddCmts=PropertyFileReader.propertymap.get("TktViewBtnAddCmts");
		ele1=driver.findElement(By.xpath(TktViewBtnAddCmtBox));
		ele1.sendKeys(TktViewBtnAddCmts);
		ele1.clear();
	}

	@Test
	public void TC06() throws InterruptedException {
		TC03();
		String TktViewBtnAddCmts=PropertyFileReader.propertymap.get("TktViewBtnAddCmts");
		ele1=driver.findElement(By.xpath(TktViewBtnAddCmtBox));
		ele1.sendKeys(TktViewBtnAddCmts);
		driver.findElement(By.xpath(TktViewBtnAddCmtSave)).click();
	}

	@Test
	public void TC07() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnSndMail)).click();
		driver.findElement(By.xpath(TktViewBtnSndMailSav)).click();
		ele1=driver.findElement(By.xpath(TktViewBtnSndMailMan));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
		ele1.click();
	}

	@Test
	public void TC08() throws InterruptedException {
		TC07();
		String TktSndMailSubj=PropertyFileReader.propertymap.get("TktSndMailSubj");
		String TktSndMailMsg=PropertyFileReader.propertymap.get("TktSndMailMsg");
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnSndMailSubj)).sendKeys(TktSndMailSubj);
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnSndMailMsg)).sendKeys(TktSndMailMsg);
		driver.findElement(By.xpath(TktViewBtnSndMailSav)).click();
	}

	@Test
	public void TC09() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnSndMail)).click();
		driver.findElement(By.xpath(TktViewBtnSndMailCls)).click();
	}

	@Test
	public void TC10() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnClsTkt)).click();
		driver.findElement(By.xpath(TktViewBtnClsTktSav)).click();
		ele1=driver.findElement(By.xpath(TktViewBtnClsTktMan));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
		ele1.click();
	}

	@Test
	public void TC11() throws InterruptedException {
		TC10();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTktCls)).click();
	}

	@Test
	public void TC12() throws InterruptedException {
		TC01();
		String TktClsTktDes=PropertyFileReader.propertymap.get("TktClsTktDes");
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnClsTkt)).click();
		driver.findElement(By.xpath(TktViewBtnClsTktDes)).sendKeys(TktClsTktDes);
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTktClr)).click();
	}

	@Test
	public void TC13() throws InterruptedException {
		TC12();
		String TktClsTktDes=PropertyFileReader.propertymap.get("TktClsTktDes");
		driver.findElement(By.xpath(TktViewBtnClsTktDes)).sendKeys(TktClsTktDes);
		driver.findElement(By.xpath(TktViewBtnClsTktSav)).click();
	}

	@Test
	public void TC14() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnViewPyHstry)).click();
	}
}




