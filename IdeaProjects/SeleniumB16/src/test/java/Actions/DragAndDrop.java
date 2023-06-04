package Actions;

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

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(3000);
        WebElement actualtext = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String expectedtext = "... Or here.";
        Assert.assertEquals(actualtext.getText(),expectedtext);
        String actualBackGroundColor= actualtext.getCssValue("background-color");
        String expectedBackGroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackGroundColor,expectedBackGroundColor);
        Thread.sleep(3000);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
Actions actions=  new Actions(driver);
actions.dragAndDrop(draggable,actualtext).perform();
Thread.sleep(2000);
        actualtext = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
String actualAfterDragAndDrop = BrowserUtils.getText(actualtext);
String expectedAfterDragAndDrop = "You did great!";
Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

        Thread.sleep(5000);
        driver.close();

    }

    @Test
    public void DragAndDropPractice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(3000);
        WebElement bluebox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage = BrowserUtils.getText(bluebox);
        String expectedMessage="Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor = bluebox.getCssValue("background-color").trim();
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(bluebox).release().perform();
        WebElement AfterActions = driver.findElement(By.xpath("//div[@class='test1']"));
        String kek = BrowserUtils.getText(AfterActions);
        String kek2 = "You did great!";
        Assert.assertEquals(kek,kek2);




    }
}
