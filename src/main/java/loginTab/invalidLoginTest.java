package loginTab;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class invalidLoginTest {

	WebDriver dr;

	@Given("^navigate to login page$")
	public void navigate_to_login_page() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("./src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("./src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		dr = new ChromeDriver();
		dr.get(prop.getProperty("url"));
	}

	@When("^user logged in with incorrect credentials$")
	public void user_logged_in_with_incorrect_credentials() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("./src/test/resources/cuong.properties");
		prop.load(input);
		dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("incorrectLogin"));
		dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("incorrectLogin"));
		dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	@Then("^error message appears$")
	public void error_message_appears() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("./src/test/resources/cuong.properties");
		prop.load(input);
		try {
			TimeUnit.SECONDS.sleep(1);
			String actualMessage = dr.findElement(By.xpath(prop.getProperty("invalidActual"))).getText();
			if (actualMessage.contains(prop.getProperty("invalidWanted"))) {
				Assert.assertFalse(false);
			} else {
				Assert.assertFalse(true);
			}
			dr.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
