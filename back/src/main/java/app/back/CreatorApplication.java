package app.back;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatorApplication.class, args);
	}

	/* -- Used before the creation of the front --
	@Bean(initMethod = "start")
	public CreatorService creatorStart() {
		return new CreatorService();
	}
	-------------------------------------------- */
}
