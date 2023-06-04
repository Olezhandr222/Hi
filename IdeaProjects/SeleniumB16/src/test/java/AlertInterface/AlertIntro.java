package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AlertAcceptAndGetText(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'Alert')]"));
        JsConfirm.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText().trim(); //will get the text from pop-up that i cannot inspect
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();//will click OK button otherwise you will get UNHANDLED ALERT EXCEPTION
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);



    }


    @Test

    public void AlertDismiss(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'Confirm')]"));

        JsConfirm.click();

        Alert alert = driver.switchTo().alert();

        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#result"));
String actualMessage = BrowserUtils.getText(message);
        String expectedMessage ="You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    
    @Test
    public void AlertSendKeys(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JsPrompt= driver.findElement(By.xpath("//button[contains(@onclick,'Prompt')]"));

        JsPrompt.click();
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello");
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You entered: Hello";
        Assert.assertEquals(actualMessage,expectedMessage);



        
    }
}
