package FrameAndIFrmae;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void Practice(){

            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
            driver.switchTo().frame("frame-top");
//Name or ID iframe
            WebElement LeftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));

            driver.switchTo().frame(LeftFrame);

        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));

        System.out.println(BrowserUtils.getText(left));

        driver.switchTo().parentFrame();
        WebElement MiddleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(MiddleFrame);
        WebElement middle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().parentFrame();
        WebElement RightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
        driver.switchTo().frame(RightFrame);
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();    //this will go to main html no matter what


        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));



    }

}
