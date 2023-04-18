package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Godaddy_Nav_Bar {
    WebDriver driver;
    @BeforeClass
    @Parameters("Url")
    public void setup(String url){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void destroy(){
        driver.quit();
    }
    @Test(priority = 0)
    public void Domain()throws  InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Domain =driver.findElement(By.className("fsp77ll"));
        Domain.click();
        WebElement Domain_Names_search= driver.findElement(By.linkText("Domain Name Search"));
       Domain_Names_search.click();
        Thread.sleep(2000);
        driver.navigate().back();
    }
@Test(priority = 1)
    public  void Transfer_Your_Domains() throws InterruptedException {
        WebElement tranfer_domain=driver.findElement(By.linkText("Transfer Your Domains"));
        tranfer_domain.click();
        Thread.sleep(2000);
        driver.navigate().back();
}
@Test(priority = 2)
    public void Hosting() throws InterruptedException {
        WebElement Hosting = driver.findElement(By.className("fsp77ll"));
        Hosting.click();
        Thread.sleep(2000);
        driver.navigate().back();
}

}
