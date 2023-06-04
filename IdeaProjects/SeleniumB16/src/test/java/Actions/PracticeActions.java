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

public class PracticeActions {

    @Test
    public void PracticeDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(3000);

        WebElement box = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(box);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement drag = driver.findElement(By.xpath("//div[.='Drag me']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(drag).moveToElement(box).release().perform();

        WebElement nextBox = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
        String actialTextBox = BrowserUtils.getText(nextBox);
        String expectedTextBox = "Dropped!";
        Assert.assertEquals(actialTextBox,expectedTextBox);

        String actualColor = nextBox.getCssValue("background-color");
        String expectedColor ="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);


    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(3000);

        WebElement Page2= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        Page2.click();

        WebElement notAcceptable= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement box1= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        Thread.sleep(2000);
        actions.clickAndHold(notAcceptable).moveToElement(box1).release().perform();





    }
}
