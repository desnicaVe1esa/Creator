package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
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
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> data = gson.fromJson(json.toString(), type);
        String languages = data.get("languages").toString();

        //Контейнер для ЯП, на которых можно решить задачу (добавить в фильтр нужные ЯП)
        //Разработан для содания папок под ЯП
        List<String> listLanguages = Stream.of(languages.substring(1, languages.length() - 1).split(",")).filter(f ->
                f.contains("java") ||
                        f.contains("javascript") ||
                        f.contains("groovy") ||
                        f.contains("sql")).toList();

        String title = data.get("slug").toString().replaceAll("-", "_");
        String rank = data.get("rank").toString();
        String kyuFromRank = rank.substring(rank.indexOf("name=") + 5, rank.indexOf(", color"));
        String[] arrForReverse = kyuFromRank.split(" ");
        String kyu = arrForReverse[1] + "_" + arrForReverse[0];

        //Указать свой путь
        String PATH = "C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\" + kyu + "\\" + title;
        foldersFilesCodeCreator(listLanguages, PATH, screenshot);
    }


    /**
     * Подготовка папок для решения задачи
     */
    public void foldersFilesCodeCreator(List<String> languages, String folderPath, String screenshot) {
        File folder = new File(folderPath + "\\java");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        preparedCode(screenshot, folder, "java");
        for (String check : languages) {
            if (check.contains("javascript")) {
                folder = new File(folderPath + "\\js");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
            } else if (check.contains("groovy")) {
                folder = new File(folderPath + "\\groovy");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
            } else if (check.contains("sql")) {
                folder = new File(folderPath + "\\sql");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
            }
        }
    }

    /**
     * Подготовка кода и тестов для решения задачи
     */
    public void preparedCode (String screenshot, File folder, String language) {
        String screenshotData = ScreenshotService.preparedData(screenshot + language);
        //TODO получить стартовый код из screenshotData 'Solution' и 'SampleTests'
        File solutionClass = new File(folder, "");
        try {
            FileWriter createCode = new FileWriter(solutionClass);
//            createCode.write(codeCreator("java", kyu, title));
            createCode.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
//
//    /**
//     * Подготовка папок, файлов и стартового кода для решения задачи
//     */
//    public void foldersFilesCodeCreator(List<String> languages, String folderPath, String kyu, String title) {
//
//        try {
//            File folder = new File(folderPath + "\\java");
//            if (!folder.exists()) {
//                folder.mkdirs();
//            }
//            File object = new File(folder, filesCreator("java", title));
//            FileWriter code = new FileWriter(object);
//            code.write(codeCreator("java", kyu, title));
//            code.close();
//            for (String check : languages) {
//                if (check.contains("javascript")) {
//                    folder = new File(folderPath + "\\js");
//                    if (!folder.exists()) {
//                        folder.mkdirs();
//                    }
//                    object = new File(folder, filesCreator("js", title));
//                    code = new FileWriter(object);
//                    code.write(codeCreator("js", kyu, title));
//                    code.close();
//                } else if (check.contains("groovy")) {
//                    folder = new File(folderPath + "\\groovy");
//                    if (!folder.exists()) {
//                        folder.mkdirs();
//                    }
//                    object = new File(folder, filesCreator("groovy", title));
//                    code = new FileWriter(object);
//                    code.write(codeCreator("groovy", kyu, title));
//                    code.close();
//                } else if (check.contains("sql")) {
//                    folder = new File(folderPath + "\\sql");
//                    if (!folder.exists()) {
//                        folder.mkdirs();
//                    }
//                    object = new File(folder, filesCreator("sql", title));
//                    code = new FileWriter(object);
//                    code.write(codeCreator("sql", kyu, title));
//                    code.close();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String filesCreator(String objectType, String title) {
//        switch (objectType) {
//            case "java" -> {
//                return "Test.java";
//            }
//            case "js" -> {
//            }
//            case "groovy" -> {
//            }
//            case "sql" -> {
//            }
//        }
//        return "";
//    }
//
//    public String codeCreator(String objectType, String kyu, String title) {
//
//        String kyuDigit = String.valueOf(kyu.charAt(0));
//        switch (objectType) {
//            case "java" -> {
//                return "package kyu_" + kyuDigit + "." + title + ".java;\n\npublic class MyFile {\n\t// File content here\n}";
//            }
//            case "js" -> {
//            }
//            case "groovy" -> {
//            }
//            case "sql" -> {
//            }
//        }
//        return "\"package kyu_8.\" + title + \".java;\\n\\npublic class MyFile {\\n\\t// File content here\\n}\"";
}
