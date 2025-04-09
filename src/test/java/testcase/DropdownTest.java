package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownTest {
    /*Open browser
Navigate to https://the-internet.herokuapp.com/dropdown
Select "option 1"
Validate "option 1" is selected*/
    @Test
    void dropdownTest(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select= new Select(driver.findElement(By.id("dropdown")));
        /*select.selectByContainsVisibleText("Option 1"); //Hàm này sẽ tìm kiếm tất cả các phần tử có chứa text "Option 1" và chọn phần tử đầu tiên
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='option[1]']")).isSelected());// lấy phần tử đầu tiên có chứa text "Option 1"*/
        //cách 2
        select.selectByValue("1");// Chọn phần tử có value là 1
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='1']")).isSelected());
        /*river.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.id("dropdown")).click();
        //Assert.assertTrue(driver.findElement(By.tagName("option")).getText().contains("Please select an option"));
        driver.findElement(By.xpath("//select[@id='dropdown']/option[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[1]")).isSelected());*/
        //driver.quit();


    }
    @Test
    void multiSelectTest(){// chn nhiều phần tử trong dropdown
        WebDriver driver= new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select= new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());// kiểm tra dropdown có cho phép chọn nhiều phần tử hay không
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.selectByVisibleText("Orange");
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='Apple']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='Orange']")).isSelected());

        driver.quit();
    }
    @Test
    void verifyTextFielDisible() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));// khai báo thời gian chờ
        //driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("form#input-example input")).isEnabled()); // kểm tra ô input có bị disable hay không
        driver.findElement(By.cssSelector("form#input-example button")).click();// click vào nút Enable
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("form#input-example input")))).isEnabled());
        //Thread.sleep(5000);

        //driver.findElement(By.id("input-example")).click();
        //Assert.assertTrue(driver.findElement(By.cssSelector("form#input-example")).isEnabled());// kiểm tra ô input có bị enable hay không
        driver.quit();

    }
}
