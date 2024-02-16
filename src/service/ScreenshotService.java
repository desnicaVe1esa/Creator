package service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Делает скрин страницы и считывает с него текст
 */

public class ScreenshotService {

    public static void main(String[] args) throws InterruptedException, TesseractException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1");
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.codewars.com/kata/596ef174e4cab6813600004d/train/java");
        TimeUnit.SECONDS.sleep(2);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\task.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
        String test = ScreenshotService.takeTextFromPicture("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\task.png");
        System.out.println(test);
    }

    public static String takeTextFromPicture(String path) throws TesseractException {
        File image = new File(path);
        ITesseract tesseract = new Tesseract();
        //Путь к файлу eng.traineddata для чтения английского текста
        //Ссылка для скачивания скана нужного языка: https://github.com/tesseract-ocr/tessdata/blob/main/eng.traineddata
        tesseract.setDatapath("C:\\Users\\seera\\IdeaProjects\\Creator\\src\\util");
        return tesseract.doOCR(image);
    }
}
