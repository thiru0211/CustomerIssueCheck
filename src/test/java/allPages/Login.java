package allPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;
import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Locators{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1,ele2,ele3,ele4,ele5;
	@BeforeMethod
	public void setUp() throws IOException{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("http://192.168.1.36:90/#/auth");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
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
	public void Login_TC1(){
		PropertyFileReader.propertyRead();
		String LoginID=PropertyFileReader.propertymap.get("EmailId");
		String password=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(LoginID);
		driver.findElement(By.name(Password)).sendKeys(password);
		driver.findElement(By.id(LoginBtn)).click();	
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC2() throws InterruptedException {
		driver.findElement(By.name(Email)).sendKeys("");
		driver.findElement(By.name(Password)).sendKeys("");
		driver.findElement(By.id(LoginBtn)).click();	
		ele1=driver.findElement(By.xpath(EmailReq));
		String text1 = ele1.getText();
		System.out.println(text1);
		ele2=driver.findElement(By.xpath(PassReq));
		String text2 = ele2.getText();
		System.out.println(text2);
	}

	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC3() {
		PropertyFileReader.propertyRead();
		String LoginID=PropertyFileReader.propertymap.get("EmailId");
		driver.findElement(By.name(Email)).sendKeys(LoginID);
		driver.findElement(By.name(Password)).sendKeys("");
		driver.findElement(By.id(LoginBtn)).click();	
		ele1=driver.findElement(By.xpath(PassReq));
		String text1 = ele1.getText();
		System.out.println(text1);

	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC4() {
		PropertyFileReader.propertyRead();
		String InvalidID=PropertyFileReader.propertymap.get("Invloginid");
		String password=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(InvalidID);
		driver.findElement(By.name(Password)).sendKeys(password);
		driver.findElement(By.id(LoginBtn)).click();	
	}

	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC5() {
		PropertyFileReader.propertyRead();
		String LoginID=PropertyFileReader.propertymap.get("EmailId");
		String InvalidPswd=PropertyFileReader.propertymap.get("Invloginid");
		driver.findElement(By.name(Email)).sendKeys(LoginID);
		driver.findElement(By.name(Password)).sendKeys(InvalidPswd);
		driver.findElement(By.id(LoginBtn)).click();	
	}

	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC6() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String ValidEmailID=PropertyFileReader.propertymap.get("ValidEmailID");
		String InvalidPswd=PropertyFileReader.propertymap.get("Invloginid");
		driver.findElement(By.name(Email)).sendKeys(ValidEmailID);
		driver.findElement(By.name(Password)).sendKeys(InvalidPswd);
		ele1= driver.findElement(By.id(LoginBtn));
		for(int i=0;i<6;i++) {
			ele1.click();
			Thread.sleep(5000);
			ele2=driver.findElement(By.xpath(EmailLockMsg));
			String text1 = ele2.getText();
			System.out.println(text1);
		}
	}

	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC7() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String DsblMailId=PropertyFileReader.propertymap.get("DsblMailId");
		String InvalidPswd=PropertyFileReader.propertymap.get("Invpassword");
		driver.findElement(By.name(Email)).sendKeys(DsblMailId);
		driver.findElement(By.name(Password)).sendKeys(InvalidPswd);
		ele1=driver.findElement(By.id(LoginBtn));
		for(int i=0;i<6;i++) {
			ele1.click();
			Thread.sleep(5000);
			ele2=driver.findElement(By.xpath(EmailLockMsg));
			String text1 = ele2.getText();
			System.out.println(text1);
		}
	}

	@Test(priority = 10,retryAnalyzer = ReRunFailedTestCase.class,enabled=false,description = "When enter 1 time 2fa usermail & password it will navigate to next page, so we cannot enter 6 times")
	public void Login_TC8() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String TwoFAEmail=PropertyFileReader.propertymap.get("TwoFAEmail");
		String TwoFAPass=PropertyFileReader.propertymap.get("TwoFAPass");
		driver.findElement(By.name(Email)).sendKeys(TwoFAEmail);
		driver.findElement(By.name(Password)).sendKeys(TwoFAPass);
		ele1=driver.findElement(By.id(LoginBtn));
		ele1.click();
		Thread.sleep(15000);
		if(ele1.findElement(By.xpath("//*[@id=\"1\"]/div[1]")) != null) {
			File FL=((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			FileUtils.getFile(FL,"C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOnee\\ScreenShot\\FailedScreenShot.png");
			//FileHandler.copy(FL, new File("C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOnee\\ScreenShot\\FailedScreenShot.png"));
		}
		else {
			Scanner scanner = new Scanner(System.in);
			String userEnteredOTP = scanner.nextLine();
			driver.findElement(By.name(OtpBox)).sendKeys(userEnteredOTP);
			driver.findElement(By.className(SubmitBtn)).click();
		}
	}

	@Test(priority = 8,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC9() {
		PropertyFileReader.propertyRead();
		String DsblMailId=PropertyFileReader.propertymap.get("DsblMailId");
		String DsblPswd=PropertyFileReader.propertymap.get("DsblPswd");
		driver.findElement(By.name(Email)).sendKeys(DsblMailId);
		driver.findElement(By.name(Password)).sendKeys(DsblPswd);
		driver.findElement(By.id(LoginBtn)).click();	
	}

	@Test(priority = 9,retryAnalyzer = ReRunFailedTestCase.class)
	public void Login_TC10() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String ValidEmailID=PropertyFileReader.propertymap.get("ValidEmailID");
		driver.findElement(By.name(Email)).sendKeys(ValidEmailID);
		driver.findElement(By.xpath(ForgetPassword)).click();	
		Thread.sleep(1000);
		driver.findElement(By.id("btnyes")).click();
	}

	@Test(priority = 11, description = "Unlock the locked email ID in TC06")
	public void Login_T11() throws InterruptedException {
		Login_TC1();
		Thread.sleep(4000);
		driver.findElement(By.xpath(AdminBtn)).click();
		driver.findElement(By.xpath(ViewUserBtn)).click();
		Thread.sleep(2000);
		ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/span[2]/div/select"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("LOCKED");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[8]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/div[4]/div[3]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary mt-5']")).click();
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-md mt-2']"));
		if(ele2.isDisplayed()) {
			System.out.println("Unlocked message shown");
		}
		else {
			System.out.println("Message is not shown");
		}
		ele2.click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
