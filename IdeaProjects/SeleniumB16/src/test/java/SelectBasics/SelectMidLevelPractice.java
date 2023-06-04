package SelectBasics;

import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {



        @Test
        public void validateOrderMessage() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

            WebElement ticketType = driver.findElement(By.xpath("//input[@value='oneway']"));
ticketType.click();

            WebElement passangerPickList = driver.findElement(By.xpath("//select[@name='passCount']"));
Select passangerSelect = new Select(passangerPickList);
passangerSelect.selectByVisibleText("4");

            WebElement departingPlace = driver.findElement(By.xpath("//select[@name='fromPort']"));
            Select departingSelect = new Select(departingPlace);
            String actualdepartCity = departingSelect.getFirstSelectedOption().getText().trim();
            String expecteddepartCity = "Acapulco";
            Assert.assertEquals(actualdepartCity,expecteddepartCity);

            departingSelect.selectByVisibleText("Paris");

            WebElement startMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
            Select startMonthSelect = new Select(startMonth);
            startMonthSelect.selectByVisibleText("August");

            WebElement startDate = driver.findElement(By.xpath("//select[@name='fromDay']"));
            Select startDateSelect = new Select(startDate);
            startDateSelect.selectByVisibleText("15");

            WebElement arrivingPlace = driver.findElement(By.xpath("//select[@name='toPort']"));
            Select arrivingPlaceSelect = new Select(arrivingPlace);
            arrivingPlaceSelect.selectByVisibleText("San Francisco");

            WebElement returningMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
            Select returningMonthSelect = new Select(returningMonth);
            returningMonthSelect.selectByVisibleText("December");

            WebElement returningDay = driver.findElement(By.xpath("//select[@name='toDay']"));
            Select returningDaySelect = new Select(returningDay);
            returningDaySelect.selectByVisibleText("15");

            WebElement serviceClass = driver.findElement(By.xpath("//input[contains(text(),'First class')]"));


serviceClass.click();

            WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));



            Select airlineSelect = new Select(airline);
            List<WebElement> actualAirline = airlineSelect.getOptions();
            List<String> expectedAirline = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

            for(int i = 0; i<actualAirline.size();i++){
                Assert.assertEquals(actualAirline.get(i).getText().trim(),expectedAirline.get(i));
            }





            WebElement con = driver.findElement(By.xpath("//input[@name='findFlights']"));

            con.click();







        }
    @Test
    public void validateOrderMessage1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement ticketType = driver.findElement(By.xpath("//input[@value='oneway']"));
        ticketType.click();

        WebElement passangerPickList = driver.findElement(By.xpath("//select[@name='passCount']"));

        BrowserUtils.selectBy(passangerPickList,"4","value");

        WebElement departingPlace = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingSelect = new Select(departingPlace);
        String actualdepartCity = departingSelect.getFirstSelectedOption().getText().trim();
        String expecteddepartCity = "Acapulco";
        Assert.assertEquals(actualdepartCity,expecteddepartCity);

        //departingSelect.selectByVisibleText("Paris");
        BrowserUtils.selectBy(departingPlace, "Paris","text");

        WebElement startMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//        Select startMonthSelect = new Select(startMonth);
//        startMonthSelect.selectByVisibleText("August");
        BrowserUtils.selectBy(startMonth,"August","text");

        WebElement startDate = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select startDateSelect = new Select(startDate);
        startDateSelect.selectByVisibleText("15");

        WebElement arrivingPlace = driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select arrivingPlaceSelect = new Select(arrivingPlace);
//        arrivingPlaceSelect.selectByVisibleText("San Francisco");
        BrowserUtils.selectBy(arrivingPlace,"San Francisco","text");

        WebElement returningMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returningMonthSelect = new Select(returningMonth);
        returningMonthSelect.selectByVisibleText("December");

        WebElement returningDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningDaySelect = new Select(returningDay);
        returningDaySelect.selectByVisibleText("15");

        WebElement serviceClass = driver.findElement(By.xpath("//input[contains(text(),'First class')]"));


        serviceClass.click();

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));



        Select airlineSelect = new Select(airline);
        List<WebElement> actualAirline = airlineSelect.getOptions();
        List<String> expectedAirline = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i = 0; i<actualAirline.size();i++){
            Assert.assertEquals(actualAirline.get(i).getText().trim(),expectedAirline.get(i));
        }





        WebElement con = driver.findElement(By.xpath("//input[@name='findFlights']"));

        con.click();







    }


}


