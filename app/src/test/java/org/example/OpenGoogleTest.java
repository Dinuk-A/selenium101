package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogleTest {

    // @Test === dont need to run a main method to test these
    // these methods cannot be static
    @Test
    public void OpenGoogleAsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

}
