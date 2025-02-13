package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//https://www.leafground.com/button.xhtml

public class ButtonsTest {

    // public accessible object
    WebDriver driver;

    // store the common operation separate method
    // this runs before any @Test
    @BeforeEach
    public void openMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonsInteract() {

        // to click >> find and use .click(); ✅
        // to find disabled or not , use the same logic from text inputs ✅

        // find coordinates (Position) ✅
        WebElement btn1 = driver.findElement(By.id("j_idt88:j_idt94"));
        Point coords = btn1.getLocation();
        int x = coords.getX();
        int y = coords.getY();
        System.out.println("x: " + x + " y: " + y);

        // find css values ✅
        WebElement btn2 = driver.findElement(By.id("j_idt88:j_idt96"));
        System.out.println(btn2.getCssValue("background-color"));

        // find height and weight ✅
        System.out.println(" width: " + btn2.getSize().getWidth());
        System.out.println(" height:  " + btn2.getSize().getHeight());
    }

}
