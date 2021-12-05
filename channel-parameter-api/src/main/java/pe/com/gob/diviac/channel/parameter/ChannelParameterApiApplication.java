package pe.com.gob.diviac.channel.parameter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client")
public class ChannelParameterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChannelParameterApiApplication.class, args);
	}

}

