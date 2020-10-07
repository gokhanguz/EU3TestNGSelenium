package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork {

    WebDriver driver;
    @BeforeMethod
    public void BeforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("22/55/1988");
        String expectedResult="The date of birth is not valid";
        String actualResult=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[8]/div/small[2]")).getText();
        Assert.assertEquals(actualResult,expectedResult,"verify same text");

    }
    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        WebElement Cplus= driver.findElement(By.xpath("//label[@*='inlineCheckbox1']"));
        System.out.println("Cplus.getText() = " + Cplus.getText());
        WebElement java= driver.findElement(By.xpath("//label[@*='inlineCheckbox2']"));
        WebElement Javascript= driver.findElement(By.xpath("//label[@*='inlineCheckbox3']"));

        Assert.assertTrue(Cplus.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(Javascript.isDisplayed());
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("a");
        Thread.sleep(5000);
       String actual= driver.findElement(By.xpath("(//*[@data-bv-validator='stringLength'])[1]")).getText();
       String expected="first name must be more than 2 and less than 64 characters long";
       Assert.assertEquals(actual,expected);

    }
    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        driver.findElement(By.name("lastname")).sendKeys("s");
        String actual=driver.findElement(By.xpath("(//*[@data-bv-validator='stringLength'])[2]")).getText();
        String expected="The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("James");
        driver.findElement(By.name("lastname")).sendKeys("Pumper");
        driver.findElement(By.name("username")).sendKeys("james35");
        driver.findElement(By.name("email")).sendKeys("james35@cybertek.com");
        driver.findElement(By.name("password")).sendKeys("james3506");
        driver.findElement(By.name("phone")).sendKeys("555-555-5555");
        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("01/02/1988");
        WebElement DepartmanOffice=driver.findElement(By.name("department"));
        Select departman= new Select(DepartmanOffice);
        departman.selectByIndex(2);
        WebElement JobTıtle= driver.findElement(By.xpath("//*[@name='job_title']"));
        Select job=new Select(JobTıtle);
        job.selectByVisibleText("SDET");
        driver.findElement(By.xpath("//label[@*='inlineCheckbox1']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String actual=driver.findElement(By.xpath("//p")).getText();
        String expected="You've successfully completed registration!";
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.xpath("//*[@class='animace']")).getText();
        System.out.println("email = " + email);
        Thread.sleep(2000);

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[href^='/sign']")).click();
        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("Mike Grey");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actual=driver.findElement(By.name("signup_message")).getText();
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected);

        driver.get("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        String cyberEmail=driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[2]/div[1]/div/table/tbody/tr[1]/td[1]")).getText();
        System.out.println("cyberEmail = " + cyberEmail);
        String exectedemail=" do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(cyberEmail,exectedemail);

        driver.findElement(By.xpath("//td[@class='from']")).click();
        String emailOpen=driver.findElement(By.cssSelector("#odesilatel")).getText();
        String expectenOpenEmail="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(emailOpen,expectenOpenEmail);

        String thank=driver.findElement(By.id("predmet")).getText();
        String expectedThank="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(thank,expectedThank);

    }
    @Test
    public void test7() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/upload']")).click();
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/C:/Users/Gokhan/Desktop/New Text Document.txt/");

        driver.findElement(By.cssSelector("#file-submit")).click();
        String fileUpload=driver.findElement(By.tagName("h3")).getText();
        String expextedFile="File Uploaded!";
        Assert.assertEquals(fileUpload,expextedFile);

        String fileName=driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedNAme="New Text Document.txt";
        Assert.assertEquals(fileName,expectedNAme);

    }
    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();
        String text=driver.findElement(By.id("result")).getText();
        String expected="You selected: United States of America";
        Assert.assertEquals(text,expected);

    }
    @Test
    public void test9(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/status']")).click();
        driver.findElement(By.cssSelector("[href$='200']")).click();

        System.out.println(driver.findElement(By.xpath("//p")).getText());
        String text=driver.findElement(By.xpath("//p")).getText();
        String expexcted="This page returned a 200 status code";

        Assert.assertTrue(text.contains(expexcted));


    }
    @Test
    public void test10(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/status']")).click();
        driver.findElement(By.cssSelector("[href$='301']")).click();

        System.out.println(driver.findElement(By.xpath("//p")).getText());
        String text=driver.findElement(By.xpath("//p")).getText();
        String expexcted="This page returned a 301 status code";

        Assert.assertTrue(text.contains(expexcted));


    }
    @Test
    public void test11(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/status']")).click();
        driver.findElement(By.cssSelector("[href$='404']")).click();

        System.out.println(driver.findElement(By.xpath("//p")).getText());
        String text=driver.findElement(By.xpath("//p")).getText();
        String expexcted="This page returned a 404 status code.";

        Assert.assertTrue(text.contains(expexcted));


    }
    @Test
    public void test12(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/status']")).click();
        driver.findElement(By.cssSelector("[href$='500']")).click();

        System.out.println(driver.findElement(By.xpath("//p")).getText());
        String text=driver.findElement(By.xpath("//p")).getText();
        String expexcted="This page returned a 500 status code.";

        Assert.assertTrue(text.contains(expexcted));


    }

}
