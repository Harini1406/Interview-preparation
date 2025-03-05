package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.Test;

public class ParallelTesting {
    WebDriver driver;
    //public static void main (String[] args){
        @Test
        public void chrome() throws InterruptedException {
              //System.out.println("Testing1");
            System.setProperty("web-driver.chrome.driver", "path/to/chromedriver");
            driver=new ChromeDriver();
            driver.get("https://www.amazon.com/");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='captchacharacters']")).sendKeys("Text");
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//span[normalize-space()='Continue shopping'])[1]")).click();
        }
        @Test
        public void FireFox(){
            //System.out.println("Testing2");
             System.setProperty("web-driver.gecko.driver","path/to/geckodriver");
             driver=new FirefoxDriver();
             driver.get("https://www.amazon.com/");
             driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("text2");

        }
    }

