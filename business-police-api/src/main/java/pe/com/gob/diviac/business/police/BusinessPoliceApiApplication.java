package pe.com.gob.diviac.business.police;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "pe.com.gob.diviac.business.police.adapter.output.postgres.entity")
@EnableJpaRepositories(basePackages = "pe.com.gob.diviac.business.police.adapter.output.postgres.repository")
public class BusinessPoliceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessPoliceApiApplication.class, args);
	}
}
