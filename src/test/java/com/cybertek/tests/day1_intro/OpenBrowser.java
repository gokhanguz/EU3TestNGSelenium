package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {

     //we have to enter this line every time we want to open chrome
     //hey webdirivermaager, can you make chrome ready for me for automation
        WebDriverManager.chromedriver().setup();


     // WebDrivee represent the browser
     // we are creating driver for chrome browser
     // new ChromeDriver()-->this part will open chrome browser
        WebDriver driver=new ChromeDriver();

     //.get(url) method used for navigation to page
        driver.get("https://www.cybertekschool.com");



        WebDriverManager.firefoxdriver().setup();

        WebDriver driver1=new FirefoxDriver();

        driver1.get("https://www.cybertekschool.com");



    }



}
