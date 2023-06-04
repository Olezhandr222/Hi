package SelectBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/vova/Downloads/Techtorial.html");

        WebElement optionchoice = driver.findElement(By.xpath("//select[@name='country']"));

        Select choice = new Select(optionchoice);
String actual = choice.getFirstSelectedOption().getText().trim();
String expected = "UNITED STATES";
        Assert.assertEquals(actual,expected);

        List<WebElement> kek = choice.getOptions();
        System.out.println(kek);
        int count = 0;
      for(WebElement sus: kek){
          count++;
      }
        System.out.println(count);
        choice.selectByVisibleText("UKRAINE");
        Thread.sleep(2000);

        choice.selectByValue("71");
        Thread.sleep(2000);
        choice.selectByIndex(27);


    }
}
