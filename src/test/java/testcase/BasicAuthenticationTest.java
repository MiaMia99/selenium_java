package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthenticationTest {
    @Test
    void verifyLoginWithValidCredentials() { //kiểm tra đăng nhập với thông tin hợp lệ
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //URL có chứa thông tin đăng nhập: username: admin, password: admin
        String message = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(message.contains("Congratulations! You must have the proper credentials"));
    }
}
