package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Attachments {
    @Attachment(value = "{1}", type = "image/png")
    public static byte[] getScreenshot(WebDriver driver, String screenshotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
