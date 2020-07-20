import com.sun.org.apache.xpath.internal.operations.Gte;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestOne {
    public WebDriver webDriver;
    public String gText;
    public String startURL = "http://www.google.com";

    @BeforeMethod
    public void setTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to(startURL);
        webDriver.manage().window().maximize();
    }

    void setPage(String Text){
        WebElement search = webDriver.findElement(By.name("q"));
        search.sendKeys(Text);
        search.submit();
    }

    @Test
    public void firstTest() throws InterruptedException{
        setPage("HCL gaming portal");
        WebElement testPath = webDriver.findElement(By.xpath("/html//div[@id='rso']//a[@href='https://www.hcl.hr/']/h3"));
        gText = testPath.getText();
        Thread.sleep(3000);
        Assert.assertEquals(gText, "HCL Gaming Portal - recenzije, vijesti i više za esports, igre i ...");
        System.out.println("Best CRO info gaming website: " + gText);
    }

    @AfterMethod
    public void closeTest(){
        webDriver.quit();
    }
}

