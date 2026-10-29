import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class UiAutomatorTest {

    private AppiumDriver driver;
    private AndroidElements androidElements;



    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 8");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        androidElements = new AndroidElements(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void emptyFieldTest() {
        var expectedText = "Привет, UiAutomator!";

        androidElements.inputText.click();
        androidElements.inputText.sendKeys("  ");
        androidElements.btnChange.click();

        Assertions.assertEquals(expectedText, androidElements.changeText.getText());
    }

    @Test
    public void newActivityTest() {
        var textToSet = "привет";

        androidElements.inputText.click();
        androidElements.inputText.sendKeys(textToSet);
        androidElements.btnActivity.click();

        var activityText = androidElements.getActivityText(driver);
        Assertions.assertEquals(textToSet, activityText.getText());
    }
}