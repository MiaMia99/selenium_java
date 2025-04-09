package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class checkBoxTestTC02 {
    @Test
    void checkBoxTestTC01(){
        /*
         1. Open browser
         2. navigate to:
         3. check on checkbox1
         4. verify checkbox1 is checked
         5. check on checkbox2
         6. verify checkbox2 is checked
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).isSelected());
        driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
        //WebElement checkbox1= driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).isSelected());
        driver.quit();

    }
    @Test
    void VerifyCheckallButtonWorking() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        WebElement checkall=driver.findElement(By.xpath("//button[@data-test='check-all-button']"));
        checkall.click();
        // driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"));
        //driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"));
        //driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']"));
        //driver.findElement(By.cssSelector("button[data-test='check-all-button']"));
        //driver.findElement(By.xpath("//button[@data-test='uncheck-all-button']"));
        //driver.findElement(By.cssSelector("button[data-test='uncheck-all-button']"));
        checkall.click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']")).isSelected());
        driver.quit();
    }
    @Test
    void VerifyUnCheckallButtonWorking() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        WebElement checkall=driver.findElement(By.xpath("//button[@data-test='check-all-button']"));
        checkall.click();
        driver.findElement(By.cssSelector("button[data-test='uncheck-all-button']")).click();
        //WebElement chechbox1= driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"));
        WebElement checkbox1=driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox1']"));
        //WebElement chechbox2=driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"));
        WebElement checkbox2=driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox2']"));
        WebElement checkbox3=driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']"));
        //WebElement checkbox3=driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']"));
        //WebElement checkall=driver.findElement(By.cssSelector("button[data-test='check-all-button']"));
        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());
        Assert.assertFalse(checkbox3.isSelected());
        driver.quit();
    }
    @Test
    void ableToCheckAllCheckboxes(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        driver.findElement(By.cssSelector("button[data-test='check-all-button']")).click();
        driver.findElement(By.cssSelector("button[data-test='uncheck-all-button']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']")).isSelected());
        driver.quit();

    }

}
