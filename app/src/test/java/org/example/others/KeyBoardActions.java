package org.example.others;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {
     WebDriver driver;

    @BeforeEach
    public void openPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/files.html";
        driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @Test
    public void actionsKeyBoard(){
        Actions action = new Actions(driver);

        //select all in a text box       
        WebElement textBox = driver.findElement(By.id("example"));
        action.keyDown(textBox,Keys.CONTROL).sendKeys("A").keyUp(textBox,Keys.CONTROL).build().perform();

        //type capitals
        action.keyDown(textBox,Keys.SHIFT).sendKeys("random text here").keyUp(textBox,Keys.SHIFT).build().perform();
    }
}
