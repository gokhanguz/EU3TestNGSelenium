package com.cybertek.tests.day3_webelemet_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLChanged {

    public static void main(String[] args) {
      /*  verify URL Changed
         -open chrome browser
        -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        -enter any email
        -click on Retrieve password
        -verify that url changed to http://practice.cybertekschool.com/email_sent
     */

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");


        //enter any email

        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");


        WebElement retrievePasswordButton= driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";

        String actualUrl=driver.getCurrentUrl();


        //verify that url changed to http://practice.cybertekschool.com/email_sent

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("False");
        }

        driver.quit();














    }
}
