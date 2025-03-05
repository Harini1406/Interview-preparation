package Testing;

import Utils.DataUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelData {
    static WebDriver driver;

public static void main(String[] args) throws IOException {
    String path = "./ExcelFile/ExcelData.xlsx";
    // FileInputStream file = new FileInputStream(path);
    XSSFWorkbook Wbook = new XSSFWorkbook(path);
    Map<String, String> excelData = new HashMap<>();

    for (int i = 0; i < 2; i++) {
        XSSFSheet sheet = Wbook.getSheetAt(i);
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        for (int j = 1; j <= lastRowNum; j++) {
            XSSFRow row = sheet.getRow(j);

            for (int k = 0; k < lastCellNum; k++) {
                XSSFCell Cell = row.getCell(k);
                DataFormatter dft = new DataFormatter();
                String value = dft.formatCellValue(Cell);
                // String Value = Cell.getStringCellValue();
                String key = "Sheet" + i + "-Row" + j + "-Col" + k;
                excelData.put(key, value);
            }

        }

    }
}



    public void loginExample(Map<String, String> data){
        System.setProperty("web-driver.chrome.driver","path/to/chromedriver");
//        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.0.189:8083/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='basic_userName']")).sendKeys();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@class='ant-btn css-5hzz4u ant-btn-primary ant-btn-block']")).click();

    }

    public void user(Map<String, String> data){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()='Management Console']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()='User Management']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropdownElement = driver.findElement(By.xpath("//input[@id='roleId']"));
        dropdownElement.click();
        By roleLocator = By.xpath("//span[@class='ant-select-tree-title'][normalize-space()='']");
        WebElement roleElement = driver.findElement(roleLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleElement);
        roleElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='contactNumber']")).sendKeys();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropdownElement2 = driver.findElement(By.xpath("//input[@id='ahid']"));
        dropdownElement2.click();
        By entityLocator = By.xpath("//span[@class='ant-select-tree-title'][normalize-space()='']");
        WebElement entityElement = driver.findElement(entityLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entityElement);
        entityElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();


}
}
