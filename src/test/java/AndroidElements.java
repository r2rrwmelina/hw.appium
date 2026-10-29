import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidElements {

    public WebElement inputText;
    public WebElement btnChange;
    public WebElement changeText;
    public WebElement btnActivity;

    public AndroidElements(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.inputText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.netology.testing.uiautomator:id/userInput")));
        this.btnChange = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.netology.testing.uiautomator:id/buttonChange")));
        this.changeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.netology.testing.uiautomator:id/textToBeChanged")));
        this.btnActivity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.netology.testing.uiautomator:id/buttonActivity")));
    }

    public WebElement getActivityText(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.netology.testing.uiautomator:id/text")));
    }
}