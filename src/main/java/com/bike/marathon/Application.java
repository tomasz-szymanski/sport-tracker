package com.bike.marathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bike.marathon.user.UserLoader;

@SpringBootApplication
@EntityScan(basePackages = {"com.bike.marathon.user"})
@EnableJpaRepositories(basePackages = {"com.bike.marathon.user"})
public class Application {

	private final UserLoader userLoader;

	@Autowired
	public Application(UserLoader userLoader) {
		this.userLoader = userLoader;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> userLoader.loadUsersToDB();
	}





}
