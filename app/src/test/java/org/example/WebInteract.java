package org.example;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebInteract {

    // #1
    //@Test
    public void typeText() {

        // call webdriver interface
        WebDriver driver = new ChromeDriver();

        // open google site
        driver.get("https://www.google.com");

        // find the textbox by name(use inspect) and type this text , then click enter
        driver.findElement(By.name("q")).sendKeys("Cats" + Keys.ENTER);

    }

    // #2
    //@Test
    public void clickLinks() {

        // call webdriver interface
        WebDriver driver = new ChromeDriver();

        // set the opened window to the full size depends on our pc
        driver.manage().window().maximize();

        // open this test site
        driver.get("https://www.leafground.com/link.xhtml");

        // #1 ✅
        // find the link by link text(use inspect) and then save it as a web element
        // use partialLinkText if the text is too long and just give a portion from it
        WebElement dashboardLink = driver.findElement(By.linkText("Go to Dashboard"));

        // click it
        dashboardLink.click();

        // navigate back(clicking back button of browser) to previous page (to test
        // other links too)
        driver.navigate().back();

        // find other link elements to do other experiments

        // #2 ✅
        // find the URL address without clicking
        WebElement destinationLink = driver.findElement(By.partialLinkText("Find the URL without clicki"));
        String hrefValue = destinationLink.getAttribute("href");
        System.out.println(hrefValue);

        // #3 ✅
        // find a link broken or not
        // if the new redirected title has 404 === its broken
        WebElement susLink = driver.findElement(By.linkText("Broken?"));
        susLink.click();
        // get the title of new redirected page
        String newPageTitle = driver.getTitle();
        if (newPageTitle.contains("404")) {
            System.out.println("This link is a broken link");
        } else {
            System.out.println("this link is working");
        }
        // go back again
        driver.navigate().back();

        // #4 ✅ find duplications(same link text as #1)
        dashboardLink.click();

        // #5 ✅
        // find howmany link elements on this page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

       int linkCountDirectly = allLinks.size();
       System.out.println("linkCountDirectly " + linkCountDirectly);

       // #6 ✅
       // howmany links on just the ayout

       //first find the main class name's element
        WebElement mainLayoutElement = driver.findElement(By.className("layout-main-content"));
        List linksInMainLayout = mainLayoutElement.findElements(By.tagName("a"));
        System.out.println("links count in main layout : " + linksInMainLayout.size());

    }

}
