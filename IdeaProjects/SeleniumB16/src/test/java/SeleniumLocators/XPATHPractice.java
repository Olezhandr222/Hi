package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.sendKeys("Oleh");

        WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Trus");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("kekando1sdsw@gmail.com");

        WebElement phonenumber = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phonenumber.sendKeys("8807462849");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("kekandos228");

        WebElement confpass = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confpass.sendKeys("kekandos228");

        WebElement news = driver.findElement(By.xpath("//input[@name='newsletter']"));
        news.click();

        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();

        WebElement btn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        btn.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Account Has Been Created!";
        System.out.println(actualTitle.equals(expectedTitle)?"Passed":"Failed");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualURL.equals(expectedURL)?"Passed":"Failed");








    }
}
