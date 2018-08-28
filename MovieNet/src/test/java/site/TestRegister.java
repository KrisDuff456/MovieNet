package site;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegister{
	
    static WebDriver myDriver;
	
	@BeforeClass
	public static void start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Marz\\Desktop\\MovieNet\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		 myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
	}
	@Test
	public void testHome() {
		myDriver.get("http://localhost:8080/MovieNet/index.html");	
	}
	@Test
	public void testSignUp() {
		myDriver.get("http://localhost:8080/MovieNet/signup.html");
		myDriver.findElement(By.id("first_name")).sendKeys("John");
		myDriver.findElement(By.id("last_name")).sendKeys("Doe");
		myDriver.findElement(By.id("email")).sendKeys("JohnDoe@email.com");
		myDriver.findElement(By.id("dateOfBirth")).sendKeys("12/02/1995");
		myDriver.findElement(By.id("password")).sendKeys("password");
		myDriver.findElement(By.id("password-confirm")).sendKeys("password");
		myDriver.findElement(By.id("//*[@id=\"signup-btn\"]/button")).click();
}
	@After
	public void close() {
		myDriver.close();
	}
}