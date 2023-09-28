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

public class ValueLabsSample extends UtilityManager{

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		driverInitialization();
		//validate Package Name/ Currency type /Price for Current country ( KSA)
		validatePackageNameForCountry();
		validateCurrencyForCountry();
		validatePackageTypeAndPrice();
		//validate Package Name/ Currency type /Price for Current country ( Kuwait)
		selectCountry("Kuwait");
		validatePackageNameForCountry();
		validateCurrencyForCountry();
		validatePackageTypeAndPrice();
		selectCountry("Bahrain");
		validatePackageNameForCountry();
		validateCurrencyForCountry();
		validatePackageTypeAndPrice();
		quitDriver();
	}

}
