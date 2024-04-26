package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Scrollpage {
    public static  void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");

//        driver.findElement(By.xpath("@//[text()='iFrame Example']"));

//        driver.findElement(By.xpath("/html/body/div[5]/fieldset[1]"));

        WebElement InnerFrame =driver.findElement(By.xpath("//iFrame[@id='courses-iframe']"));
        driver.switchTo().frame(InnerFrame);
        JavascriptExecutor js2=(JavascriptExecutor)driver;
        js2.executeScript("window.scrollBy(0,3000)");




    }
}
