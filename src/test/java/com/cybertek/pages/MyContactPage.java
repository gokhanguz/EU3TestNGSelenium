package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyContactPage extends  BasePage{

    WebElement findlocate;

    @FindBy(css = "[class='user-name']")
    public WebElement username;

    @FindBy(css = "[class='phone']")
    public WebElement phoneNumber;


    @FindBy(css = "[class='email']")
    public WebElement email;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> table;

    public WebElement tableClick(){

        for (WebElement webElement : table) {
            if(webElement.getText().contains(ConfigurationReader.get("testemail"))) {
                BrowserUtils.waitFor(3);
                findlocate=webElement;
                break;
            }
        }
        return findlocate;

    }

}
