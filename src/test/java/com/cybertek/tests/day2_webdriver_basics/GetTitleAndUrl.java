package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        //Task open chrome and navigate to  blabla

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.navigate().to("http://practice.cybertekschool.com");

        //getting title with selenium
        //shortcut alt enter---for creating variable

        String title = driver.getTitle();

        // soutv +enter to print variable name and value
        System.out.println("title = " + title);
        
        //getCurrentUrl-->get the url from browser
        String currentUrl=driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
        


    }
}
