package com.cybertek.tests.day13_properties_driver_testbase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    WebDriver driver;
    @Test
    public void test1(){
        String s1=Singleton.getInstance();
        //after 100 lines of code
        String s2=Singleton.getInstance();
        System.out.println("s1= "+s1);
        System.out.println("s1= "+s2);
    }
    @Test
    public void test2(){
        //this is how we create webdriver object from now on
        //type of the driver will come from configuration.properties file
        driver= Driver.get();
        //we are getting url from configuration.properties  file
        // Driver.get().get(ConfigurationReader.get("url"));//or you can use that  one instead of below
        driver.get(ConfigurationReader.get("url"));
        driver.navigate().refresh();
    }
    @Test
    public void test3() throws InterruptedException{
        Thread.sleep(2000);
        //first get getting the Driver second get is coming from selenium
        // Driver.get().get("http://amazon.com");//also you can use this instead of below
        driver= Driver.get();
        driver.get("http://amazon.com");
        //if we are using Driver close,we use closeDriver method to close the driver
        Driver.closeDriver();
    }
}