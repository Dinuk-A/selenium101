package org.example;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultWindow {

    WebDriver driver;

    @BeforeEach
    public void openMainPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/main-page.html";
        driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @Test
    public void openFirstWintest() throws InterruptedException {

        // saving the ref of parent window
        String parentWin = driver.getWindowHandle();
        System.out.println("parent :" + parentWin);
        System.out.println("parent title:" + driver.getTitle());

        // 1 confirm a new window has opened ✅
        WebElement btn1 = driver.findElement(By.id("openOnlyFirst"));
        btn1.click();
        Thread.sleep(2000);

        // ssave all opened windows
        Set<String> allhandles = driver.getWindowHandles();

        // switch focus to newly opened tab
        for (String handle : allhandles) {
            System.out.println("current page: " + handle);

            // new window is in the last page of set, so at last it will switch to the last
            // window(xhild window)
            driver.switchTo().window(handle);

            // confirm it by the title
            System.out.println("child's title : " + driver.getTitle());
        }

        driver.close(); // close all except parent

        // must be switch back to parent window
        driver.switchTo().window(parentWin);
        System.out.println(driver.getTitle());

        // driver.quit(); // closes all opened tabs also the parent one
    }

    // find number of opened windows
    @Test
    public void openMultiWinTest() {
        // saving the ref of parent window
        String parentWin = driver.getWindowHandle();
        System.out.println("parent :" + parentWin);
        System.out.println("parent title:" + driver.getTitle());

        WebElement btm2 = driver.findElement(By.id("openAll"));
        btm2.click();

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("number of windows = " + allWindows.size());

        driver.quit(); // closes all opened tabs also the parent one

    }

    @Test
    public void closeExceptPrimary() throws InterruptedException {
        // saving the ref of parent window
        String parentWin = driver.getWindowHandle();
        System.out.println("parent :" + parentWin);
        System.out.println("parent title:" + driver.getTitle());
        Thread.sleep(2000);
        WebElement btm2 = driver.findElement(By.id("openAll"));
        btm2.click();
        Thread.sleep(2000);
        //Set<String> allOpened = driver.getWindowHandles();
        //driver.switchTo().window(parentWin);

        // closing others will handle by js
        WebElement btn3 = driver.findElement(By.id("closeAll"));
        btn3.click();

        // closing main
        driver.quit();

        // do it manually
        // use a for each and check each windows title or name and compare with
        // parentWin , then if not close it ✅✅✅

    }
}
