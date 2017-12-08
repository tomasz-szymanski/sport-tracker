package com.bike.marathon.result;

import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.marathon.csv.CSVReader;
import com.bike.marathon.event.Event;
import com.bike.marathon.event.EventRepository;
import com.bike.marathon.user.User;
import com.bike.marathon.user.UserRepository;
import com.google.common.base.Preconditions;

@Service
public class ResultLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResultLoader.class);
	private static final String IMPORT_FILE = "src/main/resources/data/Obiszow_2017_results_MINI.csv";
	private static final char COLUMN_SEPARATOR = ';';
	private static final String NON_BREAKABLE_SPACE = "\\u00A0";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ResultRepository resultRepository;

	public void loadResultsToDB() throws IOException {
		CSVReader reader = new CSVReader();
		final List<CSVRecord> records = reader.getRecords(IMPORT_FILE, COLUMN_SEPARATOR);
		int faultyRecords = 0;
		int properRecords = 0;


		for (CSVRecord record : records) {
//			try {

				final String lp = record.get(0);
				final String startNumber = record.get(1);
				final String sex = record.get(2);
				final String yearOfBirth = record.get(3);
				final String ageGroup = record.get(4);
				final String time = record.get(5);

//				System.out.println(String.format("| %s | %s | %s | %s | %s | %s |",
//					lp, startNumber, sex, yearOfBirth, ageGroup, time));

				List<User> users = userRepository.findByStartNumber(Long.valueOf(replaceWhiteSpaces(startNumber)));
				Preconditions.checkNotNull(users, "Unable to load users for number", startNumber);
				Preconditions.checkArgument(users.size() > 0, "Unable to find user with start number {}", startNumber);
				User user = users.get(0);

				final List<Event> events = eventRepository.findByCity("Obiszów");
				Event event = events.get(0);

				Result result = new Result();
				result.setEvent(event);
				result.setUser(user);
				result.setStartTime(Time.valueOf(time));
				final Result save = resultRepository.save(result);
				resultRepository.save(save);

				properRecords++;
//			} catch (Exception e) {
//				LOGGER.error(e.getMessage() + " --> " + record.toString());
//				faultyRecords++;
//			}
		}
		LOGGER.info("-------- " + properRecords + " results/s loaded to DB -------- ");
		LOGGER.info("-------- " + faultyRecords + " parse errors --------------- ");
	}

	private String replaceWhiteSpaces(String input){
		return Optional.of(input).orElse("").replaceAll(" ", "").replaceAll(NON_BREAKABLE_SPACE, "");
	}

}
