package service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Делает скрин страницы
 */

public class ScreenshotService {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("force-device-scale-factor=0.50");
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.codewars.com/users/desnicaVe1esa");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\seera\\IdeaProjects\\Creator\\screens\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
