package org.example.waits;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// used in 5%
//Unlike Implicit Wait, which applies a fixed delay for all elements, Explicit Wait is customized for each element and waits only when necessary.

//If the condition is not met within the given time, Selenium throws a TimeoutException. handle that in 2nd Test method >>>

public class ExcplicitWait {

    WebDriver driver;

    @BeforeEach
    public void openMainPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/main-page.html";
        driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @Test
    public void basicTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //can we pass this inside the visibilityOfElementLocated too
         //By firstBtn = By.id("openOnlyFirst"); ??? 💥💥💥

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openOnlyFirst")));

        // an element will return only if its available depends on the expected cond.
        // in this case its just the visibility

        // still not found after 10 secs, it will throw an error

        // there are more
        /*
         * elementToBeClickable
         * presenceOfElementLocated
         * textToBePresentInElementLocated
         * alertIsPresent
         */

        element.click();
        System.out.println("button text: " + element.getText());

        WebElement secBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("openAll")));
        System.out.println("sec btn text:" + secBtn.getText());
    }

    @Test
    public void sameTestWithTryCatch() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openOnlFirst")));

            element.click();

            System.out.println("button text: " + element.getText());

        } catch (TimeoutException e) {

            System.out.println("Element not found within the specified time.");

        }

    }

    @Test
    public void multConditionsAnd() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //By firstBtn = By.id("openOnlyFirst");

        try {

           Boolean isFound = wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(By.id("openOnlyFirst")),ExpectedConditions.elementToBeClickable(By.id("openOnlyFirst"))));

           //why cant saved in a web element as before ??? 💥💥💥

        } catch (TimeoutException e) {
            System.out.println("Element not found : AND");
        }
    }

    @Test
    public void multConditionsOr() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id("opeOnlyFirst")),ExpectedConditions.visibilityOfElementLocated(By.id("opnAll"))));

        } catch (Exception e) {
            System.out.println("Element not found : OR");
        }

    }

    @AfterEach
    public void closeAll() {
        driver.quit();
    }

}
