package vedant;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.Table.Cell;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testng {
	WebDriver driver;
	SoftAssert obj;
	@BeforeSuite
	public void driversetup () {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
	}
	
	//@BeforeTest
	//public void Initialsetup() {
		
//	}
	
	@BeforeMethod
	public void openlink() {
		driver = new FirefoxDriver();
		obj= new SoftAssert();
		//driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=1,groups="title")
	public void gettitle() {
		String Title = driver.getTitle();
		System.out.println(Title);
		//Assert.assertEquals(Title, "Google");
		obj.assertEquals(Title, "Google");
		obj.assertAll();
	}
	

	@Test(priority=2, groups="verify")
	public void googlesearchdisplay() {
	Boolean b= driver.findElement(By.linkText("Images")).isDisplayed();
		System.out.println(b);
	}
	
	
	@Test (priority=3,groups="verify",dependsOnMethods= {"googlesearchdisplay"})
	public void gmaildisplay() {
	Boolean a= driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(a);
	}
	
	/*
	 * @DataProvider(name="searchdata11") public Object[][] vedant(){ return new
	 * Object[][] {{"vedant"},{"guddi"},{"Shubhlu"}}; }
	 */
	
	
	@Test(dataProvider="searchdata")
	public void searchkeys(String keys) {
	driver.findElement(By.id("APjFqb")).sendKeys(keys);
	}
	
	
	@DataProvider(name = "searchdata")
    public Object[][] getTestData() {
        Object[][] testData = null;
        try {
            FileInputStream excelFile = new FileInputStream("C:\\Users\\vedan\\Desktop\\vedant.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            testData = new Object[rowCount][1]; // Each row will contain one search key

            for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header row
                Row row = sheet.getRow(i);
                Cell cell = (Cell) row.getCell(0); // Assuming the search key is in the first column
                testData[i - 1][0] = cell.toString();
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	}

	

	
	