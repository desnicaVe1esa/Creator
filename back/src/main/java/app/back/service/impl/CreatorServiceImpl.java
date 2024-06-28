package app.back.service.impl;

import app.back.service.CodeTakerService;
import app.back.service.CreatorService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Создает папки с названием задачи, папки с названиями ЯП, на которых ее можно решить, код-заготовку для решения и
 * код-заготовку для тестов
 */

@Service
public class CreatorServiceImpl implements CreatorService {

    private CodeTakerService codeTakerService;

    private String className;
    private String testName;

    private final Logger logger = LoggerFactory.getLogger(CreatorServiceImpl.class);

    @Autowired
    public void setCodeTakerService(CodeTakerService codeTakerService) {
        this.codeTakerService = codeTakerService;
    }

    public CreatorServiceImpl() {

    }


/*--------------------------------------------------- Deprecated -------------------------------------------------------
    Зеленый цвет текста вывода в консоль
    public static final String ANSI_GREEN = "\u001B[32m";
    Сброс цветв текста вывода в консоль
    public static final String ANSI_RESET = "\u001B[0m";
----------------------------------------------------------------------------------------------------------------------*/


    /**
     * Запуск скрипта
     */
    public void start(String id, List<String> languages) {
        String urlApi = "https://www.codewars.com/api/v1/code-challenges/" + id;
        String screenshot = "https://www.codewars.com/kata/" + id + "/train/";
        parser(urlApi, screenshot, languages);
    }

    /**
     * Парсер страницы с задачей
     */
    private void parser(String urlApi, String screenshot, List<String> languages) {
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

        /* Контейнер для содержимого URL */
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

/*--------------------------------------------------- Deprecated -------------------------------------------------------
        String languages = data.get("languages").toString();
        Контейнер для ЯП, на которых можно решить задачу (добавить в фильтр нужные ЯП)
        Разработан для содания папок под ЯП
        List<String> listLanguages = Stream.of(languages.substring(1, languages.length() - 1).split(",")).filter(f ->
                f.contains("java") ||
                        f.contains("javascript") ||
                        f.contains("groovy") ||
                        Манипуляция со строкой "javascript" используется для нормальной работы условных выражений,
                        когда в задаче имеется "java" и "javascript" в одном селекте.
                        Без этой манипуляции инициативу выбора всегда будет перехватывать "java"
                        f.contains("sql")).map(m -> m.replace("javascript", "js")).toList();
----------------------------------------------------------------------------------------------------------------------*/

        String title = data.get("slug").toString().replaceAll("-", "_");
        String rank = data.get("rank").toString();
        String kyuFromRank = rank.substring(rank.indexOf("name=") + 5, rank.indexOf(", color"));
        String[] arrForReverse = kyuFromRank.split(" ");
        String kyu = arrForReverse[1] + "_" + arrForReverse[0];
        /* Указать свой путь к папке с задачами */
        String folderPath = "C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\" + kyu + "\\" + title;
        foldersFilesCodeCreator(languages, folderPath, screenshot, kyu, title);
    }


    /**
     * Подготовка папок для решения задачи
     */
    private void foldersFilesCodeCreator(List<String> languages, String folderPath, String screenshot, String kyu, String title) {
        File folder;
        for (String language : languages) {
//             if (language.contains("java")) { // Deprecated
            folder = new File(folderPath + "\\" + (language.equals("javascript") ? "js" : language));
            if (!folder.exists()) {
                folder.mkdirs();
            }
            preparedCode(screenshot, folder, language, kyu, title);
/* ------------------------------------------------ Deprecated ---------------------------------------------------------
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
----------------------------------------------------------------------------------------------------------------------*/
        }
    }

