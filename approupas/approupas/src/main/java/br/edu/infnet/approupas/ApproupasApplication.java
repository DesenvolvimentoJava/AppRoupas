package br.edu.infnet.approupas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApproupasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApproupasApplication.class, args);
	}

}
