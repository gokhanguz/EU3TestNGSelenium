package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumCheckoxHW {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox= driver.findElement(By.cssSelector("input#isAgeSelected"));

        //how to verify checkbox is selected or not ?
        System.out.println("checkBox.isSelected() = " + checkBox.isSelected());
        Assert.assertFalse(checkBox.isSelected(),"checkbox is NOT selected");

        //check message before click
        WebElement message1= driver.findElement(By.id("txtAge"));

        Assert.assertFalse(message1.isDisplayed(),"message 1 is NOT displayed");

        //click checkbox
        checkBox.click();
        System.out.println("checkBox.isSelected() = " + checkBox.isSelected());
        Assert.assertTrue(checkBox.isSelected(),"checkbox is selected");

        //verify get message after click

        WebElement message= driver.findElement(By.id("txtAge"));
        System.out.println("message.getText() = " + message.getText());
        String expectedResult="Success - Check box is checked";
        String acctuaResult= message.getText();

        Assert.assertEquals(expectedResult,acctuaResult);

        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //verify check all button

        WebElement CheckAllButton= driver.findElement(By.cssSelector("input.btn.btn-primary"));
        System.out.println("CheckAllButton.getAttribute(\"value\") = " + CheckAllButton.getAttribute("value"));
        Assert.assertEquals(CheckAllButton.getAttribute("value"),"Check All","verify Check All button display");

        //click Check all button
        CheckAllButton.click();
        Thread.sleep(2000);

        //verify check all check box are checked
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Option 1']/input")).isSelected(),"verify option 1 selected");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Option 2']/input")).isSelected(),"verify option 2 selected");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Option 3']/input")).isSelected(),"verify option 3 selected");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Option 4']/input")).isSelected(),"verify option 4 selected");

        //verify uncheck all button
        WebElement uncheckButton= driver.findElement(By.cssSelector("input.btn.btn-primary"));
        System.out.println("uncheckButton.getAttribute(\"value\") = " + uncheckButton.getAttribute("value"));
        Assert.assertEquals(uncheckButton.getAttribute("value"),"Uncheck All","verify Uncheck All type");

        driver.quit();

    }


}
