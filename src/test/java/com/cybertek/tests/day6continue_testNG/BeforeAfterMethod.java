package com.cybertek.tests.day6continue_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("executed one time before the class");
    }

    @Test
    public void test1(){

        System.out.println("First Test Case");
    }

    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver,Opening Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser,Quit");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("Some Reporting Code Here");
    }


}