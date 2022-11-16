package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class P10_TagsPage {

    WebDriver driver;

    public P10_TagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
    }

    public String getTagsUrl(){
        return driver.getCurrentUrl();
    }

}
