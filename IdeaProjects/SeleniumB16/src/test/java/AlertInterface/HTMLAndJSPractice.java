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

public class HTMLAndJSPractice {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement normalPreview = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        normalPreview.click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);

        alert.accept();

        WebElement sweetPreview = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        sweetPreview.click();

        Thread.sleep(2000);

        WebElement actualSweetMessage = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        String actualSweetText = BrowserUtils.getText(actualSweetMessage);
        String expectedSweetText = "Something went wrong!";
        Assert.assertTrue(actualSweetText.contains(expectedSweetText));


        WebElement closeTab = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
closeTab.click();

Thread.sleep(4000);
        driver.close();


    }
}
