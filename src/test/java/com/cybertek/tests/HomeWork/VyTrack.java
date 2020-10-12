package com.cybertek.tests.HomeWork;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VyTrack extends TestBase {

    @Test
    public void TestCase1(){
        /* 1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page subtitle "Options" is displayed
      */

        extentLogger=report.createTest("Verify Options Sections");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.optionsSection.getText(),"Options","Verify Options");
        extentLogger.pass("Pass");

    }

    @Test
    public void TestCase2(){
      /*  1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page number is equals to "1
      */
        extentLogger=report.createTest("Verify Page Number");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        extentLogger.info("Verify page number");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");
        extentLogger.pass("Pass");
    }

    @Test
    public void TestCase3(){
      /*1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that view per page number is equals to "25"
     */

        extentLogger=report.createTest("Verify View Per Page Number");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        extentLogger.info("Verify that view per page number is equals to 25");
        Assert.assertEquals(calendarEventsPage.viewPerPageNumber.getText(),"25","Verify page number");
        extentLogger.pass("Pass");
    }

    @Test
    public void TestCase4(){

     /*   1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in
        the table) is equals to number of records
      */
        extentLogger=report.createTest("Verify Number of Calendar events");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        extentLogger.info("Verify that number of calendar events (rows in\n" +
                "the table) is equals to number of records");

        BrowserUtils.waitFor(5);


        Assert.assertTrue(calendarEventsPage.totalRecordNumber.getText().contains(Integer.toString(calendarEventsPage.getRow())));

        extentLogger.pass("Pass");

    }
    @Test
    public void TestCase5(){
     /*   1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Click on the top checkbox to select all
        5. Verify that all calendar events were selected

      */

        extentLogger=report.createTest("Verify All Calendar Events selected");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(10);

        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.checkBox.click();

        extentLogger.info("Verify that all calendar events were selected");

        Assert.assertTrue(calendarEventsPage.getIsCheck(),"verify all calendar events selected");

    }

    @Test
    public void TestCase6(){
      /*  1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Select “Testers meeting”
        5. Verify that following data is displayed:

       */
        extentLogger=report.createTest("Verify All Calendar Events selected");
        extentLogger.info("Login with StoreManager");
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        calendarEventsPage.getTıtle("Testers meeting").click();

        BrowserUtils.waitFor(3);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='responsive-block'][1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='responsive-block'][2]")).isDisplayed());
      /*  Assert.assertTrue(calendarEventsPage.getInformation(1).getText().contains("Testers meeting"));
        Assert.assertTrue(calendarEventsPage.getInformation(2).getText().contains("This is a a weekly testers meeting"));
        Assert.assertTrue(calendarEventsPage.getInformation(3).getText().contains("Nov 27, 2019, 9:30 PM"));
        Assert.assertTrue(calendarEventsPage.getInformation(4).getText().contains("Nov 27, 2019, 10:30 PM"));
        Assert.assertTrue(calendarEventsPage.getInformation(5).getText().contains("No"));
        Assert.assertTrue(calendarEventsPage.getInformation(6).getText().contains("Stephan Haley"));
        Assert.assertTrue(calendarEventsPage.getInformation(7).getText().contains("Tom Smith - Required"));
        Assert.assertTrue(calendarEventsPage.getInformation(8).getText().contains("Weekly every 1 week on Wednesday"));
*/

    }

}
