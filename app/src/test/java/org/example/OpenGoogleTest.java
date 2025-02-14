package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

public class OpenGoogleTest {

    // @Test === dont need to run a main method to test these
    // we are using the 3rd way(SeleniumManager)
    // these methods cannot be static
    @Test
    public void OpenGoogleAsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void openWindowMoreOpts() throws InterruptedException {

        // to bypass the warnings, set the opened window to a older version of chrome
        // that supports newer selenium
        // not working ❌
        // ChromeOptions opts = new ChromeOptions();
        // opts.setBrowserVersion("130");
        // WebDriver driver = new ChromeDriver(opts);

        WebDriver driver = new ChromeDriver();
        Dimension dims = new Dimension(800, 600);
        driver.manage().window().setSize(dims);
        driver.get("https://www.google.com");

        // wait 3 seconds before next ops
        // throws InterruptedException is for this only
        Thread.sleep(3000);

        driver.quit();
    }

}
