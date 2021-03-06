package com.cybertek.tests.deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class google_test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");

        WebElement btn1 = driver.findElement(By.id("gbgfbb"));
        String actualText = btn1.getAttribute("value");
        String expectedText = "I'm Feeling Lucky";

        if (actualText.equals(expectedText)) {
            System.out.println("Passed");

        }else{
            System.out.println("Failed");
            System.out.println("Expected text: "+expectedText);
            System.out.println("Actual text: "+actualText);
        }
        Thread.sleep(5000);
        driver.close();



    }
}
