package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Ecommerce {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        String[] itemsneed={"Cucumber","Carrot","Beetroot","Tomato"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(4000);
        addItems(driver,itemsneed);
    }
    public static void addItems(WebDriver driver,String[] itemsneed){

        int j=0;

        List<WebElement> product=driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<product.size();i++)

        {
            String[] name=product.get(i).getText().split("-");

            String formattedname=name[0].trim();

            List itemsneedList = Arrays.asList(itemsneed);

            if (itemsneedList.contains(formattedname))
            {
                j++;

                driver.findElements(By.cssSelector(".increment")).get(i).click();
//                driver.findElements(By.cssSelector(".increment")).get(i).click();

//                driver.findElements(By.xpath("//div[@]"))
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();



                if(j==itemsneed.length)
                {
                 break;
                }

            }

        }

    }
}
