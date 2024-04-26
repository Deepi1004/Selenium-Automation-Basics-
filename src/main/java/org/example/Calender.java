package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {
    public static void main(String[] args) {

        String Month="6";
        String Date="26";
        String Year="2028";

        String[] List={Month,Date,Year};

        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(Month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+Date+"']")).click();
        driver.findElement(By.xpath("react-calendar__month-view__days__day")).click();
    }
}