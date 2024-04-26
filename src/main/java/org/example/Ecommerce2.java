package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ecommerce2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait W=new WebDriverWait(driver,Duration.ofSeconds(5));

        String[] itemsneed={"Cucumber","Carrot","Beetroot","Tomato"};

        String[] itemsadded={"Beetroot","Cucumber"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(2000);

        addeditems(driver,itemsadded);

        addItems(driver,itemsneed);

        driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();
//        driver.findElement(By.xpath("//div[@class=' ']/button")).click();
//        driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[2]/button")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[@text='button']/button")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
//        Thread.sleep(2000);

        W.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector(".promoBtn")).click();

        W.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

        System.out.println(driver.findElement(By.className("promoInfo")));

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        driver.findElement(By.xpath("//option[@value='India' and text()='India']")).click();
        driver.findElement(By.cssSelector(".chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
    public static void addItems(WebDriver driver,String[] itemsneed) throws InterruptedException {

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

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();



                if(j==itemsneed.length)
                {
                    break;
                }



            }

        }
//   //*[@id="root"]/div/header/div/div[3]/a[4]/img


    }


    public static void addeditems(WebDriver driver,String[] itemsadded){

        int j=0;

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)

        {
            String[] name=products.get(i).getText().split("-");

            String formattedname2=name[0].trim();

            List itemsaddedList = Arrays.asList(itemsadded);

            if (itemsaddedList.contains(formattedname2))
            {
                j++;

                driver.findElements(By.cssSelector(".increment")).get(i).click();


//            driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j==itemsadded.length)
                {
                    break;
                }

            }

        }
    }

}


