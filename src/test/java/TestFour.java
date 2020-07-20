import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestFour {
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
    public void fifthTest() throws InterruptedException{
        setPage("HCL gaming portal");
        setElement("/html//div[@id='rso']//a[@href='https://www.hcl.hr/']/h3");
        WebElement testSize = webDriver.findElement(By.xpath("//div[@id='mainContainer']/div[5]//div[@class='hcl-logo']"));
        String tSize = testSize.getSize().toString();
        System.out.println("HCL test size: " + tSize);
        Thread.sleep(3000);
        webDriver.navigate().to(tURL);
        webDriver.navigate().back();
        webDriver.navigate().back();
        Thread.sleep(3000);
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.clear();
        setPage("Hrvatski gaming portal");
        setElement("/html//div[@id='rso']//a[@href='https://www.hcl.hr/']/h3");
        WebElement realSize = webDriver.findElement(By.xpath("//div[@id='mainContainer']/div[5]//div[@class='hcl-logo']"));
        String rSize = realSize.getSize().toString();
        System.out.println("HCL real size: " + rSize);
        Thread.sleep(3000);
        Assert.assertEquals(rSize, tSize);
        System.out.println("HCL final size: " + rSize);
    }

    @AfterMethod
    public void closeTest(){
        webDriver.quit();
    }
}

