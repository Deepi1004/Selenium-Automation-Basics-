package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Dropdowntesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
        Thread.sleep(1000);
//        List<WebElement> option2 = driver.findElements(By.cssSelector("li[class='ui-menu-item']a"));
        List<WebElement> option2 = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option :option2) {

            if (option.getText().equalsIgnoreCase("India"))
            {

                option.click();

                break;
            }

        }

//        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();



//        driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
//      driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
//        Thread.sleep(2000);

        driver.findElement(By.cssSelector("li[class='ui-state-highlight'] a")).click();
        WebElement Staticdropdown1=driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        Select dropdown=new Select(Staticdropdown1);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(5000);

        for(int i=1;i<5;i++)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();

//        driver.findElement(By.className("pax-add pax-enabled"))
        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

    }
}
