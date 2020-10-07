package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.MyContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest(){
        //name of the test
        extentLogger=report.createTest("Wrong Password Test");

        extentLogger.info("Enter Username:user1");
        driver.findElement(By.id("prependedInput")).sendKeys("user1");

        extentLogger.info("Enter Password:password");
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");

        extentLogger.info("Click login button");
        driver.findElement(By.id("_submit")).click();


        extentLogger.info("verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");
    }
   /* @Test
    public void wrongPasswordTest1(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }*/

    @Test
    public void wrongUsernameTest(){
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login/45");
        extentLogger.pass("PASSED");
    }
    @Test
    public void test123(){
        /**
         * open the chrome
         * go to qa1.vytrack
         * login as a sales manager
         * navigate to customers ->contacts
         * click on email mbrackstone9@example.com
         * verify that full name is Mariam Brackstone
         * verify that email is mbrackstone9@example.com
         * verify that phone number is +18982323434
         */
        extentLogger = report.createTest("Email Information Check");
        extentLogger.info("");
        LoginPage loginPage=new LoginPage();
        extentLogger.info("Log in with sales manager ");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage=new DashboardPage();
        extentLogger.info("Navigate to Contacts page");
        dashboardPage.navigateToModule("Customers","Contacts");
        BrowserUtils.waitFor(3);

        MyContactPage contactPage=new MyContactPage();
        extentLogger.info("Click Email ");
        contactPage.tableClick().click();

        extentLogger.info("Verify user name");
        
        Assert.assertEquals(contactPage.username.getText(),ConfigurationReader.get("testusername"),"Verify user name");
        extentLogger.info("Verify email");

        Assert.assertEquals(contactPage.email.getText(),"mbrackstone9@example.com","Verify mail");
        extentLogger.info("Verify Phone number");

        Assert.assertEquals(contactPage.phoneNumber.getText(),ConfigurationReader.get("testnumber"),"Verify phone number");
        extentLogger.pass("PASSED");

    }


}
