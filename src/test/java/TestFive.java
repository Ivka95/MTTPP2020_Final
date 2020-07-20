import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestFive {
    public WebDriver webDriver;
    public String tURL = "http://www.google.com";

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
    public void fourthTest() throws InterruptedException{
        String testTag;
        setPage("HCL gaming portal");
        setElement("/html//div[@id='rso']//a[@href='https://www.hcl.hr/']/h3");
        WebElement searchHCL = webDriver.findElement(By.name("s"));
        searchHCL.sendKeys("Spider-man");
        searchHCL.submit();
        Thread.sleep(3000);
        WebElement testElement = webDriver.findElement(By.xpath("//div[@id='container']/div[@class='boxContainer']//h3[.='Rezultati pretrage za: Spider-man']"));
        testTag = testElement.getTagName();
        Assert.assertEquals(testTag, "h3");
        System.out.println("Tag name: " + testTag);
    }

    @AfterMethod
    public void closeTest(){
        webDriver.quit();
    }
}
