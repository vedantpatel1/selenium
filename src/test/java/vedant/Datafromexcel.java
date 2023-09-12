package vedant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Datafromexcel {
    WebDriver driver;
    
    @BeforeSuite
    public void driversetup() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\vedan\\Desktop\\Roician\\Eclips\\HR\\chrome.exe");	
		driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openlink() {
        driver = new FirefoxDriver();
             driver.get("https://www.google.com/");
    }

    @DataProvider(name = "searchdata")
    public Object[][] getTestData() {
        Object[][] testData = null;
        try {
            FileInputStream excelFile = new FileInputStream("C:\\Users\\vedan\\Desktop\\vedant.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum();
          //  int columnCount = sheet.getRow(0).getLastCellNum();

            testData = new Object[rowCount][1]; // Each row will contain one search key

            for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header row
                Row row = sheet.getRow(i);
                testData[i - 1][0] = row.getCell(0).toString(); // Assuming the search key is in the first column
            }

            workbook.close();
        } catch (IOException e) {
           // e.printStackTrace();
            e.notifyAll();
        }

        return testData;
    }

    @Test(dataProvider = "searchdata")
    public void searchkeys(String keys) {
        driver.findElement(By.name("q")).sendKeys(keys); // Assuming the element is located by name attribute
    }

    @AfterMethod
    public void closebrowser() {
        driver.quit(); // Use quit() to close the browser and release resources
    }
}
