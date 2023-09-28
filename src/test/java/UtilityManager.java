import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityManager {
	
	private static WebDriver driver;
	
	
	public static void driverInitialization() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://subscribe.stctv.com/");
		WebElement Language = driver.findElement(By.xpath(".//*[@id='translation-btn']"));
		Language.click();
	}
	public static void validatePackageNameForCountry() {
			String []packageName = {"Lite","Classic","Premium"};
			//Validate Package name for country 1
			List <WebElement> lst = driver.findElements(By.xpath("(.//*[@class='plan-names'])[1]//div//strong"));
			for(WebElement eachele : lst) {
				String strEachPackageName = eachele.getText();
				for(int i=0;i<packageName.length;i++) {
					if(packageName[i].equalsIgnoreCase(strEachPackageName)) {
						System.out.println("Package Name:" +strEachPackageName);
					}
				}
			}
		}
	public static void validateCurrencyForCountry() {
		WebElement wb_CountryName = driver.findElement(By.xpath(".//*[@id='country-name']"));
			WebElement wb_Currency = driver.findElement(By.xpath(".//*[@id='currency-lite']//i"));
			String[] str_Currency = wb_Currency.getText().split("/");
			String strCurrentCurrencyValue = str_Currency[0].trim();
			if(strCurrentCurrencyValue.equalsIgnoreCase("SAR")&& wb_CountryName.getText().trim().equalsIgnoreCase("KSA")) {
				System.out.println("Current currency value is KSA");
			}else if (strCurrentCurrencyValue.equalsIgnoreCase("BHD")&& wb_CountryName.getText().trim().equalsIgnoreCase("Bahrain")) {
				System.out.println("Current currency value is Bahrin");
			}else if(strCurrentCurrencyValue.equalsIgnoreCase("KWD")&& wb_CountryName.getText().trim().equalsIgnoreCase("Kuwait")){
				System.out.println("Current currency value is Kuwait");
			}
			
		}
		
		//Validate package Type and price
		public static void validatePackageTypeAndPrice() {
			WebElement wb_CountryName = driver.findElement(By.xpath(".//*[@id='country-name']"));
			String str_CurrencyElite = driver.findElement(By.xpath(".//*[@id='currency-lite']")).getText();
			String str_CurrencyClassic = driver.findElement(By.xpath(".//*[@id='currency-classic']")).getText();
			String str_CurrencyPlatinum = driver.findElement(By.xpath(".//*[@id='currency-premium']")).getText();
			if(wb_CountryName.getText().equalsIgnoreCase("KSA")) {
				if(str_CurrencyElite.contains("15")) {
					System.out.println("Currency for Elite is displayed successfully");
				}else {
					Assert.fail("Currency for Elite is not displayed properly");
				}
				if(str_CurrencyClassic.contains("25")) {
					System.out.println("Currency for Classic is displayed successfully");
				}else {
					Assert.fail("Currency for Classic is not displayed properly");
				}
				if(str_CurrencyPlatinum.contains("60")) {
					System.out.println("Currency for Premium is displayed successfully");
				}else {
					Assert.fail("Currency for Premium is not displayed properly");
				}
			}else if (wb_CountryName.getText().equalsIgnoreCase("Kuwait")) {
				if(str_CurrencyElite.contains("1.2")) {
					System.out.println("Currency for Elite is displayed successfully");
				}else {
					Assert.fail("Currency for Elite is not displayed properly");
				}
				if(str_CurrencyClassic.contains("2.5")) {
					System.out.println("Currency for Classic is displayed successfully");
				}else {
					Assert.fail("Currency for Classic is not displayed properly");
				}
				if(str_CurrencyPlatinum.contains("4.8")) {
					System.out.println("Currency for Premium is displayed successfully");
				}else {
					Assert.fail("Currency for Premium is not displayed properly");
				}
			}else if (wb_CountryName.getText().equalsIgnoreCase("Bahrain")) {
				if(str_CurrencyElite.contains("2")) {
					System.out.println("Currency for Elite is displayed successfully");
				}else {
					Assert.fail("Currency for Elite is not displayed properly");
				}
				if(str_CurrencyClassic.contains("3")) {
					System.out.println("Currency for Classic is displayed successfully");
				}else {
					Assert.fail("Currency for Classic is not displayed properly");
				}
				if(str_CurrencyPlatinum.contains("6")) {
					System.out.println("Currency for Premium is displayed successfully");
				}else {
					Assert.fail("Currency for Premium is not displayed properly");
				}
			}
		}
		
		public static void selectCountry(String countryName) {
			WebElement wb_CountrySelect = driver.findElement(By.xpath(".//*[@id='arrow']"));
			wb_CountrySelect.click();
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
			wt.until(ExpectedConditions.visibilityOf(wb_CountrySelect));
			WebElement wbCountryKuwait = driver.findElement(By.xpath(".//a[@id='kw']"));
			WebElement wbCountryBahrain = driver.findElement(By.xpath(".//a[@id='bh']"));
			WebElement wbCountryKSA = driver.findElement(By.xpath(".//a[@id='sa']"));
			if(countryName.equalsIgnoreCase("Kuwait")) {
				wbCountryKuwait.click();
			}else if (countryName.equalsIgnoreCase("Bahrain")) {
				wbCountryBahrain.click();
			}
		}
		public static void quitDriver() {
			driver.quit();
		}
	}


