import service.Creator;

import java.io.IOException;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) throws IOException {
        //Добавить в 'challenge' ID или название задачи
        String challenge = "59325dc15dbb44b2440000af";
        String url = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        Creator creator = new Creator();
        creator.start(url);
    }
}
