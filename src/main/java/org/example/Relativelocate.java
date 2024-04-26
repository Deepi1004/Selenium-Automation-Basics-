package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Relativelocate {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement namebox=driver.findElement(By.className("form-control"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(namebox)).getText());

        WebElement dateofbirth=driver.findElement(By.cssSelector("[for='dateofBirth']"));

        driver.findElement(with(By.tagName("Input")).below(dateofbirth)).click();

        WebElement icelabel=driver.findElement(By.className("form-check-label"));

        driver.findElement(with(By.tagName("Input")).toLeftOf(icelabel)).click();

        WebElement radio=driver.findElement(By.id("inlineRadio1"));

        driver.findElement(with(By.tagName("label")).toRightOf(radio)).click();

        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
    }
}
