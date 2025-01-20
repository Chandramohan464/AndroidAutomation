package android.automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorEmulator {
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability("appium:deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:appPackage","com.android.calculator2");
        capabilities.setCapability("appium:appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("appium:platformVersion","8.1.0");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("Automation Started");
    }

    @Test
    public void additionTest() throws InterruptedException {
        WebElement element2=driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        WebElement elementPlus=driver.findElement(AppiumBy.accessibilityId("plus"));
        WebElement element3=driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        WebElement elementEqual=driver.findElement(AppiumBy.accessibilityId("equals"));
        WebElement elementResult=driver.findElement(By.id("com.android.calculator2:id/result"));

        element2.click();
        Thread.sleep(3000);
        elementPlus.click();
        Thread.sleep(3000);
        element3.click();
        Thread.sleep(3000);
        elementEqual.click();
        Thread.sleep(3000);

        String actualResult=elementResult.getText();
        Assert.assertEquals(actualResult,"5","Addition process is incorrect");
    }

    @Test
    public void testSubtraction() throws InterruptedException {
        WebElement digit7 = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        WebElement digit5 = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        WebElement minus = driver.findElement(AppiumBy.accessibilityId("minus"));
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));

        digit7.click();
        Thread.sleep(3000);
        minus.click();
        Thread.sleep(3000);
        digit5.click();
        Thread.sleep(3000);
        equals.click();
        Thread.sleep(3000);

        String actualResult = result.getText();
        Assert.assertEquals(actualResult, "2", "Subtraction result is incorrect!");
    }

    @Test
    public void testMultiplication() throws InterruptedException {
        WebElement digit6 = driver.findElement(By.id("com.android.calculator2:id/digit_6"));
        WebElement digit4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        WebElement multiply = driver.findElement(By.id("com.android.calculator2:id/op_mul"));
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));

        digit6.click();
        Thread.sleep(3000);
        multiply.click();
        Thread.sleep(3000);
        digit4.click();
        Thread.sleep(3000);
        equals.click();
        Thread.sleep(3000);

        String actualResult = result.getText();
        Assert.assertEquals(actualResult, "24", "Multiplication result is incorrect!");
    }

    @Test
    public void testDivision() throws InterruptedException {
        WebElement digit8 = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        WebElement digit2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        WebElement divide = driver.findElement(AppiumBy.accessibilityId("divide"));
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));

        digit8.click();
        Thread.sleep(3000);
        divide.click();
        Thread.sleep(3000);
        digit2.click();
        Thread.sleep(3000);
        equals.click();
        Thread.sleep(3000);

        String actualResult = result.getText();
        Assert.assertEquals(actualResult, "4", "Division result is incorrect!");
    }


    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
