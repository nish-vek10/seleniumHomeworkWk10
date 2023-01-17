package p1_comNopcomerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeTest {

    //Main method
    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/"; //storing base URL
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe"); //setting webdriver
        WebDriver driver = new ChromeDriver(); //creating object of Chrome webdriver
        driver.get(baseUrl); //method to invoke URL
        driver.manage().window().maximize(); //maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //timeout session

        String title = driver.getTitle(); //storing title of the page
        System.out.println("TITLE OF PAGE: " + title); //print title

        String currentURL = driver.getCurrentUrl(); //storing current URL
        System.out.println("CURRENT URL OF PAGE: " + currentURL); //print current URL

        String pageSource = driver.getPageSource(); //storing page source
        System.out.println("PAGE SOURCE: " + pageSource); //print page source

        driver.findElement(By.className("ico-login")).click(); //clicking on login link

        WebElement emailIdField = driver.findElement(By.id("Email")); //storing email field
        emailIdField.sendKeys("cbuster55@gmail.com"); //sending keys to email field

        WebElement passwordField = driver.findElement(By.id("Password")); //storing email field
        passwordField.sendKeys("CodeBuster55"); //sending keys to email field

        driver.close(); //closing browser
    }
}