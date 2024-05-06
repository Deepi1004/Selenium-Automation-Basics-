package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

import static org.openqa.selenium.devtools.v119.webauthn.WebAuthn.getCredentials;

public class saucedemo {
    public void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        User user = getCredentials();

//        String username=driver.findElement(By.xpath())
        driver.findElement(By.id("user-name")).sendKeys("username");
        driver.findElement(By.cssSelector("#password")).sendKeys("password");
        driver.findElement(By.cssSelector(".submit-button")).click();
        Thread.sleep(3000);


        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        String itemname = driver.findElement(By.className("inventory_item_name")).getText();
        String itemPrice = driver.findElement(By.className("inventory_item_price")).getText();

//        inventory-item-price
        System.out.println("Name of the item : " + itemname);
        System.out.println("Price of the item : " + itemPrice);

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button[data-test='checkout']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Deepika");
        driver.findElement(By.id("last-name")).sendKeys("Jayaraman");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("637001");
        driver.findElement(By.id("continue")).click();

        Thread.sleep(2000);


        String finalprice = driver.findElement(By.className("inventory_item_price")).getText();
        String tax = driver.findElement(By.cssSelector(".summary_tax_label")).getText();
        String totalpayment = driver.findElement(By.cssSelector("div[data-test='total-label']")).getText();

        System.out.println(" Price of the item : " + finalprice);
        System.out.println(tax);
        System.out.println(totalpayment);

        if (itemPrice.equalsIgnoreCase(finalprice)) {
            System.out.println("Success");
        }

        driver.findElement(By.id("finish")).click();

        driver.close();
//        driver.quit();
    }

    private static User getCredentials() {
        String url = "jdbc:mysql://localhost:3306/sauceuser";
        String dbusername = "root";
        String dbpassword = "password";

        User user = null;

        try (Connection connection = DriverManager.getConnection(url, dbusername, dbpassword)) {

            // Creating Database Connection

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database!");

            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM user where type = 'standard'";

            ResultSet rs = stmt.executeQuery(selectSql);

            while (rs.next()) {
                //Display values
                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User(username, password);

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}


    class User{
        private String username;
        private String password;

        public User(String username,String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

