package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SoftAssertion {
    public static void main(String[] args) throws IOException {

        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> Links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
//        System.out.println(Links);

        SoftAssert Status=new SoftAssert();

        for(WebElement Link:Links)
        {
            String url= Link.getAttribute("href");

            HttpURLConnection connect=(HttpURLConnection)new URL(url).openConnection();

            connect.setRequestMethod("HEAD");
            connect.connect();

            int resposecode= connect.getResponseCode();

            System.out.println(resposecode);

            Status.assertTrue(resposecode<400,"The link with Text"+" "+Link.getText()+" is broken with code"+" "+resposecode);
        }
        Status.assertAll();
    }
}
