package app.back.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextEventListener {

    @Value("${container.name}")
    private String containerName;

    /**
     * Остановка Docker-контейнера с БД после остановки приложения
     */
    @EventListener(ContextClosedEvent.class)
    public void stopDbContainer() {
        Runtime process = Runtime.getRuntime();
        try {
            process.exec("docker stop " + containerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

