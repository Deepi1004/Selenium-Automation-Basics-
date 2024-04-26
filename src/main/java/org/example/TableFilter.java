package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.lang.model.util.Elements;
import java.util.List;
import java.util.stream.Collectors;

public class TableFilter {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> ElementsList= driver.findElements(By.xpath("//tr/td[1]"));

        List<String> OrginalList= ElementsList.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String > sortedList=OrginalList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(OrginalList.equals(sortedList));

        List<String> price;

        do
        {
            List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
            price =rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));

            if(price.size()<1)
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()< 1);




    }
    private static String getVeggiePrice(WebElement s) {

        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return pricevalue;

    }
}
