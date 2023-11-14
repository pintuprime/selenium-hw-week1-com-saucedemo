import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/*
Project-4 - ProjectName : com-saucedemo
BaseUrl = https://www.saucedemo.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Enter the email to email field.
7. Enter the password to password field.
8. Click on Login Button.
9. Print the current url.
10. Navigate to baseUrl
11. Refresh the page.
12. Close the browser.
 */

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1.set up multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2.open Url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //3.print title of page
        String title = driver.getTitle();
        System.out.println("Title of page: " + title);

        //4.print current url
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //5.print page source
        String pageSource = driver.getPageSource();
        System.out.println(driver.getPageSource());

        //6.enter email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("rahul");

        //7.enter password to password field
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("secret_sauce");
        Thread.sleep(3000);

        //8.click on login button
        WebElement loginLink = driver.findElement(By.name("login-button"));
        loginLink.click();

        //9.print current url
        System.out.println("The current url: " + driver.getCurrentUrl());

        //10.navigate to base url
        driver.navigate().to(baseUrl);

        //11.refresh page
        driver.navigate().refresh();
        Thread.sleep(4000);

        //12.close browser
        driver.quit();


    }
}
