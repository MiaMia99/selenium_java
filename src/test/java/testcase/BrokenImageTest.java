package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageTest {
    @Test
    void verifyBrokenImage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));//Tìm tất cả các phần tử img trong thẻ div có class là example
        images.forEach(image ->{ //Duyệt qua từng phần tử img
            String imageUrl = image.getDomAttribute("src"); // Lấy thuộc tính src của phần tử img
            String naturalWidth = image.getDomAttribute("naturalWidth"); // Lấy thuộc tính naturalWidth của phần tử img
            String naturalHeight = image.getDomAttribute("naturalHeight"); // Lấy thuộc tính naturalHeight của phần tử img
            System.out.println("Image URL: " + imageUrl);
            System.out.println("Natural Width: " + naturalWidth);
            System.out.println("Natural Height: " + naturalHeight);
        });
        Assert.assertEquals(images.get(0).getDomProperty("naturalWidth"),"0"); //Kiểm tra xem chiều rộng tự nhiên của ảnh đầu tiên có bằng 0 hay không

        Assert.assertEquals(images.get(1).getDomProperty("naturalHeight"),"0");
        Assert.assertEquals(images.get(2).getDomProperty("naturalHeight"),"0");//Kiểm tra xem chiều cao tự nhiên của ảnh đầu tiên có bằng 0 hay không
        driver.quit();
    }
}
