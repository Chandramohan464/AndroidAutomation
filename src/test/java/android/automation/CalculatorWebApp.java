package android.automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorWebApp {
    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName","emulator-5554");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("browserName", "Chrome");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        driver.get("https://www.calculator.net/");
    }

    @Test
    public void additionTest() throws InterruptedException {
        WebElement element2 = driver.findElement(AppiumBy.xpath("//span[text()='2']"));
        WebElement elementPlus = driver.findElement(AppiumBy.xpath("//span[text()='+']"));
        WebElement element3 = driver.findElement(AppiumBy.xpath("//span[text()='3']"));
        WebElement elementEqual = driver.findElement(AppiumBy.xpath("//span[text()='=']"));
        WebElement elementResult = driver.findElement(AppiumBy.id("sciOutPut"));

        element2.click();
        Thread.sleep(1000);
        elementPlus.click();
        Thread.sleep(1000);
        element3.click();
        Thread.sleep(1000);
        elementEqual.click();
        Thread.sleep(1000);

        String actualResult = elementResult.getText().trim();
        Assert.assertEquals(actualResult, "5", "Addition process is incorrect");
    }

    @Test
    public void testSubtraction() throws InterruptedException {
        WebElement digit7 = driver.findElement(AppiumBy.xpath("//span[text()='7']"));
        WebElement digit5 = driver.findElement(AppiumBy.xpath("//span[text()='5']"));
        WebElement minus = driver.findElement(AppiumBy.xpath("//span[text()='−']"));
        WebElement equals = driver.findElement(AppiumBy.xpath("//span[text()='=']"));
        WebElement result = driver.findElement(AppiumBy.id("sciOutPut"));

        digit7.click();
        Thread.sleep(1000);
        minus.click();
        Thread.sleep(1000);
        digit5.click();
        Thread.sleep(1000);
        equals.click();
        Thread.sleep(1000);

        String actualResult = result.getText().trim();
        Assert.assertEquals(actualResult, "2", "Subtraction result is incorrect!");
    }

    @Test
    public void testMultiplication() throws InterruptedException {
        WebElement digit6 = driver.findElement(AppiumBy.xpath("//span[text()='6']"));
        WebElement digit4 = driver.findElement(AppiumBy.xpath("//span[text()='4']"));
        WebElement multiply = driver.findElement(AppiumBy.xpath("//span[text()='×']"));
        WebElement equals = driver.findElement(AppiumBy.xpath("//span[text()='=']"));
        WebElement result = driver.findElement(AppiumBy.id("sciOutPut"));

        digit6.click();
        Thread.sleep(1000);
        multiply.click();
        Thread.sleep(1000);
        digit4.click();
        Thread.sleep(1000);
        equals.click();
        Thread.sleep(1000);

        String actualResult = result.getText().trim();
        Assert.assertEquals(actualResult, "24", "Multiplication result is incorrect!");
    }

    @Test
    public void testDivision() throws InterruptedException {
        WebElement digit8 = driver.findElement(AppiumBy.xpath("//span[text()='8']"));
        WebElement digit2 = driver.findElement(AppiumBy.xpath("//span[text()='2']"));
        WebElement divide = driver.findElement(AppiumBy.xpath("//span[text()='÷']"));
        WebElement equals = driver.findElement(AppiumBy.xpath("//span[text()='=']"));
        WebElement result = driver.findElement(AppiumBy.id("sciOutPut"));

        digit8.click();
        Thread.sleep(1000);
        divide.click();
        Thread.sleep(1000);
        digit2.click();
        Thread.sleep(1000);
        equals.click();
        Thread.sleep(1000);

        String actualResult = result.getText().trim();
        Assert.assertEquals(actualResult, "4", "Division result is incorrect!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
