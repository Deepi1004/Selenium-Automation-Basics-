package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");

        System.out.println(driver.findElements(By.tagName("a")).size());

       WebElement footerList= driver.findElement(By.cssSelector("#gf-BIG"));
        System.out.println(footerList.findElements(By.tagName("a")).size());

//        *[@id="gf-BIG"]/table/tbody/tr/td[1]/ul
        WebElement column =footerList.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(column.findElements(By.tagName("a")).size());

        for(int i = 1; i< column.findElements(By.tagName("a")).size(); i++) {

            String LinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            column.findElements(By.tagName("a")).get(i).sendKeys(LinkTab);
            Thread.sleep(5000);

        }

            Set<String> page=driver.getWindowHandles();
            Iterator<String> nav=page.iterator();

            while(nav.hasNext())
            {

                driver.switchTo().window(nav.next());
                System.out.println(driver.getTitle());

            }


    }
}
