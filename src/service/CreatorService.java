package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
                        //Манипуляция со строкой "javascript" используется для нормальной работы switch case,
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
        String patternForJs = "^[a-zA-z]*\\(\\w+\\)$";
        String[] name = screenshotData.split(" ");
        List<String> javaGroovyClass = new ArrayList<>();
        String jsFunction = "";
        for (int i = 0; i < name.length; i++) {
            if (name[i].equals("class")) {
                javaGroovyClass.add(name[i + 1]);
            }
            if (name[i].matches(patternForJs)) {
                jsFunction = name[i];
            }
        }
        File solutionClass;
        File testClass;
        switch (language) {
            case "java" -> {
                solutionClass = new File(folder, javaGroovyClass.get(0) + ".java");
                testClass = new File(folder, javaGroovyClass.get(1) + ".java");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);
                    createSolution.write("package " + kyu + "." + title + ".java;\n\npublic class " + javaGroovyClass.get(0) + " {\n\t// Solution\n}");
                    createTest.write("package " + kyu + "." + title + ".java;\n\npublic class " + javaGroovyClass.get(1) + " {\n\t// Tests\n}");
                    createSolution.close();
                    createTest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "js" -> {
                solutionClass = new File(folder, jsFunction.substring(0, jsFunction.indexOf('(')) + ".js");
                testClass = new File(folder, jsFunction.substring(0, jsFunction.indexOf('(')) + "Test.js");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);
                    createSolution.write("function " + jsFunction + "{\n\t// Solution\n}\nmodule.exports = " +
                            jsFunction.substring(0, jsFunction.indexOf('(')) + ";");
                    createTest.write("{\n\t// Tests\n}");
                    createSolution.close();
                    createTest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "groovy" -> {
                solutionClass = new File(folder, javaGroovyClass.get(0) + ".groovy");
                testClass = new File(folder, javaGroovyClass.get(1) + ".groovy");
                try {
                    FileWriter createSolution = new FileWriter(solutionClass);
                    FileWriter createTest = new FileWriter(testClass);
                    createSolution.write("package " + kyu + "." + title + ".groovy;\n\nclass " + javaGroovyClass.get(0) + " {\n\t// Solution\n}");
                    createTest.write("package " + kyu + "." + title + ".groovy;\n\nclass " + javaGroovyClass.get(1) + " {\n\t// Tests\n}");
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
