package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {

    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement click1 = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",click1);
        Actions actions = new Actions(driver);
        //actions.click(click1).perform();

        WebElement actualc= driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(BrowserUtils.getText(actualc),"You have selected Yes");
Thread.sleep(1000);
        WebElement click2 = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
      //actions.click(click2).perform();
        js.executeScript("arguments[0].click()",click2);

        actualc= driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(BrowserUtils.getText(actualc),"You have selected Impressive");

        WebElement click3 = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertTrue(click3.isEnabled());
    }
    @Test
    public void practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement findOutCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findOutCourse);
        findOutCourse.click();

}

    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement down = driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
       BrowserUtils.scrollWithJS(driver,down);
       Thread.sleep(1000);
        WebElement up = driver.findElement(By.xpath("//span[contains(text(),'Join Techtorial')]"));
        BrowserUtils.scrollWithJS(driver,up);
        Thread.sleep(1000);
        WebElement click = driver.findElement(By.linkText("Apply Now"));
         BrowserUtils.clickWithJS(driver,click);

         List<WebElement> lister = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
         List<String> lister2 = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91","Chicago & Houston");
         for(int i = 0 ; i<lister.size();i++){
             Thread.sleep(1000);
             Assert.assertEquals(BrowserUtils.getText(lister.get(i)),lister2.get(i));

         }

         String actualTitle = BrowserUtils.getTitleWithJs(driver);
         String expectedTitle="Apply Now";
         Assert.assertEquals(actualTitle,expectedTitle);













    }

}

