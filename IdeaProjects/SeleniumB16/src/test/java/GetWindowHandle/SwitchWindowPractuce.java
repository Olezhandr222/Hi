package GetWindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindowPractuce {
    @Test
    public void switchPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement openNewTab = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        Thread.sleep(2000);
        openNewTab.click();
String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for(String page:allPages){
            if(!page.equals(mainPage)){

                driver.switchTo().window(page);

            }

        }
Thread.sleep(2000);
        String actualHeader = driver.getTitle().trim();
        String expectedHeader = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement clickMeBtn = driver.findElement(By.cssSelector("#alertBox"));
        clickMeBtn.click();





    }
}