    /**
     * Подготовка кода и тестов для решения задачи
     */
    private void preparedCode(String screenshot, File folder, String language, String kyu, String title) {

/*------------------------------------------------- Deprecated ---------------------------------------------------------
        String screenshotData = CodeTakerService.preparedData(screenshot, language);
----------------------------------------------------------------------------------------------------------------------*/

        Map<String, String> data = codeTakerService.preparedData(screenshot, language);
        String solution = data.get("Solution");
        String tests = data.get("Sample Tests");
        File solutionClass;
        File testClass;
        String dotClass = "." + language;
        String format = "";
        switch (language) {
            case "java", "groovy" -> {

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                String dotClass = language.equals("java") ? ".java" : ".groovy";
                String[] screenshotData = data.split("class");
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
----------------------------------------------------------------------------------------------------------------------*/
                try {
                    className = solution.substring(solution.indexOf("class") + 5, solution.indexOf("{")).trim();
                    testName = tests.substring(tests.indexOf("class") + 5, tests.indexOf("{")).trim();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("Некорректное считывание данных. Создайте шаблоны самостояельно");
                }

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                solutionClass = new File(folder, classString + ".java");
                testClass = new File(folder, testString + ".java");
----------------------------------------------------------------------------------------------------------------------*/

                solutionClass = new File(folder, className + dotClass);
                testClass = new File(folder, testName + dotClass);
                FileWriter createSolution;
                FileWriter createTest;
                try {
                    createSolution = new FileWriter(solutionClass);
                    createTest = new FileWriter(testClass);

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                createSolution.write("package " + kyu + "." + title + ".java;\n\npublic class " + classString + " {\n\t// Solution\n}");
                createTest.write("package " + kyu + "." + title + ".java;\n\npublic class " + testString + " {\n\t// Tests\n}");
----------------------------------------------------------------------------------------------------------------------*/

                    createSolution.write("package " + kyu + "." + title + dotClass + ";\n\n" + solution);
                    createTest.write("package " + kyu + "." + title + dotClass + ";\n\n" + tests);
                    createSolution.close();
                    createTest.close();
                } catch (Exception e) {

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                На случай неуспешного считывания текста с картинки
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
                У библиотеки selenium свой LOGGER SLF4J, поэтому для вывода цветных сообщений:
                System.err.println("Обнаружена ошибка библиотеки: " +
                        "при сканировании текста допущена синтаксическая ошибка в имени файла, " +
                        "имени папки или метке тома");
                System.out.println(ANSI_GREEN + "Соданы шаблоны с альтернативными именами" + ANSI_RESET);
----------------------------------------------------------------------------------------------------------------------*/

                    e.printStackTrace();
                }
            }
            case "javascript" -> {

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                String[] jsParsing = screenshotData.split("function");
                Название функции
                String name = jsParsing[1].substring(0, jsParsing[1].indexOf('(')).trim();
                Начальная структура функции
                String methodName = jsParsing[1].substring(0, jsParsing[1].indexOf('{')).trim();
----------------------------------------------------------------------------------------------------------------------*/

                /* Название функции */
                String name = solution.substring(solution.indexOf("function") + 8, solution.indexOf('(')).trim();
                solutionClass = new File(folder, name + ".js");
                testClass = new File(folder, name + "Test.js");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                    createSolution.write("function " + methodName + "{\n\t// Solution\n}\nmodule.exports = " +
                            name + ";");
----------------------------------------------------------------------------------------------------------------------*/

                    createSolution.write(solution + "\nmodule.exports = " +
                            name + ";");

/*------------------------------------------------- Deprecated ---------------------------------------------------------
                    createTest.write("{\n\t// Tests\n}");
----------------------------------------------------------------------------------------------------------------------*/

                    createTest.write(tests);
                    createSolution.close();
                    createTest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            default -> {
                format =
                        language.equals("sql") ? ".sql" :
                        language.equals("c") ? ".c" :
                        language.equals("cpp") ? ".cpp" :
                        language.equals("csharp") ? ".cs" :
                        language.equals("python") ? ".py" : ".shell";
                solutionClass = new File(folder, title + format);
                testClass = new File(folder, title + "_test" + format);
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);
                    createSolution.write(solution);
                    createTest.write(tests);
                    createSolution.close();
                    createTest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}