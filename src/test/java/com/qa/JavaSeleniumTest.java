package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class JavaSeleniumTest {

    private static WebDriver driver;

    @Before
    public void setup() {
        if (isWindows()){
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "./chromedriver");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        driver = new ChromeDriver(options);
    }

    public boolean isWindows(){
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    @Test
    public void exampleSelenium() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("http://www.google.com/");
        Thread.sleep(1000);
        WebElement googleSearchField = driver.findElement(By.name("q"));
        googleSearchField.sendKeys("funny cat pics");
        Thread.sleep(2000);
        googleSearchField.submit();
        Thread.sleep(2000);
        WebElement pictures = driver.findElement(By.partialLinkText("Images for funny cat"));
        pictures.click();
        Thread.sleep(10000);
        WebElement selectedPicture = driver.findElement(By.className("NZmxZe"));
        assertTrue(selectedPicture.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
