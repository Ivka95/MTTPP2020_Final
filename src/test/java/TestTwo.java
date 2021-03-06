import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestTwo {
    public WebDriver webDriver;
    public String tURL = "http://www.google.com";
    public String testURL;

    @BeforeMethod
    public void setTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to(tURL);
        webDriver.manage().window().maximize();
    }

    void setPage(String Text){
        WebElement search = webDriver.findElement(By.name("q"));
        search.sendKeys(Text);
        search.submit();
    }
    void setElement(String XPATH){
        WebElement newElement = webDriver.findElement(By.xpath(XPATH));
        newElement.click();
    }

    @Test
    public void thirdTest() throws InterruptedException{
        setPage("HCL gaming portal");
        String tURL = "https://www.hcl.hr/";
        webDriver.navigate().to(tURL);
        webDriver.navigate().back();
        webDriver.navigate().back();
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.clear();
        setPage("Hrvatski gaming portal");
        setElement("/html//div[@id='rso']//a[@href='https://www.hcl.hr/']/h3");
        testURL = webDriver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(testURL, tURL);
        System.out.print("\nURL test: " + testURL);
    }

    @AfterMethod
    public void closeTest(){
        webDriver.quit();
    }
}