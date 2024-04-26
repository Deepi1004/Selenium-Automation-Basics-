package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Scrollpage2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for(int i = 0;i< values.size();i++){
            System.out.println(Integer.parseInt(values.get(i).getText()));
            sum+= Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        String label = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        int total = Integer.parseInt(label);
        Assert.assertEquals(sum,total);
    }
}