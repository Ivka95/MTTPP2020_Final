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

public class TestThree {
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
    public void secondTest() throws InterruptedException{
        String gRating, newRating, finalLocation;
        int index, index2;
        setPage("HCL gaming portal");
        setElement("/html//div[@id='rso']//a[@href='https://www.hcl.hr/']/h3");
        Thread.sleep(2000);
        webDriver.navigate().to("https://www.hcl.hr/igre/");
        WebElement getLatestGamesElement = webDriver.findElement(By.xpath("//div[@id='container']//div[@class='main']"));
        gRating = getLatestGamesElement.getLocation().toString();
        index = gRating.indexOf(")");
        newRating = gRating.split("\\(", index-1)[1];
        index2 = gRating.indexOf(")");
        finalLocation = newRating.split("\\)", index2)[0];
        System.out.println("HCL gaming section is on: " + finalLocation);
        Assert.assertEquals(finalLocation, "159, 953");
    }

    @AfterMethod
    public void closeTest(){
        webDriver.quit();
    }
}