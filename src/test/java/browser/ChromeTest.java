package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.performance.Performance;
import org.openqa.selenium.devtools.v132.performance.model.Metric;
import java.util.List;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ChromeTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver= new EdgeDriver();//Mở trình duyệt Chrome
        driver.get("https://youtube.com"); //navigate đến trang youtube
        Assert.assertEquals(driver.getTitle(), "Youtube");//Kiểm tra title của trang có phải là youtube không
        driver.quit();//Đóng trình duyệt

    }

    @Test
    void openHeadlessMode() {// Headless mode là chế độ không có giao diện, nó chạy ẩn trên background
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\maibt\\IdeaProjects\\Selenium_test\\chromedriver.exe");//Set đường dẫn đến file chromedriver.exe khi chưa set path, có r thì ko cần
        ChromeOptions options = new ChromeOptions();//Tạo một đối tượng ChromeOptions
        options.addArguments("--headless");//Thêm tham số --headless vào ChromeOptions
        WebDriver driver = new ChromeDriver(options);//Khởi tạo ChromeDriver với  tham số ChromeOptions, dựa vào đó cho phép mwor trình duyệt với điều kiên headless
        // thường sử dụng để chạy test trên server không có giao diện, CI,  genkin tool, circleCI
        driver.get("https://youtube.com");
        Assert.assertEquals(driver.getTitle(), "Youtube");
        driver.quit();
    }

   /* @Test
    void openWithMobileView() {
        Map<String, Object> deviceMetrics = new HashMap<>();//Tạo một đối tượng Map để lưu thông tin của thiết bị
        deviceMetrics.put("width", 600);//Thêm thông tin chiều rộng của thiết bị
        deviceMetrics.put("height", 882);//Thêm thông tin chiều cao của thiết bị
        Map<String, Object> mobileEmulation = new HashMap<>();//Tạo một đối tượng Map để lưu thông tin của thiết bị mobile
        mobileEmulation.put("deviceMetrics", deviceMetrics);//Thêm thông tin của thiết bị vào Map
        ChromeOptions options = new ChromeOptions();//Tạo một đối tượng ChromeOptions
        options.setExperimentalOption("mobileEmulation", mobileEmulation);//Thêm thông tin của thiết bị vào ChromeOptions
        WebDriver driver = new ChromeDriver(options);//Khởi tạo ChromeDriver với ChromeOptions
        driver.get("https://www.selenium.dev");//Navigate đến trang web
        Assert.assertEquals(driver.getTitle(),"Selenium");
        //driver.quit();

    }*/
    /*@Test
    void openWithChromeOld(){ //Mở trình duyệt với phiên bản cũ
        ChromeOptions options = new ChromeOptions(); //Tạo một đối tượng ChromeOptions
        options.setBrowserVersion("130"); //Set phiên bản trình duyệt
        WebDriver driver = new ChromeDriver(options); //Khởi tạo ChromeDriver với ChromeOptions
        driver.get("https://www.selenium.dev");//Navigate đến trang web
        Assert.assertEquals(driver.getTitle(),"Selenium");//Kiểm tra title của trang
        //driver.quit();

    }*/
    /*@Test
    void openSeleniumHomePageAndCapturePerformanceMetrics(){ //Mở trang web và lấy thông tin performance
        ChromeDriver driver = new ChromeDriver(); //Khởi tạo ChromeDriver
        DevTools devTools = driver.getDevTools(); //Lấy DevTools từ ChromeDriver
        devTools.createSession(); //Tạo một session
        devTools.send(Performance.enable(Optional.empty())); //Gửi yêu cầu enable performance
        List<Metric> metricList = devTools.send(Performance.getMetrics()); //Lấy thông tin performance
        driver.get("https://selenium.dev");

        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();

        for(Metric m : metricList) { //In ra thông tin performance
            System.out.println(m.getName() + " = " + m.getValue());//In ra tên và giá trị của performance
        }
    }
*/
}
