package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTesting.click();

       WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());



       WebElement text1 = driver.findElement(By.xpath("//p[contains(text(),'Also known')]"));
        System.out.println(text1.getText());

        WebElement text2 = driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        text2.click();









    }
}
