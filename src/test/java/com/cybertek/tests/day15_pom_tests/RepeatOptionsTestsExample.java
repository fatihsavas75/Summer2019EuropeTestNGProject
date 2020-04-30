package com.cybertek.tests.day15_pom_tests;

import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.CreateCalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RepeatOptionsTestsExample extends TestBase {
    @Test
    public void radioButtons(){
        extentLogger=report.createTest("Radio Buttons");
        LoginPage loginPage=new LoginPage();
        extentLogger.info("Login page");
        String username= ConfigurationReader.get("driver_username");
        extentLogger.info("Enter username");
        String password=ConfigurationReader.get("driver_password");
        extentLogger.info("Enter password");
        loginPage.login(username,password);
        extentLogger.info("click login button");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Hover over Calendar Events");
        CalenderEventsPage calendarEventsPage=new CalenderEventsPage();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click Create Calendar Events Button");
        CreateCalenderEventsPage createCalendarEventsPage=new CreateCalenderEventsPage();
        //BrowserUtils.waitFor(5);
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click repeat radio button");
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify days button is selected");
        extentLogger.info("Pass: day selected");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify that weekday is not selected");
        extentLogger.info("Pass: weekday is not selected");
    }
}