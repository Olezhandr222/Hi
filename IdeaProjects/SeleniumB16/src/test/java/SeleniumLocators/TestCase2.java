package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");

        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        String errorActual = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        String errorExpected = "Epic sadface: Username and password do not match any user in this service";

        System.out.println(errorActual.equals(errorExpected)?"Passed":"Failed");
        driver.navigate().refresh();


    }
}
