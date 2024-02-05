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
 * и дефолтные классы с тестами для начала решения.
 */

public class Creator {

    public Creator() {
    }

    /**
     * Запуск скрипта
     */
    public void start(String url) throws IOException {
        parser(url);
    }

    /**
     * Парсер страницы с задачей
     */
    public void parser(String url) throws IOException {
        URL tasksUrl = new URL(url);
        URLConnection con = tasksUrl.openConnection();
        InputStream is = con.getInputStream();
        //Контейнер для содержимого URL
        StringBuilder json = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }
        }
        System.out.println(json);
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
                        f.contains("sql")).toList();

        String title = data.get("slug").toString().replaceAll("-", "_");
        String rank = data.get("rank").toString();
        String kyu = rank.substring(rank.indexOf("name=") + 5, rank.indexOf(", color"));

        //Указать свой путь
        String PATH = "C:\\Users\\seera\\IdeaProjects\\Codewars\\src";
        switch (kyu) {
            case "1 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_1", title);
                folder.mkdirs();
            }
            case "2 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_2", title);
                folder.mkdirs();
            }
            case "3 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_3", title);
                folder.mkdirs();
            }
            case "4 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_4", title);
                folder.mkdirs();
            }
            case "5 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_5", title);
                folder.mkdirs();
            }
            case "6 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_6", title);
                folder.mkdirs();
            }
            case "7 kyu" -> {
                File folder = new File("C:\\Users\\seera\\IdeaProjects\\Codewars\\src\\kyu_7", title);
                folder.mkdirs();
            }
            case "8 kyu" -> {
//                    foldersFilesCodeCreator(listLanguages, PATH + "\\kyu_8\\" + title, kyu, title/*"MyFile.java"*/);
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
//        //TODO получить стартовый код из инпутов 'Solution' и 'SampleTests' я хуй знает как
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
}
