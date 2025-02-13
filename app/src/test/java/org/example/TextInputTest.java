package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//using lessons in https://www.leafground.com/input.xhtml

public class TextInputTest {

    // public accessible object
    WebDriver driver;

    // store the common operation separate method
    // this runs before any @Test
    @BeforeEach
    public void openMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxes() {
        WebElement first = driver.findElement(By.id("j_idt88:name"));

        // type anything
        first.sendKeys("Dinuka");

        // append text to an already filled value
        WebElement second = driver.findElement(By.id("j_idt88:j_idt91"));
        second.sendKeys("appended text");

        //3 find if disabled or not
        WebElement third = driver.findElement(By.id("j_idt88:j_idt93"));
        System.out.println(third.isEnabled() ? "Enabled" : "Disabled");

        //clear some text
        WebElement fourth = driver.findElement(By.id("j_idt88:j_idt95"));
        fourth.clear();
        
        //retrieve typed value
        WebElement fifth = driver.findElement(By.id("j_idt88:j_idt97"));
        System.out.println(fifth.getDomProperty("value"));
 
        //move to next input j_idt88:j_idt99
        WebElement sixth = driver.findElement(By.id("j_idt88:j_idt99"));
        sixth.sendKeys("Type something here " + Keys.TAB + "this will be typed in next field");

        //more lessons 


    }

}
