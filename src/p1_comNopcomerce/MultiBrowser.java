package p1_comNopcomerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowser {
    static String browser;
    static String baseUrl = "https://demo.nopcommerce.com/"; //storing base URL
    static WebDriver driver;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Browser (Chrome/Firefox/Edge): ");
        browser = sc.nextLine();
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver(); //creating object of Chrome webdriver
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
            driver = new FirefoxDriver(); //creating object of Firefox webdriver
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver.exe");
            driver = new EdgeDriver(); //creating object of Edge webdriver
        } else {
            System.out.println("NOT A VALID BROWSER!"); //print if wrong browser chosen by user
        }
        driver.get(baseUrl);
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

        WebElement passwordField = driver.findElement(By.id("Password")); //storing password field
        passwordField.sendKeys("CodeBuster55"); //sending keys to password field

        driver.close(); //closing browser
    }
}
