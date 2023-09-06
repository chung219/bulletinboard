package postgre.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import postgre.create.config.Config;

@Import(Config.class)
@SpringBootApplication(scanBasePackages = "postgre.create.web")
public class CreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateApplication.class, args);
	}

}
