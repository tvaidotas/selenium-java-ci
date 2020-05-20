package com.qa;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

}
