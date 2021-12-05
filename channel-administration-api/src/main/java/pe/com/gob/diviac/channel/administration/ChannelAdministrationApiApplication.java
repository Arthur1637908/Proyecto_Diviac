package pe.com.gob.diviac.channel.administration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "pe.com.gob.diviac.channel.administration.adapter.output.http.common.client")
public class ChannelAdministrationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChannelAdministrationApiApplication.class, args);
	}

}
