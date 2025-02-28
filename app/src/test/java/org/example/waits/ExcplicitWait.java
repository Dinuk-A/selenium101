package org.example.waits;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// used in 5%
//Unlike Implicit Wait, which applies a fixed delay for all elements, Explicit Wait is customized for each element and waits only when necessary.

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

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openOnlyFirst")));

        // an element will return only if its available depends on the expected cond.
        // in this case its just the visibility

        //still not found after 10 secs, it will throw an error

        // there are more
        /*
         * elementToBeClickable
         * presenceOfElementLocated
         * textToBePresentInElementLocated
         * alertIsPresent
         */

         element.click();
         System.out.println("button text: "+ element.getText());

         WebElement secBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("openAll")));
         System.out.println("sec btn text:" + secBtn.getText());
    }

    @AfterEach
    public void closeAll() {
        driver.quit();
    }

}
