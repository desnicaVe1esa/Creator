import service.CreatorService;

import java.io.IOException;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) {
        //"https://www.codewars.com/kata/596ef174e4cab6813600004d/train/java"
        //Добавить в 'challenge' ID или название задачи
        String challenge = "596ef174e4cab6813600004d";
        String urlApi = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        String screenshot = "https://www.codewars.com/kata/" + challenge + "/train/";
        CreatorService creatorService = new CreatorService();
        creatorService.start(urlApi, screenshot);
    }
}
