package FrameAndIFrmae;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FramePractice {

    @Test
    public void Practice1(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

      //  WebElement header = driver.findElement(By.tagName("h3"));

driver.switchTo().frame("mce_0_ifr");
     WebElement Iframe = driver.findElement(By.xpath("//html//body[@id='tinymce']"));
     Iframe.clear();
     Iframe.sendKeys("I love Selenium");
     driver.switchTo().parentFrame();




    }

    @Test
    public void Task1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

/*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
WebElement pavilion = driver.findElement(By.xpath("//a[.='Pavilion']"));

pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home");
        Actions actions = new Actions(driver);
        WebElement moveActions = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(moveActions).perform();

        WebElement SeleniumJava = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        actions.click(SeleniumJava).perform();

//        WebElement header = driver.findElement(By.xpath("h1"));
//        String actualText = BrowserUtils.getText(header);
//        String expectedText = "Selenium-Java Tutorial – Basic to Advance";
//        Assert.assertEquals(actualText,expectedText);
        List<WebElement> tableOfContext = driver.findElements(By.xpath("//p//a"));
        for(WebElement b:tableOfContext){
            System.out.println(BrowserUtils.getText(b));


        }


        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */


BrowserUtils.switchByTitle(driver,"iframes");

driver.switchTo().frame("Frame1");
Thread.sleep(2000);
WebElement categ1 = driver.findElement(By.xpath("//a[.='Category1']"));

        actions.click(categ1).perform();
        BrowserUtils.switchByTitle(driver,"Archives");

        WebElement header1 = driver.findElement(By.xpath("//h1"));
        String expectedHeader1 = "Category Archives: SeleniumTesting";
        Assert.assertEquals(BrowserUtils.getText(header1),expectedHeader1);



        driver.switchTo().parentFrame();

List<WebElement> header3 = driver.findElements(By.xpath("//h3//a"));
Thread.sleep(1000);
for(WebElement kek:header3){

    System.out.println(BrowserUtils.getText(kek));

}

/*
TASK 3:
1-Go back mainPage
2-Click Category3
3-Validate the header "Category Archives: SoftwareTesting"

 */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        Thread.sleep(1000);
        WebElement iAmInside = driver.findElement(By.id("frametext"));
        System.out.println(BrowserUtils.getText(iAmInside));
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        Thread.sleep(1000);
        WebElement categ3 = driver.findElement(By.xpath("//a[.='Category3']"));
        categ3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting");
        WebElement headerSoftware = driver.findElement(By.xpath("//h1"));
        String expectedHeaderSoftware = "Category Archives: SoftwareTesting";
        Assert.assertEquals(BrowserUtils.getText(headerSoftware),expectedHeaderSoftware);




        Thread.sleep(1000);
        driver.quit();









    }
}
