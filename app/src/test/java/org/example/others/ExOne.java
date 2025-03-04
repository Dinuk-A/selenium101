package org.example.others;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExOne {

    WebDriver driver;

    @BeforeEach
    public void openPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/files.html";
        driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    // find broken images
    @Test
    public void findBrokenImgs() {
        List<WebElement> allImgs = driver.findElements(By.tagName("img"));
        for(WebElement img: allImgs){
            if (img.getDomAttribute("naturalWidth").equals("0")) {
                //find a property to identify the exact image
                System.out.println("img is broken");
            }
        }
    }

}
