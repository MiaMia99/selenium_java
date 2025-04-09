package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hyperlink {
    @Test
    void checkHyperlink() {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.linkText("200")).click(); //Click vào link có text là 200
        //driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();//đâylà cách 2 sử dung xpath để click vào link
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");//Kiểm tra xem URL hiện tại có phải là https://the-internet.herokuapp.com/status_codes/200 hay không
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content")))); //Chờ cho phần tử có id là content xuất hiện, đây là phần tử chứa nội dung của trang
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 200 status code")); //Kiểm tra xem trang có chứa text "200 OK" hay không

        //Click vào link có href là /status_codes/301
        driver.findElement(By.linkText("here")).click();
        //driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        driver.findElement(By.linkText("301")).click();
        //driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();
        //Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        Assert.assertTrue(driver.getCurrentUrl().contains("/status_codes/301"));// cách 2: sử dụng hàm contains trong assertTrue
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 301 status code"));

        //Click vào link có href là /status_codes/404
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
        //Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 404 status code"));

        //Click vào link có href là /status_codes/500
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 500 status code"));




    }
}
