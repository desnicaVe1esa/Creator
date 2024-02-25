package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Stream;

/**
 * Создает папки с названием задачи, папки с названиями ЯП, на которых ее можно решить
 */

public class CreatorService {

    /**
     * Запуск скрипта
     */
    public void start(String urlApi, String screenshot) {
        parser(urlApi, screenshot);
    }

    /**
     * Парсер страницы с задачей
     */
    public void parser(String urlApi, String screenshot) {
        URL tasksUrl;
        URLConnection con;
        InputStream is = null;
        try {
            tasksUrl = new URL(urlApi);
            con = tasksUrl.openConnection();
            is = con.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Контейнер для содержимого URL
        StringBuilder json = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> data = gson.fromJson(json.toString(), type);
        String languages = data.get("languages").toString();

        //Контейнер для ЯП, на которых можно решить задачу (добавить в фильтр нужные ЯП)
        //Разработан для содания папок под ЯП
        List<String> listLanguages = Stream.of(languages.substring(1, languages.length() - 1).split(",")).filter(f ->
                f.contains("java") ||
                        f.contains("javascript") ||
                        f.contains("groovy") ||
                        //Манипуляция со строкой "javascript" используется для нормальной работы условных выражений,
                        //когда в задаче имеется "java" и "javascript" в одном селекте.
                        //Без этой манипуляции инициативу выбора всегда будет перехватывать "java"
                        f.contains("sql")).map(m -> m.replace("javascript", "js")).toList();

        String title = data.get("slug").toString().replaceAll("-", "_");
        String rank = data.get("rank").toString();
        String kyuFromRank = rank.substring(rank.indexOf("name=") + 5, rank.indexOf(", color"));
        String[] arrForReverse = kyuFromRank.split(" ");
        String kyu = arrForReverse[1] + "_" + arrForReverse[0];

        //Указать свой путь
        String PATH = "C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\" + kyu + "\\" + title;
        foldersFilesCodeCreator(listLanguages, PATH, screenshot, kyu, title);
    }


    /**
     * Подготовка папок для решения задачи
     */
    public void foldersFilesCodeCreator(List<String> languages, String folderPath, String screenshot, String kyu, String title) {
        File folder;
        for (String language : languages) {
            if (language.contains("java")) {
                folder = new File(folderPath + "\\java");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                preparedCode(screenshot, folder, "java", kyu, title);
            } else if (language.contains("js")) {
                folder = new File(folderPath + "\\js");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                preparedCode(screenshot, folder, "js", kyu, title);
            } else if (language.contains("groovy")) {
                folder = new File(folderPath + "\\groovy");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                preparedCode(screenshot, folder, "groovy", kyu, title);
            } else if (language.contains("sql")) {
                folder = new File(folderPath + "\\sql");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                preparedCode(screenshot, folder, "sql", kyu, title);
            }
        }
    }

    /**
     * Подготовка кода и тестов для решения задачи
     */
    public void preparedCode(String screenshot, File folder, String language, String kyu, String title) {
        String screenshotData = ScreenshotService.preparedData(screenshot, language);
        File solutionClass;
        File testClass;
        switch (language) {
            case "java" -> {
                String[] classAndTest = screenshotData.split("class");
                String classString;
                String testString;
                //На случай неуспешного считывания текста с картинки
                try {
                    classString = classAndTest[1].substring(0, classAndTest[1].indexOf('{')).trim();
                    testString = classAndTest[2].substring(0, classAndTest[2].indexOf('{')).trim();
                } catch (Exception e) {
                    classString = "Solution";
                    testString = "SolutionTests";
                }
                solutionClass = new File(folder, classString + ".java");
                testClass = new File(folder, testString + ".java");
                FileWriter createSolution;
                FileWriter createTest;
                try {
                    createSolution = new FileWriter(solutionClass);
                    createTest = new FileWriter(testClass);
                    createSolution.write("package " + kyu + "." + title + ".java;\n\npublic class " + classString + " {\n\t// Solution\n}");
                    createTest.write("package " + kyu + "." + title + ".java;\n\npublic class " + testString + " {\n\t// Tests\n}");
                    createSolution.close();
                    createTest.close();
                } catch (Exception e) {
                    //На случай неуспешного считывания текста с картинки
                    try {
                        createSolution = new FileWriter(new File(folder, "Solution.java"));
                        createTest = new FileWriter(new File(folder, "SolutionTests.java"));
                        createSolution.write("package " + kyu + "." + title + ".java;\n\npublic class Solution {\n\t// Solution\n}");
                        createTest.write("package " + kyu + "." + title + ".java;\n\npublic class SolutionTests {\n\t// Tests\n}");
                        createSolution.close();
                        createTest.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
            case "js" -> {
                String[] jsParsing = screenshotData.split("function");
                //Название функции
                String name = jsParsing[1].substring(0, jsParsing[1].indexOf('(')).trim();
                //Начальная труктура функции
                String methodName = jsParsing[1].substring(0, jsParsing[1].indexOf('{')).trim();
                solutionClass = new File(folder, name + ".js");
                testClass = new File(folder, name + "Test.js");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);
                    createSolution.write("function " + methodName + "{\n\t// Solution\n}\nmodule.exports = " +
                            name + ";");
                    createTest.write("{\n\t// Tests\n}");
                    createSolution.close();
                    createTest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "groovy" -> {
                String[] classAndTest = screenshotData.split("class");
                String classString = classAndTest[1].substring(0, classAndTest[1].indexOf('{')).trim();
                String testString = classAndTest[2].substring(0, classAndTest[2].indexOf('{')).trim();
                solutionClass = new File(folder, classString + ".groovy");
                testClass = new File(folder, testString + ".groovy");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);
                    createSolution.write("package " + kyu + "." + title + ".groovy;\n\nclass " + classString +
                            " {\n\t// Solution\n}");
                    createTest.write("package " + kyu + "." + title + ".groovy;\n\nclass " + testString +
                            " {\n\t// Tests\n}");
                    createSolution.close();
                    createTest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "sql" -> {
                solutionClass = new File(folder, title + ".sql");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    createSolution.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
