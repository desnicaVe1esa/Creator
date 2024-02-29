package service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Делает скрин страницы и считывает с него текст
 */

public class ScreenshotService {

    public static String preparedData(String url, String language) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("force-device-scale-factor=1");
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        WebDriver driver = new EdgeDriver(options);

        //Манипуляция со строкой "javascript" используется для нормальной работы условных выражений,
        //когда в задаче имеется "java" и "javascript" в одном селекте.
        //Без этой манипуляции инициативу выбора всегда будет перехватывать "java"
        language = language.equals("js") ? "javascript" : language;
        driver.get(url + language);

        //Пауза для прогрузки страницы
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            BufferedImage fullImg = ImageIO.read(scrFile);
            ImageIO.write(fullImg, "png",
                    new File("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\" + language + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
        return ScreenshotService.takeTextFromPicture("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\" + language + ".png");
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
