package Testing;

import Utils.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DataProviderExampleTest {
        WebDriver driver;

        @Test(dataProvider = "dataExample", dataProviderClass = DataUtils.class,priority = 1)
        public void loginExample(String Username, String Password){
        System.setProperty("web-driver.chrome.driver","path/to/chromedriver");
//        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.0.189:8083/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='basic_userName']")).sendKeys(Username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@class='ant-btn css-5hzz4u ant-btn-primary ant-btn-block']")).click();

    }
    @Test(dataProvider = "userExample",dataProviderClass = DataUtils.class,priority = 2)
    public void user(String Username, String Role, String Email, String PhoneNo,String Password, String Entity){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//span[text()='Management Console']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//span[text()='User Management']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
            driver.findElement(By.xpath("//span[normalize-space()='Add']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(Username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropdownElement = driver.findElement(By.xpath("//input[@id='roleId']"));
        dropdownElement.click();
        By roleLocator = By.xpath("//span[@class='ant-select-tree-title'][normalize-space()='" + Role + "']");
        WebElement roleElement = driver.findElement(roleLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleElement);
        roleElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='contactNumber']")).sendKeys(PhoneNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropdownElement2 = driver.findElement(By.xpath("//input[@id='ahid']"));
        dropdownElement2.click();
        By entityLocator = By.xpath("//span[@class='ant-select-tree-title'][normalize-space()='" + Entity + "']");
        WebElement entityElement = driver.findElement(entityLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entityElement);
        entityElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();









    }

}
