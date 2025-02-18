package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEvents {

    final String filePath = "file:///D:/ST-SQA/first/test-htmls/mouse-event.html";

    @Test
    public void testMouseEvents() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();

        // find all 2 boxes
        WebElement box1 = driver.findElement(By.id("box1"));
        WebElement box2 = driver.findElement(By.id("box2"));

        // call Actions class to initiate the mouse movement and put the current driver
        // in it
        Actions act = new Actions(driver);

        // move to box 1
        act.moveToElement(box1).perform();
        Thread.sleep(2000);
        act.click(box1).perform();
        Thread.sleep(2000);

        // move to box 2
        act.moveToElement(box2).perform();
        Thread.sleep(2000);
        act.click(box2).perform();
        Thread.sleep(2000);

        // click link to move next page
        WebElement linkToPage2 = driver.findElement(By.xpath("//a[@href='dragdrop.html']"));
        act.moveToElement(linkToPage2);
        Thread.sleep(2000);
        act.click(linkToPage2).perform();
        // or
        // linkToPage2.click();

        // ops inside the 2nd page
        dragNDrop(driver, act);

        driver.quit();

    }

    // in second page
    public void dragNDrop(WebDriver driver, Actions act) throws InterruptedException {
        WebElement from = driver.findElement(By.id("dragBox"));
        WebElement to = driver.findElement(By.id("dropZone"));

        // approach 1
        // act.clickAndHold(from).moveToElement(to).release(to).perform();
        // Thread.sleep(2000);

        // or

        // approach 2
        act.dragAndDrop(from, to).perform();
        Thread.sleep(2000);

        //right click
        act.contextClick().perform();
        Thread.sleep(2000);
    }

}
