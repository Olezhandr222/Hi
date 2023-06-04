package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement next = driver.findElement(By.id("btn-make-appointment"));
        next.click();


        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("John Doe");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login2 = driver.findElement(By.id("btn-login"));
        login2.click();

        WebElement facility = driver.findElement(By.name("facility"));
        facility.sendKeys("Tokyo CURA Healthcare Center");

        WebElement but = driver.findElement(By.name("hospital_readmission"));
        if(facility.isDisplayed() && !facility.isSelected()){
            but.click();
        }

        WebElement program = driver.findElement(By.id("radio_program_medicaid"));
        program.click();

        WebElement date = driver.findElement(By.name("visit_date"));
        date.sendKeys("10/20/2023");

        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Test for practice");

        WebElement appoint = driver.findElement(By.id("btn-book-appointment"));
        appoint.click();

        WebElement headerActual = driver.findElement(By.xpath("//h2[contains(text(),'Confirmation')]"));
      String headActual = headerActual.getText();
if(headActual.equals("Appointment confirmation")){
    System.out.println("Passed");
}else{
    System.out.println("Failed");
}

        WebElement header1 = driver.findElement(By.id("facility"));
        System.out.println(header1.getText());

        WebElement header2 = driver.findElement(By.id("hospital_readmission"));
        System.out.println(header2.getText());

        WebElement header3 = driver.findElement(By.id("program"));
        System.out.println(header3.getText());

        WebElement header4 = driver.findElement(By.id("visit_date"));
        System.out.println(header4.getText());

        WebElement header5 = driver.findElement(By.id("comment"));
        System.out.println(header5.getText());


        WebElement back = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        back.click();

        System.out.println(driver.getCurrentUrl());

        driver.quit();

    }


}
