package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest {
    @Test
    void TC1(){
        WebDriver driver = new ChromeDriver(); //B1: Open Browse
        driver.get("https://the-internet.herokuapp.com/login");// B2: Navigate to the page
        driver.findElement(By.id("username")).sendKeys("tomsmith"); // tìm phn tử a vào ID thuộc attribute
        //driver.findElement(By.tagName("input")).sendKeys("tomsmith");// cho phép tm phần tu bang tagname
        //driver.findElement(By.name("username")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("[type=text]")).sendKeys("được nè"); //tìm phần tử theo type thuộc attribute
        //driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tosmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        /*driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*@type='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("SuperSecretPassword!");*/

        driver.findElement(By.cssSelector("[type='submit']")).click();
        /*driver.findElement(By.className("radius")).click();
        driver.findElement(By.cssSelector(".radius")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();*/
        //driver.findElement(By.className(".button secondary radius")).click();
        //Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area"));
        driver.quit();




    }
}
