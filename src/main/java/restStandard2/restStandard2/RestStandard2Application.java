package restStandard2.restStandard2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestStandard2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestStandard2Application.class, args);
	}

}
