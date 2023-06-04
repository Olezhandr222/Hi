package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

         /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Oleh");

        WebElement lastname= driver.findElement(By.name("lastname"));
        lastname.sendKeys("Trus");


        WebElement male = driver.findElement(By.id("sex-0"));
        if (male.isDisplayed() && !male.isSelected()) {
            male.click();
        }

        WebElement experience = driver.findElement(By.id("exp-4"));
        if (experience.isDisplayed() && !experience.isSelected()) {
            experience.click();

            WebElement date= driver.findElement(By.id("datepicker"));
            date.sendKeys("5/8/2023");


            WebElement profesion= driver.findElement(By.id("profession-1"));
            profesion.click();

            WebElement continents= driver.findElement(By.id("continents"));
            continents.sendKeys("North America");



            String actualUrl = driver.getCurrentUrl();
            String expectedUrl= "https://www.techlistic.com/p/selenium-practice-form.html";
            System.out.println(actualUrl.equals(expectedUrl)  ?"passed" : "NOT PASSED");

            driver.quit();
    }



}}
