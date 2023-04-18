package org.example;

import com.github.dockerjava.api.model.CpuStatsConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Verying_links {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.godaddy.com/en-in");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void destroy(){
        driver.quit();
    }
    @Test
    public void verify_links(){
      List<WebElement> elements= driver.findElements(By.tagName("a"));

      for (WebElement e:elements){
          String url= e.getAttribute("href");
          if (url == null ||url.isEmpty()){
              System.out.println("Url is invalid "+ url);
              continue;
          }
          if (!url.startsWith("https://www.godaddy.com/en-in")){
              System.out.println("This url belongs to another domain "+ url);
          }
           try {
               HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
               huc.setRequestMethod("HEAD");
               huc.connect();
               if (huc.getResponseCode()>=400){
                   System.out.println("This is a broken Url Response code is: "+huc.getResponseCode()+" " + url);
               }else {
                   System.out.println("This is a valid Url with Response code: "+huc.getResponseCode()+" "+url);
               }

          } catch (IOException ex) {
               ex.printStackTrace();
           }
      }
    }
}
