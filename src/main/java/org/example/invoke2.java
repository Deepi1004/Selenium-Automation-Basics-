package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class invoke2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://chandradeep.neocities.org/Event/event");
//        "//h1[@text()='Photo Gallery Event']"
        String text = driver.findElement(By.xpath("//h1[text()='Photo Gallery Event']")).getText();
        System.out.println(text);
    }
}
