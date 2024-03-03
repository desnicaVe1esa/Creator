package service;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*------------------------------------------------ Deprecated ---------------------------------------------------------
Делает скрин страницы и считывает с него текст

public class ScreenshotService {
----------------------------------------------------------------------------------------------------------------------*/

/** Получение кода со страницы */

public class CodeTakerService {

    public static Map<String, String> preparedData(String url, String language) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("force-device-scale-factor=1");
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        WebDriver driver = new EdgeDriver(options);

        /** Манипуляция со строкой "javascript" используется для нормальной работы условных выражений,
        когда в задаче имеется "java" и "javascript" в одном селекте.
        Без этой манипуляции инициативу выбора всегда будет перехватывать "java" */
        language = language.equals("js") ? "javascript" : language;
        driver.get(url + language);

/*------------------------------------------------- Deprecated ---------------------------------------------------------
 //Для получения только правой части экрана
 //        WebElement rect = driver.findElement(By.tagName("body"));
----------------------------------------------------------------------------------------------------------------------*/

        /** Получение DOM'а */
        WebElement solutionCode = driver.findElement(By.id("code_container"));
        WebElement testsCode = driver.findElement(By.id("fixture_container"));

        //Пауза для прогрузки страницы
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

/*------------------------------------------------- Deprecated ---------------------------------------------------------
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            //Скрин полного экрана
////            FileUtils.copyFile(scrFile, new File("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\" + language + ".png"));
//            BufferedImage fullImg = ImageIO.read(scrFile);
//            //Скрин правой части экрана
////            BufferedImage rightPart = fullImg.getSubimage(rect.getWidth() / 2, 0, rect.getWidth() / 2, rect.getHeight());
//            ImageIO.write(fullImg, "png",
//                    new File("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\" + language + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
----------------------------------------------------------------------------------------------------------------------*/

        String solutionCodeText = solutionCode.getText().trim();
        String testsCodeText = testsCode.getText().trim();
        String[] solutionStrings = solutionCodeText.split("\n\\d*\n");
        String[] testStrings = testsCodeText.split("\n\\d*\n");
        StringBuilder solution = new StringBuilder();
        StringBuilder tests = new StringBuilder();
        Arrays.stream(solutionStrings).forEach(solution::append);
        Arrays.stream(testStrings).forEach(tests::append);
        Map<String, String> result = new HashMap<>();
        result.put("Solution", solution.toString().replace("Solution\n 1\n", ""));
        result.put("Sample Tests", tests.toString().replace("Sample Tests", ""));
        driver.quit();

/*------------------------------------------------- Deprecated ---------------------------------------------------------
        return ScreenshotService.takeTextFromPicture("C:\\Users\\seera\\IdeaProjects\\Creator\\screen\\" + language + ".png");
----------------------------------------------------------------------------------------------------------------------*/
        return result;
    }

/*------------------------------------------------- Deprecated ---------------------------------------------------------
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
----------------------------------------------------------------------------------------------------------------------*/

}
