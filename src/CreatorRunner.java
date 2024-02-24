import service.CreatorService;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) {
        //Добавить в 'challenge' ID или название задачи
        String challenge = "57cebe1dc6fdc20c57000ac9";
        String urlApi = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        String screenshot = "https://www.codewars.com/kata/" + challenge + "/train/";
        CreatorService creatorService = new CreatorService();
        creatorService.start(urlApi, screenshot);
    }
}
