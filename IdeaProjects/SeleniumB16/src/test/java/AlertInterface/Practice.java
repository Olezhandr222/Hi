package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    @Test
    public void AlertPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement Accept = driver.findElement(By.cssSelector("#alertBox"));
        Accept.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#output"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You selected alert popup";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement Dismiss = driver.findElement(By.cssSelector("#confirmBox"));
        Dismiss.click();
        alert.dismiss();

        String actualMessageCancel = BrowserUtils.getText(message);
        String expectedMessageCancel = "You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualMessageCancel,expectedMessageCancel);
        WebElement Prompt = driver.findElement(By.cssSelector("#promptBox"));
        Prompt.click();
        alert.sendKeys("Oleh");
        alert.accept();

        String actualMessagePrompt = BrowserUtils.getText(message);
        String expectedMessagePrompt = "You entered text Oleh in prompt popup";
        Assert.assertEquals(actualMessagePrompt,expectedMessagePrompt);





    }
}
