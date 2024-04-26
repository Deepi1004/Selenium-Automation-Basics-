package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

//        String username=driver.findElement(By.xpath())
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button")).click();
        Thread.sleep(3000);


        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        String itemname=driver.findElement(By.className("inventory_item_name")).getText();
        String itemPrice=driver.findElement(By.className("inventory_item_price")).getText();

//        inventory-item-price
        System.out.println("Name of the item : "+itemname );
        System.out.println("Price of the item : "+itemPrice);

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button[data-test='checkout']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Deepika");
        driver.findElement(By.id("last-name")).sendKeys("Jayaraman");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("637001");
        driver.findElement(By.id("continue")).click();

        Thread.sleep(2000);


        String finalprice = driver.findElement(By.className("inventory_item_price")).getText();
        String tax =driver.findElement(By.cssSelector(".summary_tax_label")).getText();
        String totalpayment= driver.findElement(By.cssSelector("div[data-test='total-label']")).getText();

        System.out.println(" Price of the item : "+finalprice);
        System.out.println(tax);
        System.out.println(totalpayment);

        if(itemPrice.equalsIgnoreCase(finalprice))
        {
            System.out.println("Success");
        }

        driver.findElement(By.id("finish")).click();

        driver.close();
//        driver.quit();


    }
}
