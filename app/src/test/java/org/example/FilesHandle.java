package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FilesHandle {
    WebDriver driver;

    @BeforeEach
    public void openPage() {
        final String filePath = "file:///D:/ST-SQA/first/test-htmls/files.html";
        driver = new ChromeDriver();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @Test
    public void uploadfILES() throws InterruptedException, AWTException {

        // click upload btn
        // input tags with file as type cannot be clicked using .click()
        /*
         * instead click a button and let that button invoke a function that clicks the
         * input
         */

        WebElement upldBtn = driver.findElement(By.id("fileUpldInputBtn"));
        upldBtn.click();

        // wait for the window to open
        Thread.sleep(2000);

        // after this point we dont have services of selenium because now the focus is
        // on the windows, not on a web app

        // save the file path we wanted to upload
        StringSelection ss = new StringSelection(
                "C:\\Users\\Dinuka Pramod\\Downloads\\Dinuka - Progress Report 03.pdf");

        // set it as "copied" on clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // paste that on the window opened by input
        // use ROBO for vertual keyboard
        Robot robo = new Robot();
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robo.keyRelease(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(1000);

        // click enter
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(3000);

    }

    @Test
    public void confirmDownedFiles() throws InterruptedException {

        // first search and locate the DOWNLOAD BUTTON by ID
        // click it
        //then we confirm we downloaded the file successfully

        File downloadFolder = new File("C:\\Users\\Dinuka Pramod\\Downloads\\Telegram Desktop");

        File[] allFiles = downloadFolder.listFiles();

        for(File file:allFiles){
            if(file.getName().equals("px.jpg")){
                System.out.println("file successully downloaded");
                break;
            }else{
                System.out.println("cant find");
            }
        }
    }

    @AfterEach
    public void closeAll() {
        driver.quit();
    }
}
