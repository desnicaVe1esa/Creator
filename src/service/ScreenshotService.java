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

    public static String preparedData(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1");
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);

        //Пауза для прогрузки страницы
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\task.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
        return ScreenshotService.takeTextFromPicture("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\task.png");
    }

    public static String takeTextFromPicture(String path) {
        File image = new File(path);
        ITesseract readTextFromImage = new Tesseract();

        //Путь к файлу eng.traineddata для чтения английского текста
        //Ссылка для скачивания скана нужного языка: https://github.com/tesseract-ocr/tessdata/blob/main/eng.traineddata
        readTextFromImage.setDatapath("C:\\Users\\seera\\IdeaProjects\\Creator\\src\\util");
        try {
            return readTextFromImage.doOCR(image);
        } catch (TesseractException e) {
            return e.getMessage();
        }
    }
}
