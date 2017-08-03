package com.bike.marathon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bike.marathon.user.User;
import com.bike.marathon.user.UserRepository;

@SpringBootApplication
@EntityScan(basePackages = {"com.bike.marathon.user"})
@EnableJpaRepositories(basePackages = {"com.bike.marathon.user"})
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo (UserRepository userRepository){
    	return (args) -> {
			User userToAdd = new User();
			userToAdd.setFirstName("Tomasz");
			userToAdd.setLastName("Szymański");
			userToAdd.setStartNumber(3620L);
			userToAdd.setCity("Wrocław");
			userToAdd.setCountry("POL");
			userToAdd.setAgeGroup("M3");
			userToAdd.setTeam("");

			userRepository.save(userToAdd);

			LOGGER.info("-------- Find all -------- ");
			final Iterable<User> users = userRepository.findAll();

			for (User user : users) {
				LOGGER.info(user.toString());
			}
			LOGGER.info("-------- Find by start number -------- ");
			final User byStartNumber = userRepository.findByStartNumber(3620L);
			LOGGER.info(byStartNumber.toString());

		};
	}




}
