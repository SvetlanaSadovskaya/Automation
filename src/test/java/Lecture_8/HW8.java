package Lecture_8;

import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HW8 extends BaseTest {

    @Test(priority = 1)
    public void checkList() {
        driver.get("C:\\Sveta TMS\\Automation\\src\\test\\java\\Lecture_8\\Lecture_8.html");
        List<String> firstColVals = new ArrayList<>();

        firstColVals.add(driver.findElement(By.id("c1")).getText());
        firstColVals.add(driver.findElement(By.id("c2")).getText());
        firstColVals.add(driver.findElement(By.id("c3")).getText());
        firstColVals.add(driver.findElement(By.id("c4")).getText());
        firstColVals.add(driver.findElement(By.id("c5")).getText());
        for (String el :
                firstColVals) {
            System.out.println(el);
        }
    }

    @Test(priority = 2)
    public void checkValueOn() {
        // ввести значение в поле ввода
        driver.findElement(By.id("text-input")).sendKeys("Австралия");
        driver.findElement(By.id("text-input")).sendKeys("Азия");
        driver.findElement(By.id("text-input")).sendKeys("Америка");
        // кликнуть чекбокс
        driver.findElement(By.id("checkbox")).click();
        // кликнуть на кнопку
        driver.findElement(By.id("button")).click();
        // выбрать элемент из списка
        WebElement PartsOfTheWorld = driver.findElement(By.id("parts"));
        Select selectPart = new Select(PartsOfTheWorld);
        selectPart.selectByValue("australia");
        driver.findElement(By.id("c1")).click();
        // проверить, что картинка существует
        Assert.assertTrue(driver.findElement(By.name("blablabla")).isEnabled());
        //проверить текст тега p
        Assert.assertEquals(driver.findElement(By.id("manager")).getText(), "С вами свяжется наш менеджер.");
        // кликнуть на ссылку и проверить, что новая страница была открыта
        driver.findElement(By.tagName("a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.w3schools.com/");
    }
}
