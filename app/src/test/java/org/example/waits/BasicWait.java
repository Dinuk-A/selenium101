package org.example.waits;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//used rarely

public class BasicWait {

    WebDriver driver;

    @BeforeEach
    public void openMainPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/main-page.html";
        driver = new ChromeDriver();
        driver.get(filePath);

        // if somethings missing, wait 10 secs before throwing any exceptions and
        // failing tests
        // this will only runs when the page(DOM) loads
        // polling (scanning the availability of the given elements in DOM) every 0.5 secs
        // standard is 10 secs
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void basicPageLoad() {
        System.out.println("test ran");
    }

    @AfterEach
    public void closeAll(){
        driver.quit();
    }

}
