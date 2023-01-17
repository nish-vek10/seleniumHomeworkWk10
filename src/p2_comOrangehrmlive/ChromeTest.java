package p2_comOrangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeTest {

    //Main method
    public static void main(String[] args) {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/"; //storing base URL
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe"); //setting webdriver
        WebDriver driver = new ChromeDriver(); //creating object of Chrome webdriver
        driver.get(baseUrl); //method to invoke url
        driver.manage().window().maximize(); //to maximise window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //timeout session

        String title = driver.getTitle(); //storing title of page
        System.out.println("TITLE OF PAGE: " + title); //print title

        String currentURL = driver.getCurrentUrl(); //storing current URL
        System.out.println("CURRENT URL OF PAGE: " + currentURL); //print current URL

        String pageSource = driver.getPageSource(); //storing page source
        System.out.println("PAGE SOURCE: " + pageSource); //print page source

        WebElement usernameField = driver.findElement(By.name("username")); //storing email field
        usernameField.sendKeys("Admin"); //sending keys to email field

        WebElement passwordField = driver.findElement(By.name("password")); //storing password field
        passwordField.sendKeys("admin123"); //sending keys to password field

        driver.close(); //close browser
    }
}