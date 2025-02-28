package org.example;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesTest {
    WebDriver driver;

    @BeforeEach
    public void openMainPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/iframeparent.html";
        driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    // interact with elements inisde the iframe
    // cant use xpath directly
    // has to switch to the child frame
    @Test
    public void iFrameTest1() throws InterruptedException {

        // switch by index (0 === first element)
        // driver.switchTo().frame(0);

        // switch by unique id name
        // driver.switchTo().frame("firstIFrameId");

        // or use xpath indirectly
        // cant use directly
        WebElement ifr = driver.findElement(By.xpath("//iframe[@src='iframechild.html']"));
        driver.switchTo().frame(ifr);

        WebElement btn = driver.findElement(By.id("btnIFrame"));
        btn.click();
        btn.click();
        Thread.sleep(1000);
        btn.click();
        btn.click();
        Thread.sleep(1000);
        btn.click();
        System.out.println("Text in first ifr child btn: " + btn.getText());

        // switch back to its parent html
        driver.switchTo().parentFrame();

        Thread.sleep(1000);
        WebElement mainBtn = driver.findElement(By.id("parentBtn"));
        mainBtn.click();
        mainBtn.click();
        mainBtn.click();
        System.out.println("Text in Main btn: " + mainBtn.getText());

    }

    @Test
    public void iFrameTestNested() throws InterruptedException {

        // go to first frame
        // switch by index (0 === first element)
        driver.switchTo().frame(0);

        // go to its first frame too
        driver.switchTo().frame(0);

        // click nested button
        WebElement nestedBtn = driver.findElement(By.id("nestedBtn"));
        nestedBtn.click();
        nestedBtn.click();
        Thread.sleep(1000);
        nestedBtn.click();
        nestedBtn.click();
        Thread.sleep(1000);
        nestedBtn.click();
        System.out.println("Text in nestedBtn: " + nestedBtn.getText());

        // come back to main doc 
        // driver.switchTo().parentFrame();
        // driver.switchTo().parentFrame();

        // without using driver.switchTo().parentFrame(); twice
        driver.switchTo().defaultContent();

        // click main button
        WebElement mainBtn = driver.findElement(By.id("parentBtn"));
        mainBtn.click();
        mainBtn.click();
        Thread.sleep(1000);
        mainBtn.click();
        System.out.println("Text in Main btn: " + mainBtn.getText());

    }

    //count how many iframes in total WRONG WAY ❌
    //but cant count nested iframes
    //only direct child ifs are counted
    @Test
    public void countIFSWrongWay(){
        List<WebElement> iFS = driver.findElements(By.tagName("iframe"));
        System.out.println(iFS.size());
    }

    // an attr of class
    public int iFrsCount = 0;

    //count how many iframes in total CORRECT WAY ✅
    @Test
    public void countIFS(){
     
        List<WebElement> iFrs = driver.findElements(By.tagName("iframe"));
        while (iFrs.size()>0) {
            countIFS();
            iFrsCount =iFrs.size();
        }

        System.out.println("Total iframe count: " + iFrsCount);

    }


    @AfterEach
    public void closeAll() {
        driver.quit();
    }

}
