package p4_comSaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeTest {

    //Main method
    public static void main(String[] args) {
        String baseUrl = "https://www.saucedemo.com/"; //storing base URL
        System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver.exe"); //setting webdriver
        WebDriver driver = new EdgeDriver(); //creating object of Edge webdriver
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
