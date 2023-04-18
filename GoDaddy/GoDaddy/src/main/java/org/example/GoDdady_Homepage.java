package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GoDdady_Homepage {
WebDriver driver;
    @BeforeClass
        public void setup() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void destroy(){
        driver.quit();
    }
    @Test(priority = 0)
    public void window_maximize(){
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void print_page_title(){
        String title = driver.getTitle();
        System.out.println("Title of the webpage is :"+title);
    }
    @Test(priority = 2)
    public void Verify_page_title(){
        String expected_title="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
        String actual_title = driver.getTitle();
        Assert.assertEquals(expected_title,actual_title);
        System.out.println("Success");
    }



}
