package org.example.waits;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//used 85% in tests

public class ImplicitWaitTest {
    WebDriver driver;

    @BeforeEach
    public void openMainPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/main-page.html";
        driver = new ChromeDriver();
        driver.get(filePath);

        // works globally
        // wait for all the elements after this point, that interacting with the driver

        // check 10s if something(element) is missing when searching from
        // locators(id,xpath,class,...)

        // wait 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // can change the time duration if needed any place after this too(in tests)

        driver.manage().window().maximize();
    }

    @Test
    public void basicTest() {
        System.out.println("test ran");
        // can change the implicitlyWait duration in here if needed
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void closeAll() {
        driver.quit();
    }
}
