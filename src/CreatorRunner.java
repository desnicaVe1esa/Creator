import service.CreatorService;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) {
        //Добавить в 'challenge' ID или название задачи
        String challenge = "53da3dbb4a5168369a0000fe";
        String urlApi = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        String screenshot = "https://www.codewars.com/kata/" + challenge + "/train/";
        CreatorService creatorService = new CreatorService();
        creatorService.start(urlApi, screenshot);
    }
}
