package Hometask;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {

    @Test
    public void Hometask1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualtitleH = driver.getTitle();
        String expectedTitleH = "Web Orders Login";

        WebElement nick = driver.findElement(By.xpath("//input[@type='text']"));
        nick.sendKeys("Tester");
        WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("test");
        WebElement sub = driver.findElement(By.xpath("//input[@type='submit']"));


    }
}
