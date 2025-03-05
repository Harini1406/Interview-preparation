package Testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("web-driver.gecko.driver", "path/to/geckodriver");
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.amazon.com/");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Path= new File("./Images/img1.png");
        FileHandler.copy(screenshot,Path);
        Thread.sleep(1000);
        WebElement Test1 = driver.findElement(By.xpath("//input[@id='basic_userName']"));
        File screenshot1 = Test1.getScreenshotAs(OutputType.FILE);
        File Path1= new File("./Images/img2.png");
        FileHandler.copy(screenshot1,Path1);
        driver.quit();



//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("text2");
    }

}
