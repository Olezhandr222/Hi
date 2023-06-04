package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void switchPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPage = driver.getWindowHandle();

        Set<String> allPages = driver.getWindowHandles();

        for(String pageId : allPages){
            if(!pageId.equals(mainPage)){
                driver.switchTo().window(pageId);


                break;
            }
        }
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());


    }

    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
               /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */Thread.sleep(1500);

        WebElement Tabs3 = driver.findElement(By.cssSelector("#newTabsBtn"));
        Tabs3.click();

        BrowserUtils.switchByTitle(driver,"Basic Controls");

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Oleh");

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Trus");

        WebElement gender = driver.findElement(By.cssSelector("#malerb"));
        gender.isSelected();
        Thread.sleep(1500);
        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("alohaponu@gmail.com");
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        pass.sendKeys("Bebra222");
        Thread.sleep(1500);
        WebElement register = driver.findElement(By.cssSelector("#registerbtn"));
        register.click();

        WebElement actualSucc = driver.findElement(By.xpath("//label[@id='msg']"));
        String expecredSucc = "Registration is Successful";
        Assert.assertEquals(BrowserUtils.getText(actualSucc),expecredSucc);

        BrowserUtils.switchByTitle(driver,"Handles Practice");
        Thread.sleep(1500);
        WebElement actualHeaderHandlesPractice = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String expectedHeaderHandlesPractice ="Window Handles Practice";
        Assert.assertEquals(BrowserUtils.getText(actualHeaderHandlesPractice),expectedHeaderHandlesPractice);


        BrowserUtils.switchByTitle(driver,"AlertsDemo");

Thread.sleep(1500);
        WebElement clickMe = driver.findElement(By.cssSelector("#promptBox"));
        clickMe.click();


    }




}
