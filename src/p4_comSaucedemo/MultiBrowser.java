package p4_comSaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowser {
    static String browser; //declare browser variable
    static String baseUrl = "https://www.saucedemo.com/"; //storing base URL
    static WebDriver driver; //declare variable for driver

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //create a scanner object
        System.out.print("Enter Browser (Chrome/Firefox/Edge) : "); //request user to choose the specific browser
        browser = sc.nextLine(); //read user input
        if (browser.equalsIgnoreCase("chrome")) { //if user chooses Chrome then do the following
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe"); //setting webdriver
            driver = new ChromeDriver(); //creating object of Chrome webdriver
        } else if (browser.equalsIgnoreCase("firefox")) { //else if user chooses Firefox then do the following
            System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe"); //setting webdriver
            driver = new FirefoxDriver(); //creating object of Firefox webdriver
        } else if (browser.equalsIgnoreCase("edge")) { //else //if user chooses Edge then do the following
            System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver.exe"); //setting webdriver
            driver = new EdgeDriver(); //creating object of Edge webdriver
        } else {
            System.out.println("NOT A VALID BROWSER!"); //print if wrong browser chosen by user
        }

        driver.get(baseUrl); //method to invoke url
        driver.manage().window().maximize(); //to maximise window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //timeout session

        String title = driver.getTitle(); //storing title of the page
        System.out.println("TITLE OF PAGE: " + title); //print title

        String currentURL = driver.getCurrentUrl(); //storing current URL
        System.out.println("CURRENT URL OF PAGE: " + currentURL); //print current URL

        String pageSource = driver.getPageSource(); //storing page source
        System.out.println("PAGE SOURCE: " + pageSource); //print page source

        //create a String array containing all possible accepted usernames
        String[] randUser = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
        //declare another variable to choose a random value from the array to use as an input
        String randValue = randUser[(int) Math.floor(Math.random() * randUser.length)];
        WebElement usernameField = driver.findElement(By.id("user-name")); //storing email field
        usernameField.sendKeys(randValue); //sending keys to email field

        WebElement passwordField = driver.findElement(By.id("password")); //storing password field
        passwordField.sendKeys("secret_sauce"); //sending keys to password field

        driver.close(); //close browser
    }
}
