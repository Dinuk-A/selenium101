package org.example.waits;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// used in 5%

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
      
    }

    @AfterEach
    public void closeAll() {
        driver.quit();
    }

}
