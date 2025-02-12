package org.example;

/*💥Important💥 */
//this kinda tests are not written under "main"
//this is just to demonstrate
//from now on these will be written under "src/test"

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogle {

    public static void main(String[] args) {

        // oldest way
        //olderstWayToOpenGoogle();

        //2nd way
        //webDriverManagerOpenGoogle();

        // 3rd way
        latestWay();

    }

    // #1
    // this is the oldest way, had to manually download the chromedriver.exe and
    // setting up the correct path
    public static void olderstWayToOpenGoogle() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dinuka Pramod\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

      // #2
      // the "webdrivermanager" dependancy will automatically handle the chromedriver whether its downloaded in our pc or not
      //this will be downloaded and saved in C:\Users\Dinuka Pramod\.cache\selenium
      public static void webDriverManagerOpenGoogle() {
       
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    // #3
    // use SeleniumManager(after selenium v4)
    public static void latestWay() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //close and exit the browser
        driver.quit();

    }
}
