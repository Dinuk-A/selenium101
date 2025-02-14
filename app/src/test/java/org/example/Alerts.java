package org.example;

import java.nio.file.WatchEvent;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    final String filePath = "file:///D:/ST-SQA/first/test-htmls/alert.html";

    @Test
    public void alertsTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(filePath);

        // first find all 3 buttons
        WebElement alertBtn = driver.findElement(By.id("alertBtn"));
        WebElement confirmBtn = driver.findElement(By.id("confirmBtn"));
        WebElement promptBtn = driver.findElement(By.id("promptBtn"));

        // #1 work with alert ✅
        // click
        alertBtn.click();
        // wait 2 secs to show
        Thread.sleep(2000);
        // switch inside to the alert box(focus on alert box)
        Alert alertBox = driver.switchTo().alert();
        // get the text in it
        System.out.println("alert box says: " + alertBox.getText());
        // click the OK button. after this the focus is back on main page
        alertBox.accept();

        // #2 work with confirm ✅
        // click
        confirmBtn.click();
        // wait 2 secs to show
        Thread.sleep(2000);
        // switch inside to the alert box(focus on alert box)
        Alert confirmBox = driver.switchTo().alert();
        // click OK first
        confirmBox.accept();
        // wait 2 secs to show
        Thread.sleep(2000);
        // click button again
        confirmBtn.click();
        // switch back to box
        driver.switchTo().alert();
        // click cancel this time
        confirmBox.dismiss();

        // #3 work with prompt ✅
        promptBtn.click();
        Thread.sleep(2000);
        Alert promptBox = driver.switchTo().alert();
        // type in input
        promptBox.sendKeys("dinuka pramod");
        Thread.sleep(2000);
        promptBox.accept();
        Thread.sleep(2000);

        // wait 2 secs to show
        Thread.sleep(2000);
        // click OK again
        promptBox.accept();

        // finally close
        driver.close();
    }
}
