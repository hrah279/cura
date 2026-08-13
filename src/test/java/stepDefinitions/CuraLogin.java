package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CuraLogin {

    public static void main(String[] args) throws InterruptedException {

    	    	   	
    	WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.manage().window().maximize();

        // ---------------------------------------------------------
        // OPEN CURA HEALTHCARE WEBSITE
        // ---------------------------------------------------------

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        System.out.println("CURA Healthcare website opened.");

        // ---------------------------------------------------------
        // CLICK MENU
        // ---------------------------------------------------------

        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-toggle")));

        menu.click();

        System.out.println("Menu opened.");

        // ---------------------------------------------------------
        // CLICK LOGIN
        // ---------------------------------------------------------

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));

        login.click();

        System.out.println("Login page opened.");

        // ---------------------------------------------------------
        // ENTER USERNAME
        // ---------------------------------------------------------

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt-username")));

        username.sendKeys("John Doe");

        System.out.println("Username entered: John Doe");

        // ---------------------------------------------------------
        // ENTER PASSWORD
        // ---------------------------------------------------------

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt-password")));

        password.sendKeys("ThisIsNotAPassword");

        System.out.println("Password entered.");

        // ---------------------------------------------------------
        // CLICK LOGIN
        // ---------------------------------------------------------

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-login")));

        loginButton.click();

        System.out.println("Login button clicked.");

        // ---------------------------------------------------------
        // VERIFY SUCCESSFUL LOGIN
        // ---------------------------------------------------------

        wait.until(ExpectedConditions.urlContains("#appointment"));

        System.out.println("Login successful.");

        System.out.println("Current URL: " + driver.getCurrentUrl());

        // ---------------------------------------------------------
        // CLOSE BROWSER
        // ---------------------------------------------------------

        Thread.sleep(3000);
        
        driver.quit();

    }
}