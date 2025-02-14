package org.example;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxAndRadio {

    // public accessible object
    WebDriver driver;

    // store the common operation separate method
    // this runs before any @Test
    @BeforeEach
    public void openMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkBoxesTest() throws InterruptedException {
        driver.get("https://www.leafground.com/checkbox.xhtml");
        WebElement input1 = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']/div[2]"));
        input1.click();

        // click the ones we want
        // by label for
        WebElement javaInput = driver.findElement(By.xpath("//label[@for='j_idt87:basic:0']"));
        javaInput.click();

        // by displaying value
        WebElement jsInput = driver.findElement(By.xpath("//label[contains(text(), 'Javascript')]"));
        jsInput.click();

        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void radioTest() throws InterruptedException {
        driver.get("https://www.leafground.com/radio.xhtml");

        // use click as same as CB above ✅

        // get defaultly clicked value
        // isSelected is only applicable for inputs
        List<WebElement> allRadios = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int index = -1;
        for (WebElement radio : allRadios) {
            index++;
            if (radio.isSelected()) {
                WebElement labelOfSelectedRadio = driver
                        .findElement(By.xpath("//label[@for='j_idt87:console2:" + index + "']"));
                System.out.println(labelOfSelectedRadio.getText());
            }
        }

        Thread.sleep(3000);
        driver.close();

    }

    // theres more, but use another template

}
