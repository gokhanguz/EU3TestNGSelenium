package com.cybertek.tests.day13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

  /*VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.logindriver();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        BrowserUtils.waitFor(4);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage calendar=new CreateCalendarEventsPage();

        calendar.repeat.click();
        Assert.assertTrue(calendar.days.isSelected(),"verify repeat days is selected");
        Assert.assertFalse(calendar.weekday.isSelected(),"verify weekdays is NOT selected");



    }
    @Test
    public void test2(){
        /*
     VERIFY REPEAT OPTIONS
      Open browser
   Login as driver
   Go to Activities->Calendar Events
   Click on create calendar events button
   Click on repeat checkbox
   Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
*/
        LoginPage loginPage=new LoginPage();
        loginPage.logindriver();



        DashboardPage dashboardPage=new DashboardPage();

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
       // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
       // BrowserUtils.waitFor(4);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage calendar=new CreateCalendarEventsPage();

        calendar.repeat.click();

        Select repeatdropDown=calendar.repeatOptionsList();

        //verify that repeat options are ...

        List<String> expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList=new ArrayList<>();

        List<WebElement> actualOptions=repeatdropDown.getOptions();

        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }

        //second easy way(ready method for getting text of list of web elements)
        List<String> actualList2=BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList,expectedList,"verify daily weekly monthly yearly");







    }
}
