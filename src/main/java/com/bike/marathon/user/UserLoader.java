package com.bike.marathon.user;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.marathon.csv.CSVReader;

@Service
public class UserLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoader.class);
	private static final String USERS_FILE_PATH = "src/main/resources/data/ALL_USERS_UTF-8.csv";
	private static final char COLUMN_SEPARATOR = ';';
	@Autowired
	private UserRepository userRepository;

	public void loadUsersToDB() throws IOException {
		CSVReader reader = new CSVReader();
		final List<CSVRecord> records = reader.getRecords(USERS_FILE_PATH, COLUMN_SEPARATOR);
		int faultyRecords = 0;
		int properRecords = 0;
		for (CSVRecord record : records) {
			try {
				User user = new User();
				user.setLastName(record.get(0));
				user.setFirstName(record.get(1));
				final String startNumber = replaceWhiteSpaces(record.get(2));
				user.setStartNumber(StringUtils.isNotBlank(startNumber) ? Long.valueOf(startNumber) : null);
				user.setAgeGroup(record.get(3));
				user.setElite("TAK".equals(record.get(4)));
				user.setCity(record.get(5));
				user.setTeam(record.get(6));
				user.setCountry(record.get(7));
				final String startSector = replaceWhiteSpaces(record.get(8)).replaceAll("z", "");
				user.setStartSector(StringUtils.isNotBlank(startSector) ? Long.valueOf(startSector) : 7L);
				userRepository.save(user);
				properRecords++;
			} catch (Exception e) {
				LOGGER.error(e.getMessage() + " --> " + record.toString());
				faultyRecords++;
			}
		}
		LOGGER.info("-------- " + properRecords + " user/s loaded to DB -------- ");
		LOGGER.info("-------- " + faultyRecords + " parse errors --------------- ");
	}

	private String replaceWhiteSpaces(String input){
		return Optional.of(input).orElse("").replaceAll(" ", "").replaceAll("\\u00A0", "");
	}

	public void insertSampleUserToDBAndRead(UserRepository userRepository) {
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

	}

}
