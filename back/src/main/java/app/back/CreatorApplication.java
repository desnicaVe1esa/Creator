package app.back;

import app.back.service.CreatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatorApplication.class, args);
	}

	@Bean(initMethod = "start")
	public CreatorService creatorStart() {
		return new CreatorService();
	}
}
