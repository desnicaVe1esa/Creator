import service.Creator;

import java.io.IOException;

/**
 * Запуск Creator'а
 */

public class CreatorRunner {
    public static void main(String[] args) throws IOException {
        //Добавить в 'challenge' ID или название задачи
        String challenge = "541c8630095125aba6000c00";
        String url = "https://www.codewars.com/api/v1/code-challenges/" + challenge;
        Creator creator = new Creator();
        creator.start(url);
    }
}
