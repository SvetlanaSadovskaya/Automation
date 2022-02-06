package Lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lecture_6 {
    private WebDriver driver;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12466677");
        driver.manage().window().setSize(new Dimension(1368, 912));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void aboveTest() {
        WebElement password = driver.findElement(By.name("password1"));
        driver.findElement(with(By.tagName("input")).above(password)).sendKeys("above");
    }

    @Test(priority = 2)
    public void belowTest() {
        WebElement password = driver.findElement(By.name("password1"));
        driver.findElement(with(By.tagName("input")).below(password)).click();
    }

    @Test(priority = 3)
    public void nearTest() {
        WebElement password = driver.findElement(By.name("password1"));
        System.out.println(driver.findElements(with(By.tagName("input")).near(password, 60)).size());
        System.out.println(driver.findElements(with(By.tagName("input")).near(password, 98)).size());
        System.out.println(driver.findElements(with(By.tagName("input")).near(password, 99)).size());
        driver.findElement(with(By.tagName("input")).near(password)).sendKeys("above");
    }

}