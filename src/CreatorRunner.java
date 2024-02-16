import service.CreatorService;

import java.io.IOException;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) throws IOException {
        //Добавить в 'challenge' ID или название задачи
        String challenge = "596ef174e4cab6813600004d";
        String url = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        CreatorService creatorService = new CreatorService();
        creatorService.start(url);
    }
}
