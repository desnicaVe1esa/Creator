import service.CreatorService;

import java.io.IOException;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) throws IOException {
        //Добавить в 'challenge' ID или название задачи
        String challenge = "57d6b40fbfcdc5e9280002ee";
        String url = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        CreatorService creatorService = new CreatorService();
        creatorService.start(url);
    }
}
