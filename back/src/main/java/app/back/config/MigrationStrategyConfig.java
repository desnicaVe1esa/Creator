package app.back.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class MigrationStrategyConfig {

    private Flyway flyway;

    @Value("${spring.flyway.enabled}")
    private Boolean fwEnabled;

    @Autowired(required = false)
    public void setFlyway(Flyway flyway) {
        this.flyway = flyway;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbMigration() { if (fwEnabled) flyway.migrate();}
}
