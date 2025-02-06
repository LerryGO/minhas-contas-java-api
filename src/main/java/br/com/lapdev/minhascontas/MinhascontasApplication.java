package br.com.lapdev.minhascontas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("dev")
public class MinhascontasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhascontasApplication.class, args);
	}

}
