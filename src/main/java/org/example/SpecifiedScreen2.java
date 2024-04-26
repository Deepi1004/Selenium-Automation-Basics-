package org.example;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SpecifiedScreen2 {
    public static void main(String[] args) throws IOException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> Handels=driver.getWindowHandles();
        Iterator<String> WI=Handels.iterator();

        String ParentWindow= WI.next();
        String ChildWindow=WI.next();

        driver.get("https://rahulshettyacademy.com/");
        String GetName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(5).getText();
        System.out.println(GetName);

        driver.switchTo().window(ParentWindow);

        WebElement Name2=driver.findElement(By.className("form-control"));
        Name2.sendKeys(GetName);

        File Screen=Name2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Screen,new File("C:\\Users\\DELL\\Desktop\\Deepika\\SpecifiedScreen2.png"));

        System.out.println(Name2.getRect().getDimension().getHeight());
        System.out.println(Name2.getRect().getDimension().getWidth());
    }
}
