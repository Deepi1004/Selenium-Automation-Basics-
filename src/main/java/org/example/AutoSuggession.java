package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggession {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);
//        ui-id-82 ui-id-40
//        driver.findElement(By.id("ui-id-82")).click();
        List<WebElement> option1 = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));


        for (WebElement option : option1) {

            if (option.getText().equalsIgnoreCase("India")) {

                option.click();

                break;


            }
        }
    }
}
